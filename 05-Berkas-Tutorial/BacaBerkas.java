import java.io.FileInputStream;
import java.io.IOException;

public class BacaBerkas {
    public static void main(String[] args) {
        try {
            BacaBerkas bacaBerkas = new BacaBerkas();
            bacaBerkas.baca("alodonya.txt");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    }

    /**
     * Membaca suatu berkas dan menampilkan isinya.
     *
     * Parameter:
     *   namaBerkas = Nama berkas yang akan dibaca
     */
    public void baca(String namaBerkas) throws IOException {
        FileInputStream masukan = null;
        // Deklarasi variabel
        try {
            // Object stream untuk masukkan
            masukan = new FileInputStream(namaBerkas);
            
            // Coba baca  dari stream
            int karakter = masukan.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                System.out.print((char) karakter);
                // Coba baca lagi dari stream
                karakter = masukan.read();
            }
        } 
        finally {
            // Tutup stream masukan
            if (masukan != null)
                masukan.close();
        }
    }
}