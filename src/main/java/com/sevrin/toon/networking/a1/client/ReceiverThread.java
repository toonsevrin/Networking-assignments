package com.sevrin.toon.networking.a1.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;

public class ReceiverThread extends Thread {
    private Socket socket;
    private CompletableFuture<String> resultFuture;

    public ReceiverThread(Socket socket, CompletableFuture<String> resultFuture) {
        this.socket = socket;
        this.resultFuture = resultFuture;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            try {
                resultFuture.complete(input.readLine());
            }catch (Exception e){
                System.out.println("end of data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
