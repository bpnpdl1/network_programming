/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package np.practicals;

import java.net.ServerSocket;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.*;


/**
 *
 * @author Bpnpdl
 */
public class LoggingServer {
    private ServerSocket serversocket=null;
    private Socket socket=null;
    
    public LoggingServer(int port){
        try{
            serversocket=new ServerSocket(port);
            socket =serversocket.accept();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
     
     public void acceptMessage(){
         
        try{
            LogManager logManager=LogManager.getLogManager();

            Logger logger=logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);

            InputStream inputStream=socket.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

            String str=null;

            while((str=reader.readLine())!=null){
                System.out.println(str);
                logger.log(Level.INFO,str);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
     }
    
    public static void main(String[] args) {
        LoggingServer server=new LoggingServer(5000);
        server.acceptMessage();
    }
    
}
