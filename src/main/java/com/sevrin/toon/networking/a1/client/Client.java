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
                    String host = inputProvider.getHost();
                    int port = inputProvider.getPort();
                    int number = inputProvider.getNumber();
                    int mode = inputProvider.getMode();
                    if(mode == 1) {
                        Thread[] threads = new Thread[20];
                        for (int i = 0; i < 20; i++) {
                            threads[i] = new Thread(() -> request(host, port, number));//Thread pool would probably have been better here but whatever.
                            threads[i].start();
                        }
                        //Hardcoded wait function
                        for(int i = 0; i < 20; i++)
                            try {
                                threads[i].join();
                            } catch (InterruptedException e) {}
                    }else{
                        request(host, port, number);
                    }
                }

            }).start();
        }catch (Exception e){ e.printStackTrace(); }
    }

    private void request(String host, int port, int number){
        try {

            Socket socket = new Socket(InetAddress.getByName(host), port);
            Thread.sleep(1000);

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
