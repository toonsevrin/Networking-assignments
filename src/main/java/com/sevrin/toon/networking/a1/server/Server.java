package com.sevrin.toon.networking.a1.server;

import com.sevrin.toon.networking.a1.Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Application {
    private int port;
    private ServerSocket serverSocket;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                System.out.println("Server listening on port " + port);
                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("Received connection from " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
                    handleRequest(socket);
                    socket.close();
                    System.out.println("Closed socket");


                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);//should forward the collision exception instead of handling it here, whatever
            }
        }).start();
    }
    private void handleRequest(Socket client){
        try {
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            String hexRepresentation = Integer.toHexString(input.readInt());
            System.out.println("Sending " + hexRepresentation);
            output.println(hexRepresentation);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void terminate() {

    }
}
