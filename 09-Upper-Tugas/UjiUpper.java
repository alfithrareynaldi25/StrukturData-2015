import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class UjiUpper {
    public UjiUpper() { }

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
    public void upper() throws IOException {
        // Buat berkas uji
        FileOutputStream sumber = new FileOutputStream(sumberStr);
        sumber.write(isiSumber.getBytes());
        sumber.flush();
        sumber.close();
        
        new Upper().upper(sumberStr, sasaranStr);
        
        // Perikas apa hasil benar
        int panjang = (int) new File(sasaranStr).length();
        byte[] bacaan = new byte[panjang];
        byte[] isiSumberByte = isiSasaran.getBytes();
        FileInputStream sasaran = new FileInputStream(sasaranStr);
        sasaran.read(bacaan);
        for (int indeks=0; indeks < isiSumberByte.length; ++indeks)
            assertEquals(isiSumberByte[indeks], bacaan[indeks]);
        sumber.close();
        
    }
    
    private String sumberStr = "ujiupper.txt";
    private String sasaranStr = "ujiupper2.txt";
    
    private String isiSumber = "aloe DOnya ke-3!";
    private String isiSasaran = isiSumber.toUpperCase();
}
