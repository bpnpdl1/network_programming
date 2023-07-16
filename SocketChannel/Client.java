/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketChannel;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.EnumSet;
public class Client {
    public static void main(String[] args) throws IOException{
        ServerSocketChannel serversocket=null;
        SocketChannel client=null;
        serversocket.socket().bind(new InetSocketAddress(9000));
        System.out.println("Connection set: "+client.getRemoteAddress());
        Path path=Paths.get("C:/Test/temp1.txt");
        FileChannel filechannel=FileChannel.open(path, EnumSet.of(StandardOpenOption.CREATE));
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while(client.read(buffer)>0){
            buffer.flip();
            filechannel.write(buffer);
            buffer.clear();
            filechannel.close();
            System.err.println("File Received");
            client.close();
        }
        
    }
 
    
}
