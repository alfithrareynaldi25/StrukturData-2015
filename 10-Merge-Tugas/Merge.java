
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Merge {
    public void merge (String file1, String file2, String file3, String sasaran)throws IOException{
        FileInputStream merge_file1 = null;
        FileInputStream merge_file2 = null;
        FileInputStream merge_file3 = null;
        FileOutputStream keluaran = null;
        
        try{
            merge_file1 = new FileInputStream(file1);
            merge_file2 = new FileInputStream(file2);
            merge_file3 = new FileInputStream(file3);
            keluaran = new FileOutputStream(sasaran);
            
            int karakter = merge_file1.read();
            while(karakter != -1){
                keluaran.write(karakter);
                karakter = merge_file1.read();
            }

            keluaran = new FileOutputStream(sasaran,true);
            
            karakter = merge_file2.read();
            while (karakter != -1){
                keluaran.write(karakter);
                karakter = merge_file2.read();
            }

            keluaran = new FileOutputStream(sasaran,true);
            
            karakter = merge_file3.read();
            while (karakter != -1){
                keluaran.write(karakter);
                karakter = merge_file3.read();
            }
            keluaran.flush();
        }
        
        finally{
            if (merge_file1!=null)
                merge_file1.close();
            if (merge_file2!= null)
                merge_file2.close();
            if (merge_file3!= null)
                merge_file3.close(); 
            if (keluaran!= null)
                keluaran.close();
        }
    }
}