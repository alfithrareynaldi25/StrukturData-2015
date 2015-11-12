import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BacaBerkasBuffer {
    public static void main(String[] args) {
        try {
            BacaBerkasBuffer bacaBerkasBuffer = new BacaBerkasBuffer();
            bacaBerkasBuffer.baca("alodonya.txt");
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
        // Deklarasi variabel
        FileInputStream masukan = null;
        BufferedInputStream masukanBuffer = null;
        
        try {
            // Object stream untuk masukkan
            masukan = new FileInputStream(namaBerkas);
            masukanBuffer = new BufferedInputStream(masukan);
            
            // Coba baca  dari stream
            int karakter = masukanBuffer.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                System.out.print((char) karakter);
                // Coba baca lagi dari stream
                karakter = masukanBuffer.read();
            }
        } 
        finally {
            // Tutup stream masukan
            if (masukanBuffer != null)
                masukanBuffer.close();
            if (masukan != null)
                masukan.close();
        }
    }
}