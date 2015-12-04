import java.net.Socket;
import java.net.UnknownHostException;
import java.io.InputStream;
import java.io.IOException;

public class TanyaWaktu {
    public String jamBerapa(String hostname) 
                  throws UnknownHostException, IOException {
        String jawaban = "";

        // 0. Buka socket
        // NOTE: Pastikan port 13 di firewall dibuka
        Socket koneksi = new Socket(hostname, 13);
        
        // 1 & 2. Minta object stream dari socket dan sekaligus dibuka 
        InputStream masukan = koneksi.getInputStream( );
        
        // 3 & 4. Selagi masih ada data baca
        int data = masukan.read();
        while (data != -1) {
            // 5. Lakukan sesuatu dengan data
            jawaban = jawaban + (char) data;
            data = masukan.read();
        }

        // 6. Tutup socket-nya yang sekaligus menutup stream
        koneksi.close();

        return jawaban;
    }
}
//3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 