import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**

* The test class UjiAKeAt.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UjiAKeAt {
    public UjiAKeAt() { }

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
    public void aKeAt() throws IOException {
        byte[] pesan = "Aaallloooeee dddooonnnyyyaaa...".getBytes();
        byte[] pesanUbah = "@@@llloooeee dddooonnnyyy@@@...".getBytes();
        
        // Buat berkas uji
        FileOutputStream sumber = new FileOutputStream(sumberStr);
        sumber.write(pesan);
        sumber.flush();
        sumber.close();
        
        AKeAt aKeAt = new AKeAt();
        aKeAt.aKeAt(sumberStr, sasaranStr);
        
        // Perikas apa hasil aKeAt benar
        FileInputStream sasaran = new FileInputStream(sasaranStr);
        byte[] bacaan = new byte[pesanUbah.length];
        sasaran.read(bacaan);
        for (int indeks=0; indeks < pesanUbah.length; ++indeks)
            assertEquals(pesanUbah[indeks], bacaan[indeks]);
        sumber.close();
    }
    
    private String sumberStr = "ujisumber.txt";
    private String sasaranStr = "ujisasaran.txt";
}