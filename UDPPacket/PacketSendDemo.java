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
import java.net.InetAddress;

public class PacketSendDemo {
    public static void main(String[] args) throws IOException {
        String ipAddress = "localhost"; // Specify the IP address or hostname of the receiver
        int port = 5000; // Specify the port number of the receiver

        String message = "Hello, UDP!"; // Specify the message to send

        byte[] sendData = message.getBytes();

        InetAddress receiverAddress = InetAddress.getByName(ipAddress);
        DatagramPacket packet = new DatagramPacket(sendData, sendData.length, receiverAddress, port);

        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        System.out.println("UDP Packet sent to " + ipAddress + ":" + port);

        socket.close();
    }
}
