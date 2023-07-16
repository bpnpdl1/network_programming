package np.practicals;


/* 

Do an open directory search

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DODS {
    public static void main(String[] args) {
        String dmozUrl = "https://google.com"; // Replace with the desired Dmoz URL
        
        try {
            URL url = new URL(dmozUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                System.out.println("Response from Dmoz:\n" + response.toString());
            } else {
                System.out.println("Error: HTTP response code - " + responseCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
