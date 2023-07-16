/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package np.practicals;

import java.io.*;
import java.net.*;
public class MulticastReciverSocket {
    public static void main(String[] args) throws IOException{
        InetAddress group=null;
        int port=0;
        
        
        
        try{
            group=InetAddress.getByName("224.2.2.1");
            port=3333;

        }catch (ArrayIndexOutOfBoundsException | NumberFormatException | UnknownHostException ex){
            System.err.println(ex);
            System.err.println("Usage: Java multicastsniffter ");
            System.exit(1);
            
        }
        byte[] data="Here's some multicast data\r\n".getBytes();
        DatagramPacket dp=new DatagramPacket(data, data.length,ia,port);
        try(MulticastSocket ms=new MulticastSocket()){
            ms.setTimeToLive(ttl);
            ms.joinGroup(ia);
            for(int i=1;i<10;i++){
                ms.send(dp);
            }
            ms.leaveGroup(ia);
        }catch(SocketException ex){
            System.err.println(ex);
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}
