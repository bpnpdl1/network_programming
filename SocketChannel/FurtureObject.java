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
import java.util.concurrent.*;

public class FurtureObject {
    public static void main(String[] args) throws Exception{
        readFile();
        
    }
    
    private static void readFile() throws IOException,InterruptedException,ExecutionException{
        string filepath="D:\filecopy.txt";
        printfilecontents(filepath);
        Path path=Paths.get(filepath);
        
        AsynchronousFileChannel channel=AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer=ByteBuffer.allocate(400);
        Furture<Integer> result=channel.read(buffer, 0);
        while(!result.isDone()){
            System.out.println("Reading time: "+result.isDone());
            
            System.out.println("Bytes read from file: "+result.get());
            while(buffer.hasRemaining()){
                System.out.println(" ");
                System.out.println((char)buffer.get());
            }
            buffer.clear();
            channel.close();
    
        }
        private static void printfilecontents(String path) throws IOException {
            FileReader fr=new FileReader
        }
    }
    
}
