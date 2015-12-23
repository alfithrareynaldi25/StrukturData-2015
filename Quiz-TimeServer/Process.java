import java.net.Socket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.Calendar;

public class Process implements Runnable {
    public Process(Socket koneksiKiriman) {
        koneksi = koneksiKiriman;
    }

    public void run(){
        try {
            if(koneksi != null)
                prosesPermintaanClient();
        }
        catch(IOException err) {
            System.out.println(err);
        }
    }

    private void prosesPermintaanClient() throws IOException {
        String ip = koneksi.getInetAddress().getHostAddress();
        System.out.println("Dari: " + ip);
        Calendar kalender = Calendar.getInstance();
        String baris=null;
        OutputStream keluaran=null;
        BufferedWriter keluaranBuf=null;
        InputStream masukan = koneksi.getInputStream();
        BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
        baris = masukanReader.readLine();

        if(baris.equals("SIAPA")){
            keluaran = koneksi.getOutputStream();
            keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));
            keluaranBuf.write(""+ip);
            keluaranBuf.newLine();
            keluaranBuf.flush();
        }
        else if(baris.equals("WAKTU")){
            String waktuStr = kalender.getTime().toString();
            keluaran = koneksi.getOutputStream();
            keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));
            keluaranBuf.write(""+waktuStr);
            keluaranBuf.newLine();
            keluaranBuf.flush();
        }
        else{
            keluaran = koneksi.getOutputStream();
            keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));
            keluaranBuf.write("Perintah tidak dikenal!!");
            keluaranBuf.newLine();
            keluaranBuf.flush();
        }
    }
    private Socket koneksi; 
}