/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package np.practicals;

/**
 *
 * @author Bpnpdl
 */
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 8030;
        String message = "Hello Server";

        try (Socket socket = new Socket(serverHost, serverPort);
             OutputStream outputStream = socket.getOutputStream()) {

            byte[] data = message.getBytes();
            outputStream.write(data);
            outputStream.flush();

            System.out.println("Data sent to the server: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

