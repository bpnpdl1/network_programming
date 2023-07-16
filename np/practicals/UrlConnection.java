/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package np.practicals;

import java.net.*;
import java.io.*;
import java.util.Date;

public class UrlConnection {
    public static void main(String[] args) throws MalformedURLException, IOException {
        int c;
        URL hp=new URL("https://www.youtube.com/");
        URLConnection hpCon=hp.openConnection();
        
        //getDate
        
        long d=hpCon.getDate();
        if(d==0){
            System.out.println("No date Information");
        }else{
            System.out.println("Date : "+new Date(d));
            
        }
        
            //get Content Type
            
            System.out.println("Content-Type: "+hpCon.getContentType());
            
             d=hpCon.getExpiration();
             if(d==0){
                 System.out.println("No expiration information");
             }else{
                 System.out.println("Expires: "
                 +new Date(d));
                 
             }
             
             d=hpCon.getLastModified(); //get last modified date
             
        if (d==0) {
            System.out.println("Last modified "+new Date());
        }else{
            System.out.println("Last-modified: "+new Date(d));
            int len=hpCon.getContentLength();
            if(len==-1){
                System.out.println("Content length is Unavailable");
            }else{
                System.out.println("Content-length: "+len);
            }
            if(len>=0){
                System.out.println("===Content===");
                InputStream input=hpCon.getInputStream();
                int i=len;
                while(((c=input.read())!=-1)){
                    System.out.print((char)c);
                }
                input.close();
            }
            else{
                System.out.println("No content available");
            }
        }
                  
    }
 
    
   
}
