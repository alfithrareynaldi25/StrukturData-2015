
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class KopiBerkasBuffer{
    public void kopi(String sumber, String sasaran) throws IOException{
        FileInputStream masukan = null;
        FileOutputStream keluaran = null;
        BufferedInputStream masukanBuffer = null;
        BufferedOutputStream keluaranBuffer = null;
        
        try{
            masukan = new FileInputStream(sumber);
            keluaran = new FileOutputStream(sasaran);
            masukanBuffer = new BufferedInputStream(masukan);
            keluaranBuffer = new BufferedOutputStream(keluaran);
            
            int karakter = masukanBuffer.read();
            while(karakter != -1){
                keluaranBuffer.write(karakter);
                karakter = masukanBuffer.read();
            }
            keluaranBuffer.flush();
        } 
        
        finally{
            if(masukan!= null)
                masukan.close();
            if(keluaran!= null)
                keluaran.close();
            if(masukanBuffer!= null)
                masukanBuffer.close();
            if(keluaranBuffer!= null){
                keluaranBuffer.close();
            }
        }
    }

    public static void main (String[] args){
        try{
            KopiBerkasBuffer kopiberkasbuffer = new KopiBerkasBuffer();
            kopiberkasbuffer.kopi("README.txt","README_2.txt");
        }
        
        catch(IOException kesalahan){
            System.out.printf("Terjadi kesalahan: %s",kesalahan);
        }
    }
}