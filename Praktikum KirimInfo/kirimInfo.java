import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;

public class kirimInfo {
    public static void main (String[] args) 
                throws UnknownHostException, IOException {
        String info = "Alfithra Reynaldi (1408107010040)";
                    
        Socket koneksi = new Socket("192.168.43.139", 33333);
        OutputStream keluaran = koneksi.getOutputStream();
        Writer keluaranWriter = new OutputStreamWriter(keluaran);
        keluaranWriter.write(info);
        keluaranWriter.write("\r\n");
        keluaranWriter.flush();
        koneksi.close();
    }
    
}