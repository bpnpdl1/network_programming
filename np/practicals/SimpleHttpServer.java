/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package np.practicals;

/**
 *full flieged server
 * @author Bpnpdl
 */


import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleHttpServer {
    public static void main(String[] args) {
        int port = 8000; // Specify the desired port number

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                HttpRequestHandler requestHandler = new HttpRequestHandler(clientSocket);
                requestHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HttpRequestHandler extends Thread {
    private final Socket clientSocket;

    public HttpRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            // Read the request from the client
            String requestLine = in.readLine();
            if (requestLine == null) {
                return;
            }
            System.out.println("Request: " + requestLine);

            // Parse the request
            StringTokenizer tokens = new StringTokenizer(requestLine);
            String httpMethod = tokens.nextToken();
            String httpPath = tokens.nextToken();

            // Handle the request
            if (httpMethod.equals("GET")) {
                handleGetRequest(httpPath, out);
            } else {
                handleUnsupportedMethod(out);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleGetRequest(String httpPath, PrintWriter out) {
        if (httpPath.equals("/")) {
            // Respond with a simple HTML page
            String response = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<html><body>"
                    + "<h1>Welcome to the Simple HTTP Server</h1>"
                    + "<p>This is a sample response.</p>"
                    + "</body></html>";
            out.println(response);
        } else {
            // Respond with a 404 Not Found error
            String response = "HTTP/1.1 404 Not Found\r\n"
                    + "Content-Type: text/plain\r\n"
                    + "\r\n"
                    + "404 Not Found";
            out.println(response);
        }
    }

    private void handleUnsupportedMethod(PrintWriter out) {
        // Respond with a 405 Method Not Allowed error
        String response = "HTTP/1.1 405 Method Not Allowed\r\n"
                + "Content-Type: text/plain\r\n"
                + "\r\n"
                + "405 Method Not Allowed";
        out.println(response);
    }
}
