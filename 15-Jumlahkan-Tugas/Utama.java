public class Utama {
    public static void main(String[] args) {
        double[] data = new double[BANYAK_DATA];
    
        for (int cnt=0; cnt<data.length; ++ cnt)
            data[cnt] = cnt * 2;
            
        
        long start = System.currentTimeMillis();
        Gabung gabung = new Gabung(data);
        long end = System.currentTimeMillis();
        System.out.printf("Hasil perhitungan paralel = %f\n", gabung.hasil());        
        System.out.printf("Waktu = %dms\n\n", end-start);        

        double hasil = 0;
        start = System.currentTimeMillis();
        for (int cnt = 0; cnt<BANYAK_DATA; ++cnt)
            hasil += data[cnt];
        end = System.currentTimeMillis();
        System.out.printf("Hasil perhitungan serial = %f\n", hasil);        
        System.out.printf("Waktu = %dms\n\n", end-start);        
    }
    
    private final static int BANYAK_DATA = 10000;
}
