package com.mycompany.ag4;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

public class Server {
    private static Set<ClientHandler> clientHandlers = ConcurrentHashMap.newKeySet();
    private static Set<String> clientNames = ConcurrentHashMap.newKeySet();
    private static Map<String, List<String>> clientMessages = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Server");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JButton exitButton = new JButton("Exit");

        JPanel panel = new JPanel();
        panel.add(exitButton);

        frame.add(new JScrollPane(textArea));
        frame.getContentPane().add(panel, "North");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        int port = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter server port:"));

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            String serverIP = InetAddress.getLocalHost().getHostAddress();
            textArea.append("Server started on IP: " + serverIP + " Port: " + port + "\n");

            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket, textArea);
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            textArea.append("Error starting server: " + e.getMessage() + "\n");
        }

        exitButton.addActionListener(e -> {
            try {
                for (ClientHandler clientHandler : clientHandlers) {
                    clientHandler.sendMessage("Server is shutting down. Goodbye!");
                    clientHandler.closeConnection();
                }
                textArea.append("Server has been shut down.\n");
                frame.dispose();
                System.exit(0);
            } catch (Exception ex) {
                textArea.append("Error closing connections: " + ex.getMessage() + "\n");
            }
        });
    }

    public static boolean addClientName(String name) {
        synchronized (clientNames) {
            if (name.length() >= 5 && !clientNames.contains(name)) {
                clientNames.add(name);
                clientMessages.put(name, new ArrayList<>());
                return true;
            }
            return false;
        }
    }

    public static void removeClient(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
        String clientName = clientHandler.getClientName();
        clientNames.remove(clientName);
        broadcast("REMOVE_MESSAGES:" + clientName);
        clientMessages.remove(clientName);
    }

    public static void broadcast(String message) {
        for (ClientHandler clientHandler : clientHandlers) {
            clientHandler.sendMessage(message);
        }
    }

    public static void storeMessage(String clientName, String message) {
        List<String> messages = clientMessages.get(clientName);
        if (messages != null) {
            messages.add(message);
        }
    }

    public static List<String> getMessagesForClient(String clientName) {
        return clientMessages.getOrDefault(clientName, new ArrayList<>());
    }

    public static void removeMessagesForClient(String clientName) {
        clientMessages.remove(clientName);
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;
    private JTextArea textArea;

    public ClientHandler(Socket socket, JTextArea textArea) {
        this.socket = socket;
        this.textArea = textArea;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                out.println("Enter a username (at least 5 characters, unique):");
                clientName = in.readLine();
                if (Server.addClientName(clientName)) {
                    break;
                } else {
                    out.println("Username is either too short or already taken. Try again.");
                }
            }

            textArea.append(clientName + " has joined\n");
            Server.broadcast(clientName + " has joined");

            for (String message : Server.getMessagesForClient(clientName)) {
                sendMessage(message);
            }

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equals("EXIT")) {
                    break;
                }
                String fullMessage = clientName + ": " + message;
                Server.storeMessage(clientName, message);
                Server.broadcast(fullMessage);
                textArea.append(fullMessage + "\n");
            }
        } catch (IOException e) {
            textArea.append("Error handling client: " + e.getMessage() + "\n");
        } finally {
            // İstemcinin tüm mesajlarını sil
            Server.removeMessagesForClient(clientName);

            // İstemciyi ve mesajları diğer istemcilere bildir
            Server.removeClient(this);
            Server.broadcast(clientName + " has left");
            textArea.append(clientName + " has left\n");

            try {
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                textArea.append("Error closing socket: " + e.getMessage() + "\n");
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void closeConnection() {
        try {
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            textArea.append("Error closing socket: " + e.getMessage() + "\n");
        }

        Server.removeMessagesForClient(clientName);
        Server.removeClient(this);
        Server.broadcast(clientName + " has left");
        textArea.append(clientName + " has left\n");
    }
}

