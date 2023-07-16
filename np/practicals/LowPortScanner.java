/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package np.practicals;

/**
 *TCP Scanners
 * @author Bpnpdl
 */
import java.net.*;
import java.io.*;
public class LowPortScanner {
    public static void main(String[] args) {
        String host="localhost";
        if(args.length>0){
            host=args[0];
        }
        for(int i=1;i<1024;i++){
            try {
                Socket s=new Socket(host,i);
                System.out.println("There is a server on port "+i+" of "+host);
                s.close();
            } catch (IOException e) {
                System.out.println("There is no server on port "+i+" of "+host);
            } 
            catch (Exception e) {
                System.out.println(e);
            }
        
        }
    }
    
}
