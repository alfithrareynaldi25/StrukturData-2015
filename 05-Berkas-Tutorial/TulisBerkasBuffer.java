import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TulisBerkasBuffer {
    /**
     * Fungsi untuk menulis suatu berkas dengan pesan tertentu.
     *
     * Parameter:
     *   pesan = pesan yang akan ditulis
     *   namaBerkas = Nama berkas yang akan ditulis
     * 
     * PERHATIKAN: Jika namaBerkas sudah ada maka akan ditimpa!
     */
    public void tulis(String pesan, String namaBerkas) throws IOException {
        // Deklarasi variabel untuk stream
        FileOutputStream keluaran = null;
        BufferedOutputStream keluaranBuffer = null;

        try {
            // Object stream untuk masukkan
            keluaran = new FileOutputStream(namaBerkas);
            keluaranBuffer = new BufferedOutputStream(keluaran);
            
            // Selama masih ada data yang perlu dikeluarkan
            for (int cacah = 0; cacah < pesan.length(); ++cacah) {
                // Karakter yang dibaca
                int karakter = pesan.charAt(cacah);
                // Kirim ke keluaran
                keluaranBuffer.write(karakter);
            }

            // Flush semua
            keluaranBuffer.flush();
        } 
        finally {
            // Tutup stream keluaran
            if (keluaranBuffer != null)
                keluaranBuffer.close();
            if (keluaran != null)
                keluaranBuffer.close();
        }
    }
    
    public static void main(String[] args) throws IOException {
        try {
            TulisBerkasBuffer tulisBerkas = new TulisBerkasBuffer();
            tulisBerkas.tulis("Peuhaba dronneuh lawetnyo?", "sasaran.txt");
            tulisBerkas.tulis("Ya opo kabar'e rek?", "sasaran-2.txt");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    }
}