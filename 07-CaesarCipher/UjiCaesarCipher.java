import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UjiCaesarCipher {
    public UjiCaesarCipher() { }

    @Before
    public void setUp() {
        File file = new File(sumberStr);
        if (file.exists() == true)
            file.delete();
        file = new File(sasaranStr);
        if (file.exists() == true)
            file.delete();
    }

    @After
    public void tearDown() {
        File file = new File(sumberStr);
        if (file.exists() == true)
            file.delete();
        file = new File(sasaranStr);
        if (file.exists() == true)
            file.delete();
    }
    
    @Test
    public void enkripsi() throws IOException {
        byte[] pesan = "Aaallloooeee dddooonnnyyyaaa...".getBytes();
        int shift = 5;
        
        // Buat berkas uji
        FileOutputStream sumber = new FileOutputStream(sumberStr);
        sumber.write(pesan);
        sumber.flush();
        sumber.close();
        
        CaesarCipher caesarCipher = new CaesarCipher(shift);
        caesarCipher.enkripsi(sumberStr, sasaranStr);
        
        // Perikas apa hasil kopian benar
        FileInputStream sasaran = new FileInputStream(sasaranStr);
        byte[] bacaan = new byte[pesan.length];
        sasaran.read(bacaan);
        for (int indeks=0; indeks < pesan.length; ++indeks)
            assertEquals(shift + (int) pesan[indeks], (int) bacaan[indeks]);
        sumber.close();
    }

    @Test
    public void dekripsi() throws IOException {
        byte[] pesan = "Aaallloooeee dddooonnnyyyaaa...".getBytes();
        int shift = 5;
        
        // Buat berkas uji
        FileOutputStream sumber = new FileOutputStream(sumberStr);
        sumber.write(pesan);
        sumber.flush();
        sumber.close();
        
        CaesarCipher caesarCipher = new CaesarCipher(shift);
        // Enkripsi
        caesarCipher.enkripsi(sumberStr, sasaranStr);
        // Hapus sumbernya
        File file = new File(sumberStr);
        if (file.exists() == true)
            file.delete();
        // Dekripsi
        caesarCipher.dekripsi(sasaranStr, sumberStr);
        
        // Perikas apa hasil kopian benar
        FileInputStream sasaran = new FileInputStream(sumberStr);
        byte[] bacaan = new byte[pesan.length];
        sasaran.read(bacaan);
        for (int indeks=0; indeks < pesan.length; ++indeks)
            assertEquals(pesan[indeks], bacaan[indeks]);
        sumber.close();
    }

    private String sumberStr = "ujisumber.txt";
    private String sasaranStr = "ujisasaran.txt";
}