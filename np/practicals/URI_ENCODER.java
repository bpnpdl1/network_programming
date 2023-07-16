/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package np.practicals;

import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
public class URI_ENCODER {
    public static void main(String[] args) {
          try{
            System.out.println(URLEncoder.encode("The string has spaces ", "UTF-8"));
            System.out.println(URLEncoder.encode("The*string*has*asterisks", "UTF-8"));
            System.out.println(URLEncoder.encode("The%string%has%percent%signs", "UTF-8"));
            System.out.println(URLEncoder.encode("The+string+has+pluses ", "UTF-8"));
            System.out.println(URLEncoder.encode("The/string/has/slashes ", "UTF-8"));
            System.out.println(URLEncoder.encode("The\"string\" has\" quote\"marks", "UTF-8"));
            System.out.println(URLEncoder.encode("The:string:has:colons ", "UTF-8"));
            System.out.println(URLEncoder.encode("The~string~has~tiles ", "UTF-8"));
            System.out.println(URLEncoder.encode("The(string)has(parentheses) ", "UTF-8"));
            System.out.println(URLEncoder.encode("The.string.has.periods ", "UTF-8"));
            System.out.println(URLEncoder.encode("The=string=has=equals=signs ", "UTF-8"));
            System.out.println(URLEncoder.encode("The&string&has&ampersands ", "UTF-8"));
            System.out.println(URLEncoder.encode("Theéstringéhasé non-ASCII characters ", "UTF-8"));
}catch(UnsupportedEncodingException ex){
    throw new RuntimeException("Broken VM does not support utf-8");
}
    }
    
}
