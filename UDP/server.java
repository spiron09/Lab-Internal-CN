package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();
        DatagramPacket dp;
        byte[] buffer;
        String info;
        Scanner sc = new Scanner(System.in);

        while(true){
            info = sc.nextLine();
            buffer = info.getBytes();
            dp = new DatagramPacket(buffer, buffer.length);
            InetAddress.getLocalHost("localhost",3000);
            ds.send(
                




















            );
            if(info.equalsIgnoreCase("exit"))
                break;
        }

        ds.close();
        sc.close();
    }
    
}
