package np.practicals;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bpnpdl
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecureOrderTaker {
    public static void main(String[] args) {
        System.out.println("Secure Order Taker");
        System.out.println("==================");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String name = getInput(reader, "Enter your name: ");
            String address = getInput(reader, "Enter your address: ");
            String creditCardNumber = getSecureInput(reader, "Enter your credit card number: ");

            System.out.println("\nOrder Summary");
            System.out.println("-------------");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("Credit Card Number: " + creditCardNumber);

            // Process the order and perform other necessary actions
            // ...

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getInput(BufferedReader reader, String prompt) throws IOException {
        System.out.print(prompt);
        return reader.readLine();
    }

    private static String getSecureInput(BufferedReader reader, String prompt) throws IOException {
        System.out.print(prompt);
        StringBuilder input = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            if (c == '\r' || c == '\n') {
                break;
            }
            input.append((char) c);
        }
        return input.toString();
    }
}

