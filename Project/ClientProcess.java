import java.net.Socket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Iterator;

public class ClientProcess implements Runnable{
    ArrayList<String> parkiran = new ArrayList<String>();
    private Socket koneksi; 

    String mobil[] = new String[2];
    String sepmor[] = new String[2];
    String sepeda[] = new String[2];

    public ClientProcess(Socket Koneksi){
        koneksi = Koneksi;
    }

    public void run(){
        try{
            if(koneksi != null)
                clientProcess(koneksi);
        }
        catch(IOException err){
            System.out.println(err);
        }
        catch(InterruptedException err){
            System.out.println(err);
        }
    }

    private void clientProcess(Socket koneksi) throws IOException, InterruptedException{
        String ip = koneksi.getInetAddress().getHostAddress();
        System.out.println("Dari: "+ip+"\n");

        int kodemobil = 0;
        int kodesepmor = 0;
        int kodesepeda = 0;
        int antrianm = 0;
        int antriansm = 0;
        int antrians = 0;
        int nomortiketm = 0;
        int nomortiketsm = 0;
        int nomortikets = 0;

        InputStream masukan = koneksi.getInputStream();
        BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan));

        String perintah = masukanReader.readLine();
        perintah = perintah.trim().toUpperCase();
        String[] baris = perintah.split("_");

        Calendar kalender = Calendar.getInstance();
        String waktuStr = kalender.getTime().toString();

        OutputStream keluaran = koneksi.getOutputStream();
        BufferedWriter keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));

        //Input plat dari si User
        if(baris[0].equals("M")){
            //Server cek kapasitas parkiran
            if(antrianm <= mobil.length-1){
                synchronized(this){
                    kodemobil++;
                    antrianm++;
                    String kodeM = "M"+kodemobil;
                    mobil[antrianm] = baris[1];

                    System.out.println(baris[1]);
                    keluaran = koneksi.getOutputStream();
                    keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                    keluaranBuf.write("Silahkan Masuk");
                    keluaranBuf.newLine();
                    keluaranBuf.flush();

                    String perintah2 = masukanReader.readLine();
                    perintah2 = perintah2.trim().toUpperCase();
                    if(perintah2.equals("TIC")){
                        nomortiketm++;
                        System.out.print("LM-0"+nomortiketm);
                        System.out.println("\tWaktu Masuk: "+waktuStr);
                        //String tampil1 = "\nMobil: "+antrianm+"\nSepeda Motor"+antriansm+"\nSepeda"+antrians;
                        String tampil = "LM-0"+nomortiketm+"\tWaktu Masuk: "+waktuStr;

                        keluaran = koneksi.getOutputStream();
                        keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));
                        //keluaranBuf.write(tampil1);
                        //keluaranBuf.newLine();
                        keluaranBuf.write(tampil);
                        keluaranBuf.newLine();
                        keluaranBuf.flush();

                        keluaranBuf.write("park");
                        keluaranBuf.newLine();
                        keluaranBuf.flush();
                    }

                    String perintah3 = masukanReader.readLine();
                    perintah3 = perintah3.trim().toUpperCase();
                    if(perintah3.equals("OUT")){
                        antrianm--;

                        Calendar out = Calendar.getInstance();
                        out.add(Calendar.HOUR_OF_DAY, 0);
                        String waktuOut = out.getTime().toString();

                        System.out.println(baris[1]+"\tLM-0"+nomortiketm);
                        System.out.println(waktuStr);
                        System.out.println(waktuOut);

                        //String tampil1 = "\nMobil: "+antrianm+"\nSepeda Motor"+antriansm+"\nSepeda"+antrians;
                        String tampil = baris[1]+"\tLM-0"+nomortiketm+"\t"+waktuOut;

                        keluaran = koneksi.getOutputStream();
                        keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                        //keluaranBuf.write(tampil1);
                        //keluaranBuf.newLine();
                        keluaranBuf.write(tampil);
                        keluaranBuf.newLine();
                        keluaranBuf.flush();
                    }
                }
            }else{
                String full = "Maaf, Parkiran sedang Penuh";
                keluaranBuf.write(full+"\n");
                keluaranBuf.newLine();
                keluaranBuf.flush();
            }
        }
        perintah = perintah.trim().toUpperCase();
        if(baris[0].equals("SM")){
            if(antriansm <= sepmor.length-1){
                synchronized(this){
                    kodesepmor++;
                    antriansm++;
                    String kodeSM = "SM"+kodesepmor;
                    mobil[antriansm] = baris[1];

                    System.out.println(baris[1]);

                    keluaran = koneksi.getOutputStream();
                    keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                    keluaranBuf.write("Silahkan Masuk");
                    keluaranBuf.newLine();
                    keluaranBuf.flush();

                    //Calendar kaalender = Calendar.getInstance();
                    //String WaktuStr = kaalender.getTime().toString();

                    String perintah2 = masukanReader.readLine();
                    perintah2 = perintah2.trim().toUpperCase();
                    if(perintah2.equals("TIC")){
                        nomortiketsm++;

                        System.out.print("LSM-0"+nomortiketsm);
                        System.out.println("\tWaktu Masuk: "+waktuStr);

                        //String tampil1 = "\nMobil: "+antrianm+"\nSepeda Motor"+antriansm+"\nSepeda"+antrians;
                        String tampil1 = "LSM-0"+nomortiketsm+"\tWaktu Masuk: "+waktuStr;

                        keluaran = koneksi.getOutputStream();
                        keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                        //keluaranBuf.write(tampil1);
                        //keluaranBuf.newLine();
                        keluaranBuf.write(tampil1);
                        keluaranBuf.newLine();
                        keluaranBuf.flush();

                        keluaranBuf.write("park");
                        keluaranBuf.newLine();
                        keluaranBuf.flush();
                    }
                    String perintah3 = masukanReader.readLine();
                    perintah3 = perintah3.trim().toUpperCase();
                    if(perintah3.equals("OUT")){
                        antriansm--;


                        Calendar out = Calendar.getInstance();
                        out.add(Calendar.HOUR_OF_DAY, 0);
                        String waktuOut = out.getTime().toString();

                        System.out.println(baris[1]+"\tLSM-0"+nomortiketsm);
                        System.out.println(waktuStr);
                        System.out.println(waktuOut);

                        //String tampil1 = "\nMobil: "+antrianm+"\nSepeda Motor"+antriansm+"\nSepeda"+antrians;
                        String tampil = baris[1]+"\tLSM-0"+nomortiketsm+"\t"+waktuOut;

                        keluaran = koneksi.getOutputStream();
                        keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                        //keluaranBuf.write(tampil1);
                        //keluaranBuf.newLine();
                        keluaranBuf.write(tampil);
                        keluaranBuf.newLine();
                        keluaranBuf.flush();
                    }
                }
            }else{
                String full = "Maaf, Parkiran sedang Penuh";
                keluaranBuf.write(full+"\n");
                keluaranBuf.newLine();
                keluaranBuf.flush();
            }
        }
        perintah = perintah.trim().toUpperCase();
        if(baris[0].equals("S")){
            if(antrians <= sepeda.length-1){
                synchronized(this){
                    kodesepeda++;
                    antrians++;
                    String kodeS = "S"+kodesepeda;
                    mobil[antrians] = baris[1];

                    System.out.println(baris[1]);

                    keluaran = koneksi.getOutputStream();
                    keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                    keluaranBuf.write("Silahkan Masuk");
                    keluaranBuf.newLine();
                    keluaranBuf.flush();

                    String perintah2 = masukanReader.readLine();
                    perintah2 = perintah2.trim().toUpperCase();
                    if(perintah2.equals("TIC")){
                        nomortikets++;
                        System.out.print("LS-0"+nomortikets);
                        System.out.println("\tWaktu Masuk: "+waktuStr);

                        // String tampil1 = "\nMobil: "+antrianm+"\nSepeda Motor"+antriansm+"\nSepeda"+antrians;
                        String tampil = "LS-0"+nomortikets+"\tWaktu Masuk"+waktuStr;

                        keluaran = koneksi.getOutputStream();
                        keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                        //keluaranBuf.write(tampil1);
                        //keluaranBuf.newLine();
                        keluaranBuf.write(tampil);
                        keluaranBuf.newLine();
                        keluaranBuf.flush();

                        keluaranBuf.write("park");
                        keluaranBuf.newLine();
                        keluaranBuf.flush();
                    }
                    String perintah3 = masukanReader.readLine();
                    perintah3 = perintah3.trim().toUpperCase();
                    if(perintah3.equals("OUT")){
                        antrians--;

                        Calendar out = Calendar.getInstance();
                        out.add(Calendar.HOUR_OF_DAY, 0);
                        String waktuOut = out.getTime().toString();

                        System.out.println(baris[1]+"\tLS-0"+nomortikets);
                        System.out.println(waktuStr);
                        System.out.println(waktuOut);

                        //String tampil1 = "\nMobil: "+antrianm+"\nSepeda Motor"+antriansm+"\nSepeda"+antrians;
                        String tampil = baris[1]+"\t"+nomortikets+"\t"+waktuOut;

                        keluaran = koneksi.getOutputStream();
                        keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                        //keluaranBuf.write(tampil1);
                        //keluaranBuf.newLine();
                        keluaranBuf.write(tampil);
                        keluaranBuf.newLine();
                        keluaranBuf.flush();
                    }
                }
            }else{
                String full = "Maaf, Parkiran sedang Penuh";
                keluaranBuf.write(full+"\n");
                keluaranBuf.newLine();
                keluaranBuf.flush();
            }
        }

        keluaranBuf.newLine();
        keluaranBuf.flush();

        //Scanner in = new Scanner(System.in);
        //String masukan = in.next();

        /*if(input.equals("STS")){
        System.out.println("Mobil"+antrianm);
        System.out.println("Sepeda Motor: "+antriansm);
        System.out.println("Sepeda: "+antrians);

        String tampil = "\nMobil: "+antrianm+"\nSepeda Motor"+antriansm+"\nSepeda"+antrians;

        keluaran = koneksi.getOutputStream();
        keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
        keluaranBuf.write(tampil);
        keluaranBuf.newLine();
        keluaranBuf.flush();
        }*/
    }

    private void prosesPermintaanClient() {
        try {                                                                  
            String ip = koneksi.getInetAddress().getHostAddress();
            //Tampilkan pesan
            System.out.println("Dari: "+ip+"\n");

            //Baca dari socket
            InputStream masukan = koneksi.getInputStream();
            BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
            String baris = masukanReader.readLine();
            while (baris != null) {
                System.out.println(baris);
                baris = masukanReader.readLine();
            }

            // Tunggu 2 detik
            System.out.println("Tunggu...");
            Thread.sleep(2000);
            System.out.println("Selesai tunggu...");

            koneksi.close();
        }
        catch(IOException err) {
            System.out.println(err);
        }
        catch(InterruptedException err) {
            System.out.println(err);
        }
    }
}