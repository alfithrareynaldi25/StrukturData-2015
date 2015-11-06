import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The test class UjiKopiBerkas.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UjiKopiBerkas {
    public UjiKopiBerkas() { }

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
    public void kopi() throws IOException {
        byte[] pesan = "Aaallloooeee dddooonnnyyyaaa...".getBytes();
        
        // Buat berkas uji
        FileOutputStream sumber = new FileOutputStream(sumberStr);
        sumber.write(pesan);
        sumber.flush();
        sumber.close();
        
        KopiBerkas kopiBerkas = new KopiBerkas();
        kopiBerkas.kopi(sumberStr, sasaranStr);
        
        // Perikas apa hasil kopian benar
        FileInputStream sasaran = new FileInputStream(sasaranStr);
        byte[] bacaan = new byte[pesan.length];
        sasaran.read(bacaan);
        for (int indeks=0; indeks < pesan.length; ++indeks)
            assertEquals(pesan[indeks], bacaan[indeks]);
        sumber.close();
    }
    
    private String sumberStr = "ujisumber.txt";
    private String sasaranStr = "ujisasaran.txt";
}