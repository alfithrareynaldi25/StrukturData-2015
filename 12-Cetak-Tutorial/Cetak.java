public class Cetak {
    public Cetak(String nama) {
        this.nama = nama;
    }

    public void cetak() {
        for (int cnt=0; cnt<5; ++cnt)
            System.out.println("Hello dari thread " + this.nama);
    }
    
    private String nama; 
    
    
}