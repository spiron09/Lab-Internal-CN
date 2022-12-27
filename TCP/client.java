package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class client {
    public static void main(String[] args) throws IOException{

        Socket soc = new Socket("127.0.01", 4000);
        System.out.println("Enter file name: ");
        BufferedReader readfile = new BufferedReader(new InputStreamReader(System.in));

        String filename = readfile.readLine();

        OutputStream osStream = soc.getOutputStream();
        PrintWriter pw = new PrintWriter(osStream, true);
        pw.println(filename);

        InputStream istream = soc.getInputStream();
        BufferedReader readcontent = new BufferedReader(new InputStreamReader(istream));
        String str;

        while((str = readcontent.readLine()) != null){
        System.out.println(str);
        }

        soc.close();
        pw.close();
        readfile.close();
        readcontent.close();
        
       
    }
    
    
}
