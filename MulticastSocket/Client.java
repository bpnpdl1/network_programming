package MulticastSocket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bpnpdl
 */

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String multicastAddress = "224.0.0.1"; // Specify the multicast IP address
        int port = 5000; // Specify the port number

        try (MulticastSocket multicastSocket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            multicastSocket.joinGroup(group);

            System.out.println("Multicast Socket Client started on " + multicastAddress + ":" + port);

            String message = "Hello, multicast!"; // Specify the message to send
            byte[] sendData = message.getBytes();

            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, group, port);
            multicastSocket.send(packet);

            System.out.println("Sent message: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
