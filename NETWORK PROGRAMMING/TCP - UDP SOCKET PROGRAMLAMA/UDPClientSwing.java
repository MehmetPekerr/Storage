package com.mycompany.ag2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Date;

public class UDPClientSwing extends JFrame {
    private DatagramSocket socket;
    private InetAddress address;
    private JTextArea messageArea;
    private JTextField messageField;
    private JTextField nameField;
    private int port;
    private static final int MAX_RETRY_COUNT = 3;

    public UDPClientSwing(int port) {
        this.port = port;
        setTitle("UDP İstemcisi");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        add(scrollPane, BorderLayout.CENTER);

        messageField = new JTextField();
        add(messageField, BorderLayout.SOUTH);

        nameField = new JTextField();
        add(nameField, BorderLayout.NORTH);

        JButton sendButton = new JButton("Gönder");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        add(sendButton, BorderLayout.EAST);

        setVisible(true);

        startClient();
    }

    private void startClient() {
        try {
            address = InetAddress.getLocalHost();
            socket = new DatagramSocket();
            socket.setSoTimeout(3000); 

            new Thread(new Runnable() {
                public void run() {
                    int retryCount = 0;
                    while (retryCount < MAX_RETRY_COUNT) {
                        try {
                            byte[] receiveData = new byte[1024];
                            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                            socket.receive(receivePacket);
                            String serverMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                            messageArea.append("Sunucu: " + serverMessage + "\n");
                            retryCount = 0;
                        } catch (SocketTimeoutException ex) {
                            retryCount++;
                            messageArea.append("Bağlantı zaman aşımına uğradı. Tekrar deneme(" + retryCount + "/" + MAX_RETRY_COUNT + ")\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (retryCount == MAX_RETRY_COUNT) {
                        Date now = new Date();
                        String errorMessage = now.toString() + " - Bağlantı " + MAX_RETRY_COUNT + " deneme sonunda başarısız oldu. Program kapatılacak.";
                        messageArea.append(errorMessage + "\n");
                        JOptionPane.showMessageDialog(null, errorMessage, "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
}
                }
            }).start();
        } catch (IOException ex) {
            messageArea.append("İstemci başlatılamadı. Hata mesajı: " + ex.getMessage() + "\n");
            System.exit(1);
        }
    }

    private void sendMessage() {
        try {
            String name = nameField.getText();
            String message = messageField.getText();
            byte[] sendData = (name + ": " + message).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
            socket.send(sendPacket);
            messageField.setText("");
        } catch (IOException ex) {
            messageArea.append("Mesaj gönderilirken hata oluştu: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(JOptionPane.showInputDialog("Sunucu portunu girin:"));
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UDPClientSwing(port);
            }
        });
    }
}