import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;

public class EchoClient {
    public EchoClient(InetAddress ip, int port, String id) {
        try {
            // Buka socket
            Socket koneksi = new Socket(ip, port);

            // Minta socket untuk tulis -> Langsung dibuka
            OutputStream keluaran = koneksi.getOutputStream( );
            Writer keluaranWriter = new OutputStreamWriter(keluaran); 
        
            // Tulis ke socket
            keluaranWriter.write("Hello " + id + "\n");
            keluaranWriter.flush();
        
            // Tutup socket-nya => dengan sendirinya menutup semua stream
            koneksi.close();
        }
        catch(UnknownHostException err) {
            System.out.println(err);
        }
        catch(IOException err) {
            System.out.println(err);
        }        
    }
    
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            new EchoClient(ip, 33333, "Dari: 1");
            new EchoClient(ip, 33333, "Dari: 2");
            new EchoClient(ip, 33333, "Dari: 3");
            new EchoClient(ip, 33333, "Dari: 4");
            new EchoClient(ip, 33333, "Dari: 5");
        }
        catch(UnknownHostException err) {
            System.out.println(err);
        }
    }
}