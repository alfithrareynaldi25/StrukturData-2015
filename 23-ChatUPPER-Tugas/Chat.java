import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.BufferedInputStream;

public class Chat{
    public void chat(String isiPesan) 
                throws UnknownHostException, IOException {
        koneksi = new Socket("192.168.43.153", 33333);
        kirimPesan(isiPesan);
        bacaBalasan();
        koneksi.close();
    }
    
    public void kirimPesan(String isiPesan) throws IOException {
        OutputStream keluaran = koneksi.getOutputStream();
        Writer keluaranWriter = new OutputStreamWriter(keluaran); 
        keluaranWriter.write(isiPesan);
        keluaranWriter.write("\r\n"); 
    }
    
    public void bacaBalasan() throws IOException {
        InputStream masukan = koneksi.getInputStream();
        BufferedInputStream masukanBuffer = new BufferedInputStream(masukan);
        System.out.print("Server: ");
        String balasan = "";
        int data = masukanBuffer.read();
        while (data != -1) {
            System.out.write((char) data);
            balasan = balasan + Character.toUpperCase((char) data);
            data = masukanBuffer.read();                       
        }
        System.out.println("Me: "+balasan);
        kirimPesan(balasan);
    }
    private Socket koneksi = null;
}