/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MulticastSocket;

/**
 *
 * @author Bpnpdl
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Server {
    public static void main(String[] args) {
        String multicastAddress = "224.0.0.1"; // Specify the multicast IP address
        int port = 5000; // Specify the port number

        try (MulticastSocket multicastSocket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            multicastSocket.joinGroup(group);

            System.out.println("Multicast Socket Server started on " + multicastAddress + ":" + port);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                multicastSocket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

