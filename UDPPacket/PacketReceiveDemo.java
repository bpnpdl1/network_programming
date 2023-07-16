/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDPPacket;

/**
 *
 * @author Bpnpdl
 */


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class PacketReceiveDemo {
    public static void main(String[] args) throws IOException {
        int port = 5000; // Specify the desired port number

        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("UDP Packet Receiver started on port " + port);

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        String receivedData = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received data: " + receivedData);

        socket.close();
    }
}
