package com.sevrin.toon.networking.a2p2;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * For more information on each interface we could use getInterfaceAddresses().
 */
public class Main {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
            displayInterfaceInformation(networkInterface);
        }
    }

    static void displayInterfaceInformation(NetworkInterface networkInterface) throws SocketException {
        System.out.print("Display name: " + networkInterface.getDisplayName());
        System.out.print("Name: " + networkInterface.getName());
        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            System.out.print("InetAddress: " + inetAddress);
        }
        System.out.println();
    }
}
