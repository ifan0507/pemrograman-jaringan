package programjaringan.pertemuan1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class praktikum1 {
    public static void main(String[] args) {
        try {
            InetAddress polinema = InetAddress.getByName("www.polinema.ac.id");
            InetAddress polinemaIp = InetAddress.getByName("114.6.41.77");
            InetAddress google = InetAddress.getByName("www.google.com");
            InetAddress googleIp = InetAddress.getByName("74.125.24.106");
            InetAddress youtube = InetAddress.getByName("www.youtube.com");
            InetAddress youtubeIp = InetAddress.getByName("142.251.175.91");
            InetAddress insta = InetAddress.getByName("www.instagram.com");
            InetAddress instaIp = InetAddress.getByName("157.240.15.174");

            System.out.println("Ip address dari Polinema adalah : " + polinema.getHostAddress());
            System.out.println("Ip address dari Google adalah : " + google.getHostAddress());
            System.out.println("Ip address dari Youtube adalah : " + youtube.getHostAddress());
            System.out.println("Ip address dari Instagram adalah : " + insta.getHostAddress());

            if (polinema.equals(polinemaIp)) {
                System.out.println("Ip sama");
            } else {
                System.out.println("Ip berbeda");
            }
            if (google.equals(googleIp)) {
                System.out.println("Ip sama");
            } else {
                System.out.println("Ip berbeda");
            }
            if (youtube.equals(youtubeIp)) {
                System.out.println("Ip sama");
            } else {
                System.out.println("Ip berbeda");
            }
            if (insta.equals(instaIp)) {
                System.out.println("Ip sama");
            } else {
                System.out.println("Ip berbeda");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
