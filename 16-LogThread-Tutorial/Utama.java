import java.io.FileWriter;
import java.io.IOException;

public class Utama {
    private final static int JUMLAH_THREAD = 100;
    private final static String NAMA_BERKAS = "log.log";
    
    public static void main(String[] args) throws IOException, InterruptedException {
        // Buka berkas untuk log
        FileWriter berkas = new FileWriter(NAMA_BERKAS, false);
        
        // Buat thread-nya
        Thread[] thread = new Thread[JUMLAH_THREAD];
        for (int cnt=0; cnt<JUMLAH_THREAD; ++cnt) {
            ThreadLog log = new ThreadLog(berkas, "Thread-" + cnt);
            thread[cnt] = new Thread(log);
        }
        
        // Mulai thread
        for (int cnt=0; cnt<JUMLAH_THREAD; ++cnt)
            thread[cnt].start();

        // Tunggu sampai selesai
        Thread.sleep(100);
        
        // Tutup berkas
        berkas.close();
    }
}
