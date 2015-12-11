import java.net.Socket;
import java.net.ServerSocket;
import java.net.BindException;
import java.net.InetAddress;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class EchoServer {
    public EchoServer(int port) throws BindException, IOException {
        serverSocket = new ServerSocket(port);
    }
    
    public void dengar() {
        while (true) {
            try  {
                // Tunggu sampai ada koneksi dari client
                Socket koneksi = serverSocket.accept();
                
                // Proses permintaan client
                prosesPermintaanClient(koneksi);
            }
            catch(IOException err) {
                System.out.println(err);
            }
            catch(InterruptedException err) {
                System.out.println(err);
            }
        }
    }
    
    private void prosesPermintaanClient(Socket koneksi) throws InterruptedException,
                                                               IOException {
        // IP address asal koneksi                                                                   
        String ip = koneksi.getInetAddress().getHostAddress();
        // Tampilkan pesan
        System.out.println("Dari: " + ip);

        // Baca dari socket
        InputStream masukan = koneksi.getInputStream();
        BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
        String baris = masukanReader.readLine();
        while (baris != null) {
            System.out.println(baris);
            baris = masukanReader.readLine();
        }

        // Tunggu 2 detik
        System.out.println("Tunggu...");
        Thread.sleep(2000);
        System.out.println("Selesai tunggu...");

        koneksi.close();
    }
    
    private ServerSocket serverSocket = null;
    
    public static void main(String args[]) {
        try {            
            EchoServer server = new EchoServer(33333);
            server.dengar();
        }
        catch(BindException err) {
            System.out.println(err);
        }
        catch(IOException err) {
            System.out.println(err);
        }
    }
}
