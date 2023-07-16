/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaytimeUDP;

import java.io.*;
//import java.util.*;
import java.net.*;
public class Client {
    private final static int PORT=13;
    private static final String HOSTNAME="localhost";
    public static void main(String[] args) {
        try(DatagramSocket socket=new DatagramSocket(0)){
            socket.setSoTimeout(10000);
            InetAddress host=InetAddress.getByName(HOSTNAME);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String line=br.readLine();
            byte[] data=line.getBytes("US-ASCII");
            DatagramPacket request=new DatagramPacket(data, data.length,host,PORT);
            DatagramPacket response =new DatagramPacket(new byte[1024],1024);
            socket.send(request);
            socket.receive(response);
            String result=new String(response.getData(),0,response.getLength(),"US-ASCII");
            System.out.println(result);
        }catch(IOException ex){
           // ex.printStackTrace();
        }
    }
}
