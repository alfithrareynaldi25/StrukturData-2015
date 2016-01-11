import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Client{
    Reader masukan=null;
    BufferedReader masukanBuff=null;
    public void chat() throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 33333);

        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Pesan: ");
            String ketikanSatuBaris = keyboard.nextLine();
            ketikanSatuBaris = ketikanSatuBaris.trim().toUpperCase();        
            // Tulis ke socket
            Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream()); 
            BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
            keluaranBuff.write(ketikanSatuBaris);
            keluaranBuff.write("\n");
            keluaranBuff.flush();

            // Baca dari Server
            System.out.print("Dari server: ");
            masukan = new InputStreamReader(socket.getInputStream()); 
            masukanBuff = new BufferedReader(masukan);
            String baris = masukanBuff.readLine();
            System.out.println(baris);

            if(baris.equals("Silahkan Masuk")){
                System.out.print("Pesan: ");
                String ketikanSatuBaris2 = keyboard.nextLine();
                ketikanSatuBaris2 = ketikanSatuBaris2.trim().toUpperCase();        
                keluaranBuff.write(ketikanSatuBaris2);
                keluaranBuff.write("\n");
                keluaranBuff.flush();

                masukanBuff = new BufferedReader(masukan);
                String baris2 = masukanBuff.readLine();
                System.out.println(baris2);
            }
                String baris3 = masukanBuff.readLine();
             if(baris3.equals("park")) {
                System.out.print("Pesan: ");
                String ketikanSatuBaris2 = keyboard.nextLine();
                ketikanSatuBaris2 = ketikanSatuBaris2.trim().toUpperCase();        
                keluaranBuff.write(ketikanSatuBaris2);
                keluaranBuff.write("\n");
                keluaranBuff.flush();

                masukanBuff = new BufferedReader(masukan);
                String baris2 = masukanBuff.readLine();
                System.out.println(baris2);          
            }
        }
        catch(IOException salah) {
            System.out.println(salah);
        }
        finally {
            if (socket != null)
                socket.close();
        }
    }
}
