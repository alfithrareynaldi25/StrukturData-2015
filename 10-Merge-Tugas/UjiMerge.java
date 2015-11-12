import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class UjiMerge {
    public UjiMerge() { }

    @Before
    public void setUp() { 
        File file = new File(file1Str);
        if (file.exists() == true)
            file.delete();
        file = new File(file2Str);
        if (file.exists() == true)
            file.delete();
        file = new File(file3Str);
        if (file.exists() == true)
            file.delete();
        file = new File(sasaranStr);
        if (file.exists() == true)
            file.delete();
    }

    @After
    public void tearDown() { 
        File file = new File(file1Str);
        if (file.exists() == true)
            file.delete();
        file = new File(file2Str);
        if (file.exists() == true)
            file.delete();
        file = new File(file3Str);
        if (file.exists() == true)
            file.delete();
        file = new File(sasaranStr);
        if (file.exists() == true)
            file.delete();
    }
    
    @Test
    public void merge() throws IOException {
        // Buat berkas uji
        FileOutputStream sumber = new FileOutputStream(file1Str);
        sumber.write(isiFile1.getBytes());
        sumber.flush();
        sumber.close();
        sumber = new FileOutputStream(file2Str);
        sumber.write(isiFile2.getBytes());
        sumber.flush();
        sumber.close();
        sumber = new FileOutputStream(file3Str);
        sumber.write(isiFile3.getBytes());
        sumber.flush();
        sumber.close();
        
        new Merge().merge(file1Str, file2Str, file3Str, sasaranStr);
        
        // Perikas apa hasil benar
        int panjang = (int) new File(file1Str).length()
                      + (int) new File(file2Str).length()
                      + (int) new File(file3Str).length();
        byte[] bacaan = new byte[panjang];
        byte[] isiHasilByte = isiHasil.getBytes();
        FileInputStream sasaran = new FileInputStream(sasaranStr);
        sasaran.read(bacaan);
        for (int indeks=0; indeks < isiHasilByte.length; ++indeks)
            assertEquals(isiHasilByte[indeks], bacaan[indeks]);
        sumber.close();
        
    }
    
    private String file1Str = "ujimerge1.txt";
    private String file2Str = "ujimerge2.txt";
    private String file3Str = "ujimerge3.txt";
    private String sasaranStr = "ujimergesasaran.txt";
    
    private String isiFile1 = "aloe DOnya ke-3!";
    private String isiFile2 = isiFile1.toUpperCase();
    private String isiFile3 = isiFile1;
    private String isiHasil = isiFile1 + isiFile2 + isiFile3;
}
