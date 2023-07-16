package np.practicals;

import java.net.InetAddress;

public class GetIpVersion {
    public static void main(String[] args) {
        int res = getVersion("www.google.com");
        System.out.println(res);
    }

    static int getVersion(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);
            byte[] ipVersion = address.getAddress();
            if (ipVersion.length == 4) {
                return 4;
            } else if (ipVersion.length == 16) {
                return 6;
            } else {
                return -1;
            }

        } catch (Exception e) {
            System.out.println("Error :" + e);
            return -1;
        }
    }
}