
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AKeAt {
    public void aKeAt(String sumber, String sasaran) throws IOException{
        FileInputStream masukan = null;
        FileOutputStream keluaran = null;
        
        try{
            masukan = new FileInputStream(sumber);
            keluaran = new FileOutputStream(sasaran);
            
            int karakter = masukan.read();
            while (karakter != -1){
                if(karakter==65 || karakter==97){
                    karakter=64;
                }
                keluaran.write(karakter);
                karakter = masukan.read();
            }
            keluaran.flush();
        }
        
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
        
        finally {
            if (masukan != null)
                masukan.close();
            if (keluaran != null)
                keluaran.close();
        }
    }
}