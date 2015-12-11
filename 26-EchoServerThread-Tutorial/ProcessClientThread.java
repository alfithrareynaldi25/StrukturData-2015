import java.net.Socket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ProcessClientThread implements Runnable {
    public ProcessClientThread(Socket koneksiKiriman) {
        koneksi = koneksiKiriman;
    }

    public void run() {
        if (koneksi != null)
            prosesPermintaanClient();
    }

    private void prosesPermintaanClient() {
        try {
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
        catch(IOException err) {
            System.out.println(err);
        }
        catch(InterruptedException err) {
            System.out.println(err);
        }
    }

    private Socket koneksi; 
}