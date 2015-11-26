public class Utama {
    public static void main(String[] args) {
        CetakThread thread01 = new CetakThread("01");
        CetakThread thread02 = new CetakThread("02");
        CetakThread thread03 = new CetakThread("03");
        CetakThread thread04 = new CetakThread("04");
        CetakThread thread05 = new CetakThread("05");

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
    }
}
