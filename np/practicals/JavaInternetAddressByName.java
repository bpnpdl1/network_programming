
package np.practicals;

import java.net.*;
public class JavaInternetAddressByName {
    public static void main(String[] args) {
        try{
            InetAddress address=InetAddress.getByName("www.lict.edu.np");
            System.out.println(address);
            
        }catch(UnknownHostException ex){
            System.out.println("coulf not find www.javapoint.com");
        }
    }
}
