package com.sevrin.toon.networking.a1.client;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private int number;

    public ClientThread(Socket socket, int number) {
        this.socket = socket;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeInt(number);
            oos.flush();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
