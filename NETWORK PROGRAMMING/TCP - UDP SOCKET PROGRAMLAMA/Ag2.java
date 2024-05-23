package com.mycompany.ag2;

import javax.swing.*;

public class Ag2 {
    public static void main(String[] args) {
        int serverPort = Integer.parseInt(JOptionPane.showInputDialog("Sunucu portunu girin:"));
        JFrame serverFrame = new UDPServerSwing(serverPort);
        serverFrame.setLocation(100, 100);
        serverFrame.setVisible(true);

        int clientPort = Integer.parseInt(JOptionPane.showInputDialog("İstemci portunu girin:"));
        String clientName = JOptionPane.showInputDialog("Adınızı girin:");
        JFrame clientFrame = new UDPClientSwing(clientPort);
        clientFrame.setLocation(550, 100);
        clientFrame.setVisible(true);
    }
}