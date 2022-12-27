package TCP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(4000);
        System.out.println("Server is running");
        Socket soc = ss.accept();
        System.out.println("Client connected");
        InputStream istream = soc.getInputStream();
        BufferedReader filenameread = new BufferedReader(new InputStreamReader(istream));
        String fname = filenameread.readLine();
        BufferedReader contentread = new BufferedReader(new FileReader(fname));
        OutputStream os = soc.getOutputStream();
        PrintWriter pw = new PrintWriter(os,true);

        String str;

        while((str = contentread.readLine()) != null){
            pw.println(str);
        }

        pw.close();
        soc.close();
        ss.close();
        contentread.close();
        filenameread.close();
        
    }
    
}
