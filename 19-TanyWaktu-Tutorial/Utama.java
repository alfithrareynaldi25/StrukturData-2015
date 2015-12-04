import java.io.IOException;
import java.net.UnknownHostException;

public class Utama {    
    public static void main(String[] args) {
        try {    
            TanyaWaktu tempatTanya = new TanyaWaktu();
            String jawaban = tempatTanya.jamBerapa("ptbtime1.ptb.de");
            System.out.println(jawaban);
        }
        catch (UnknownHostException salah) {
            System.err.println(salah);
        }
        catch (IOException salah) {
            System.err.println(salah);
        }
    }
}
