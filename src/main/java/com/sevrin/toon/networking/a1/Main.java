package com.sevrin.toon.networking.a1;

import com.sevrin.toon.networking.a1.client.Client;
import com.sevrin.toon.networking.a1.input.ConsoleInputProvider;
import com.sevrin.toon.networking.a1.input.InputProvider;
import com.sevrin.toon.networking.a1.server.Server;

public class Main {
    private static Application app;
    public static void main(String[] args) {
        InputProvider inputProvider = new ConsoleInputProvider();
        if(args[0].equals("server"))
            app = new Server(inputProvider.getPort());
        else if(args[0].equals("client"))
            app = new Client(inputProvider);
        app.start();

    }
}
