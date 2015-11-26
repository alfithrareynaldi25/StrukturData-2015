public class Utama {
    public static void main(String[] args) {
        CetakRunnable cetak01 = new CetakRunnable("01");
        Thread thread01 = new Thread(cetak01);

        CetakRunnable cetak02 = new CetakRunnable("02");
        Thread thread02 = new Thread(cetak02);

        CetakRunnable cetak03 = new CetakRunnable("03");
        Thread thread03 = new Thread(cetak03);

        CetakRunnable cetak04 = new CetakRunnable("04");
        Thread thread04 = new Thread(cetak04);
        
        CetakRunnable cetak05 = new CetakRunnable("05");
        Thread thread05 = new Thread(cetak05);

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
    }
}
