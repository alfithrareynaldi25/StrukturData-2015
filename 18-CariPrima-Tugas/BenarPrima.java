/**
 * Thread untuk memeriksa apakah suatu bilangan prima atau tidak.
 */
public class BenarPrima implements Runnable {
    /**
     * Constructor
     * 
     * @param angka Angka yang hendak diperiksa prima atau tidak.
     */
    public BenarPrima(int angka) {
        this.angka = angka;
        this.selesai = false;
        this.prima = false;
    }
    
    /**
     * Status perhitungan telah selesai atau belum
     */
    public boolean selesai() {
        return selesai;
    }
    
    /**
     * Angka yang henda diperiksa bilangan prima atau tidak
     */
    public int angka() {
        return angka;
    }
    
    /**
     * Hasil perhitungan. Jika true berarti prima dan false jika tidak. 
     * NOTE: jika selesai masih false maka hasil perhitungan belum 
     * mengembalikan nilai yang sah.
     */
    public boolean prima() {
        return prima;
    }
    
    /**
     * Periksa apakah angka yang diberikan nilangan prima atau tidak. Jika 
     * bilangan prima maka akan nilai variable prima akan dijadikan true tetapi
     * seandainya bukan bilangan prima maka nilai variable prima akan dijadikan 
     * false.
     */
    public void benarPrima() {        
        if (angka <= 1) // Jika angka 1 berarti otomatis bukan prima
            prima = false;
        else {
            prima = true;
            for (int counter=2;       // Mulai periksa dari angka 2
                 counter<(angka/2+1); // Periksa sampai setengahnya saja. Ingat
                                      // hukum komutatif!
                 ++counter)
                if ((angka % counter) == 0) { // Jika habis dibagi berarti
                    prima = false;            // bukan prima
                    // Akhiri proses karena tidak perlu periksa angka yang lain
                    return;                    
                }
        }
    }
    
    /**
     * Main-nya thread
     */
    public void run() {
        selesai = false;
        benarPrima();
        selesai = true;
    }
    
    // Angka yang mau diperiksa
    private int angka;
    // Apakah angka bilangan prima atau tidak
    private boolean prima = false;
    // Apakah proses perhitungan telah selesai atau belum
    private boolean selesai = false;
}