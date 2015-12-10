import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Utama{
    public static void main(String[] args) {
        try {
            Chat send = new Chat();
            Scanner input = new Scanner(System.in);
            System.out.print("Me: ");
            String kata = new String();
            kata = input.nextLine();
            
            send.chat(kata);
        }
        catch (UnknownHostException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
