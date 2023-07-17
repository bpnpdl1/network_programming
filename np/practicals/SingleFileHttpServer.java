/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package np.practicals;

/**
 *
 * @author Bpnpdl
 */


 import java.net.*;
 import java.io.*;
 
 public class SingleFileHttpServer extends Thread {
 
   private byte[] content;
   
   private byte[] header;
   private int port = 80;
 
   public SingleFileHttpServer(String data, String encoding, 
    String MIMEType, int port) throws UnsupportedEncodingException {    
     this(data.getBytes(encoding), encoding, MIMEType, port);
   }
 
   public SingleFileHttpServer(byte[] data, String encoding, 
    String MIMEType, int port) throws UnsupportedEncodingException {
     
     this.content = data;
     this.port = port;
     String header = "HTTP/1.0 200 OK\r\n"
      + "Server: OneFile 1.0\r\n"
      + "Content-Length: " + this.content.length + "\r\n"
      + "Content-Type: " + MIMEType + "\r\n\r\n";
     this.header = header.getBytes("ASCII");
 
   }
 
   
   public void run() {
   
     try {
       ServerSocket server = new ServerSocket(this.port); 
       System.out.println("Accepting connections on port " 
         + server.getLocalPort());
       System.out.println("Data to be sent:");
       System.out.write(this.content);
       while (true) {
         
         Socket connection = null;
         try {
           connection = server.accept();
           OutputStream out = new BufferedOutputStream(
                                   connection.getOutputStream()
                                  );
           InputStream in   = new BufferedInputStream(
                                   connection.getInputStream()
                                  );
           // read the first line only; that's all we need
           StringBuffer request = new StringBuffer(80);
           while (true) {
             int c = in.read();
             if (c == '\r' || c == '\n' || c == -1) break;
             request.append((char) c);
             // If this is HTTP/1.0 or later send a MIME header
 
           }
           if (request.toString().indexOf("HTTP/") != -1) {
             out.write(this.header);
           }         
           out.write(this.content);
           out.flush();
         }  // end try
         catch (IOException e) {   
         }
         finally {
           if (connection != null) connection.close(); 
         }
         
       } // end while
     } // end try
     catch (IOException e) {
       System.err.println("Could not start server. Port Occupied");
     }
 
   } // end run
 
 
  public static void main(String[] args) {
    try {
        String contentType = "text/plain";
        String filePath = "E:\\Software setup files\\NP practicals\\src\\np\\practicals/myfile.html"; // Replace with the actual file path
        String encoding = "ASCII";
        int port = 90;

        if (filePath.endsWith(".html") || filePath.endsWith(".htm")) {
            contentType = "text/html";
        }

        InputStream in = new FileInputStream(filePath);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        byte[] data = out.toByteArray();

        Thread t = new SingleFileHttpServer(data, encoding, contentType, port);
        t.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

 }
