package com.mycompany.ag2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Date;

public class UDPServerSwing extends JFrame {
    private DatagramSocket socket;
    private JTextArea messageArea;
    private int port;
    private int retryCount;
    private static final int MAX_RETRY_COUNT = 3;

    public UDPServerSwing(int port) {
        this.port = port;
        setTitle("UDP Sunucusu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);

        retryCount = 0;

        startServer();
    }

    private void startServer() {
        try {
            socket = new DatagramSocket(port);
            messageArea.append("Sunucu " + port + " portunda başlatıldı\n");

            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            byte[] receiveData = new byte[1024];
                            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                            socket.receive(receivePacket);
                            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                            String clientAddress = receivePacket.getAddress().getHostAddress();
                            int clientPort = receivePacket.getPort();
                            Date now = new Date();
                            messageArea.append(now.toString() + " - " + clientAddress + ":" + clientPort + " - " + clientMessage + "\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (IOException ex) {
            messageArea.append("Sunucu başlatılamadı. Hata mesajı: " + ex.getMessage() + "\n");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(JOptionPane.showInputDialog("Sunucu portunu girin:"));
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UDPServerSwing(port);
            }
        });
    }
}