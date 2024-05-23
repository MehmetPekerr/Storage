package com.mycompany.ag4;

public class Ag4 {
    public static void main(String[] args) {
        // Server'i başlat
        new Thread(() -> Server.main(args)).start();

        // Client'i başlat
        new Thread(() -> Client.main(args)).start();
    }
}
