
//package np.practicals;

//java SplitUrl  https://www.example.com/path/page?param1=value1&param2=value2#fragment

import java.net.*;
public class SplitUrl{
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try{
                URL u=new URL(args[i]);
                System.out.println("The URL is "+u);
                System.out.println("The Scheme is "+u.getProtocol());
                System.out.println("The user info is  "+u.getUserInfo());
                String host=u.getHost();
                if(host!=null){
                    int atSign=host.indexOf('@');
                    if(atSign!=-1){
                        host=host.substring(atSign+1);
                        
                    }
                    System.out.println(" The host is "+host);
                    
                }else{
                    System.out.println(" The host is null ");
                }
                System.out.println("The port is "+u.getPort());
                System.out.println(" The path is "+u.getPath());
                System.out.println(" The ref is "+u.getRef());
                System.out.println(" The query string is "+u.getQuery());
                
            }catch(Exception e){
                System.err.println(args[i] +" is not URL I understand");
            }
            System.out.println(" ");
        }
        
    }
}