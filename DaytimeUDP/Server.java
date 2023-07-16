/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaytimeUDP;

import java.net.*;
import java.util.Date;
import java.util.logging.*;
import java.io.*;
public class Server {
    private final static int PORT=13;
    private final static Logger audit=Logger.getLogger("request");
    private final static Logger errors=Logger.getLogger("errors");
    
    public static void main(String[] args) {
        try(DatagramSocket socket=new DatagramSocket(PORT)){
            while(true){
               try {
                   DatagramPacket request=new DatagramPacket(new byte[1024],1024);
                   socket.receive(request);
                   String datareq=new String(request.getData(),0,request.getLength(),"UTF-8");
                   System.out.println("Client Says : "+datareq);
                   System.out.println("Sending date and time to client...");
                   String daytime=new Date().toString();
                   byte[] data=daytime.getBytes("US-ASCII");
                   DatagramPacket response=new DatagramPacket(data, data.length,
                   request.getAddress(),request.getPort());
                   socket.send(response);
                
                   audit.info(daytime+ " "+ request.getPort());
                  // socket.send(response);
                   audit.info(daytime+" "+request.getAddress());
                   
                   
                }catch(IOException | RuntimeException ex){
                    errors.log(Level.SEVERE,ex.getMessage(),ex);
                }
            }
        }catch (IOException ex){
            errors.log(Level.SEVERE,ex.getMessage(),ex);
        }
    }
    
}
