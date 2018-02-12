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

    private String fetchString(String query){
        System.out.println(query);
        return new Scanner(System.in).nextLine();
    }
}
