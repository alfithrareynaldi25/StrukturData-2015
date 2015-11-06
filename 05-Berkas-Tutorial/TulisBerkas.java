import java.io.FileOutputStream;
import java.io.IOException;

public class TulisBerkas {
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

        try {
            // Object stream untuk masukkan
            keluaran = new FileOutputStream(namaBerkas);
            
            // Selama masih ada data yang perlu dikeluarkan
            for (int cacah = 0; cacah < pesan.length(); ++cacah) {
                // Karakter yang dibaca
                int karakter = pesan.charAt(cacah);
                // Kirim ke keluaran
                keluaran.write(karakter);
            }
            
            // Flush semua
            keluaran.flush();
        } 
        finally {
            // Tutup stream keluaran
            if (keluaran != null)
                keluaran.close();
        }
    }
    
    public static void main(String[] args) throws IOException {
        try {
            TulisBerkas tulisBerkas = new TulisBerkas();
            tulisBerkas.tulis("Peuhaba dronneuh lawetnyo?", "sasaran.txt");
            tulisBerkas.tulis("Ya opo kabar'e rek?", "sasaran-2.txt");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    }
}