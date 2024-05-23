package com.mycompany.ag4;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {
    private static String serverAddress;
    private static int serverPort;
    private static String userName;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Client");
        JTextArea textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        JTextField textField = new JTextField(40);
        JButton sendButton = new JButton("Send");
        JButton exitButton = new JButton("Exit");

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(sendButton);
        panel.add(exitButton);

        frame.getContentPane().add(new JScrollPane(textArea), "Center");
        frame.getContentPane().add(panel, "South");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            serverAddress = JOptionPane.showInputDialog(frame, "Enter server IP address:");
            try {
                serverPort = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter server port:"));
                Socket socket = new Socket(serverAddress, serverPort);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                break;
            } catch (IOException | NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Connection failed. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        exitButton.addActionListener(e -> {
            try {
                out.println("EXIT");
                out.close();
                in.close();
                frame.dispose();
                System.exit(0);
            } catch (IOException ex) {
                textArea.append("Error closing connection: " + ex.getMessage() + "\n");
            }
        });

        new Thread(() -> {
            try {
                while (true) {
                    String response = in.readLine();
                    if (response.startsWith("Enter a username")) {
                        userName = JOptionPane.showInputDialog(frame, response);
                        out.println(userName);
                    } else {
                        textArea.append(response + "\n");
                    }
                }
            } catch (IOException e) {
                textArea.append("Connection lost: " + e.getMessage() + "\n");
            }
        }).start();

        sendButton.addActionListener(e -> {
            String message = textField.getText();
            if (!message.isEmpty()) {
                out.println(message);
                textField.setText("");
            }
        });

        textField.addActionListener(e -> {
            String message = textField.getText();
            if (!message.isEmpty()) {
                out.println(message);
                textField.setText("");
            }
        });
    }
}
