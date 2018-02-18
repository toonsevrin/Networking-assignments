package com.sevrin.toon.networking.a1.input;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider{
    public String getHost() {
        return fetchString("Please provide a host address: ");
    }

    public int getPort() {
        return Integer.valueOf(fetchString("Please provide a host port: "));
    }

    @Override
    public int getNumber() {
        return Integer.valueOf(fetchString("Please provide a number: "));
    }

    @Override
    public int getMode() {
        return Integer.valueOf(fetchString("Please provide a mode (0 = normal, 1 = DoS): "));
    }

    private String fetchString(String query){
        System.out.println(query);
        return new Scanner(System.in).nextLine();
    }
}
