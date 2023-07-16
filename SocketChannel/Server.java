/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketChannel;

import java.io.IOException;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
public class Server {
    public static void main(String[] args) throws IOException {
            SocketChannel server=SocketChannel.open();
        SocketAddress socketAddress=new InetSocketAddress("localhost",9000);
        server.connect(socketAddress);
        
        Path path=Paths.get("C:/TEST/temp.txt");
        FileChannel filechannel=FileChannel.open(path);
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while(filechannel.read(buffer)>0){
            buffer.flip();
            server.write(buffer);
            buffer.clear();
        }
        filechannel.close();
        System.err.println("File Sent");
        server.close();
    
     }
    
}
