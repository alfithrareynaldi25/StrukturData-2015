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

public class Client {
    public void chat() 
    throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 33333);

        try {
            String baris=null;
            int i=0;
            Reader masukan=null;
            BufferedReader masukanBuff=null;

            for(; i<3;i++)
            {
                // Ketik
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Tebak Angka");
                System.out.print("Masukkan angka : ");
                baris=keyboard.nextLine();

                // Tulis ke socket
                Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream()); 
                BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
                keluaranBuff.write(baris);
                keluaranBuff.write("\n");
                keluaranBuff.flush();

                // Baca dari Server
                System.out.print("Dari server: ");
                masukan = new InputStreamReader(socket.getInputStream()); 
                masukanBuff = new BufferedReader(masukan);
                baris = masukanBuff.readLine();
                System.out.println(baris);         

                if(baris.equalsIgnoreCase("Benar"))
                    break;
            }

            if(i==3)
            masukan = new InputStreamReader(socket.getInputStream()); 
            masukanBuff = new BufferedReader(masukan);
                baris = masukanBuff.readLine();
                System.out.println("Kalah, angka = "+baris);
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
