package np.practicals;

import java.net.URI;

public class URISplitter {
    public static void main(String[] args) {
        String uriString = "http://www.example.com/path?param1=value1&param2=value2#fragment";

        try {
            URI uri = new URI(uriString);

            String scheme = uri.getScheme();
            String authority = uri.getAuthority();
            String path = uri.getPath();
            String query = uri.getQuery();
            String fragment = uri.getFragment();

            System.out.println("Scheme: " + scheme);
            System.out.println("Authority: " + authority);
            System.out.println("Path: " + path);
            System.out.println("Query: " + query);
            System.out.println("Fragment: " + fragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
