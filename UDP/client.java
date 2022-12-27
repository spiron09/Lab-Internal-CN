package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class client {
    public static void main(String[] args) throws Exception{
        
        try (DatagramSocket ds = new DatagramSocket(3000)) {
            DatagramPacket dp;
            byte[] buffer;
            String info;

            while(true){
                buffer = new byte[4000];
                dp = new DatagramPacket(buffer, buffer.length);

                ds.receive(dp);
                info = new String(buffer).trim();
                System.out.println(info);

            }
        }

        
    }
    
}
