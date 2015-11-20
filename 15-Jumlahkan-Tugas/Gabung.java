
public class Gabung{
    private double[] data;
    private Kelompok[] kelompok = new Kelompok[5];
    
    public Gabung(double[] data){
        int awal = 0;
        int akhir = data.length/5-1;
        kelompok[0] = new Kelompok(awal,akhir,data);
        Thread thread01 = new Thread(kelompok[0]);
        
        awal = data.length/5;
        akhir = 2*data.length/5-1;
        kelompok[1] = new Kelompok(awal,akhir,data);
        Thread thread02 = new Thread(kelompok[1]);
        
        awal = 2*data.length/5;
        akhir = 3*data.length/5-1;
        kelompok[2] = new Kelompok(awal,akhir,data);
        Thread thread03 = new Thread(kelompok[2]);
        
        awal = 3*data.length/5;
        akhir = 4*data.length/5-1;
        kelompok[3] = new Kelompok(awal,akhir,data);
        Thread thread04 = new Thread(kelompok[3]);
        
        awal = 4*data.length/5;
        akhir = 5*data.length/5-1;
        kelompok[4] = new Kelompok(awal,akhir,data);
        Thread thread05 = new Thread(kelompok[4]);
        
        
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
        }
    
    public double hasil(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
        }
        return kelompok[0].hasil()+kelompok[1].hasil()+kelompok[2].hasil()+kelompok[3].hasil()+kelompok[4].hasil();
    }
}