/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package np.practicals;

/**
 *
 * @author Bpnpdl
 */

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingClient {

    private static final Logger logger = Logger.getLogger(LoggingClient.class.getName());

    public static void main(String[] args) {
        // Configure log level and console handler
        logger.setLevel(Level.INFO);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);

        // Log some messages
        logger.log(Level.INFO, "This is an informational message.");
        logger.log(Level.WARNING, "This is a warning message.");
        logger.log(Level.SEVERE, "This is an error message.");
    }
}

