import java.io.FileWriter;
import java.io.IOException;

public class ThreadLog implements Runnable {
    public ThreadLog(FileWriter berkas, String namaThread) {
        this.berkas = berkas;
        this.namaThread = namaThread;
    }
    
    public void tulis() {
        try {
            berkas.write("Tulisan "); // Tulisan log dari thread namaThread
            berkas.write("log ");
            berkas.write("dari ");
            berkas.write("thread ");
            berkas.write(namaThread);
            berkas.write("\n");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    }
    
    public void run() {
        tulis();
    }
    
    private FileWriter berkas; 
    private String namaThread; 
}
