package com.sevrin.toon.networking.a1.client;


import com.sevrin.toon.networking.a1.Application;
import com.sevrin.toon.networking.a1.input.InputProvider;

import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;

public class Client implements Application {
    private InputProvider inputProvider;
    private boolean terminated;
    public Client(InputProvider inputProvider) {
        this.inputProvider = inputProvider;

    }

    public void start() {
        try {
            new Thread(() -> {
                while (!terminated) {
                    request(inputProvider.getHost(), inputProvider.getPort(), inputProvider.getNumber());
                }

            }).start();
        }catch (Exception e){ e.printStackTrace(); }
    }

    private void request(String host, int port, int number){
        try {
            Socket socket = new Socket(InetAddress.getByName(host), port);

            CompletableFuture<String> responseHandler = new CompletableFuture<String>();

            ClientThread clientThread =  new ClientThread(socket, number);
            ReceiverThread receiverThread = new ReceiverThread(socket, responseHandler);
            System.out.println("Opening socket...");
            clientThread.start();
            receiverThread.start();

            clientThread.join();
            receiverThread.join();
            System.out.println("Closing socket...");
            socket.close();
            System.out.println("Converted " + number + " to " + responseHandler.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void terminate() {
        this.terminated = true;
    }
}
