import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiPool {
    public UjiPool() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }
    
    @Test
    public void pool() {
        Pool pool = new Pool(null);
        assertNotNull(pool);
        assertTrue(pool instanceof Pool);
        assertEquals(pool.jumlah(), 0);
        assertNotNull(pool.daftarKendaraan());
        assertEquals(pool.daftarKendaraan().length, 0);

        String plat1 = "BL111";
        Mobil mobil = new Mobil(plat1);
        pool = new Pool(new Kendaraan[] {mobil});
        assertEquals(pool.jumlah(), 1);
        assertNotNull(pool.daftarKendaraan());
        assertEquals(pool.daftarKendaraan().length, 1);
        assertNotNull(pool.daftarKendaraan()[0]);
        assertNotNull(pool.daftarKendaraan()[0].tipe(), "Mobil");
        assertNotNull(pool.daftarKendaraan()[0].plat(), plat1);

        String plat2 = "BL222";
        Becak becak = new Becak(plat2);
        pool = new Pool(new Kendaraan[] {mobil, becak});
        assertEquals(pool.jumlah(), 2);
        assertNotNull(pool.daftarKendaraan());
        assertEquals(pool.daftarKendaraan().length, 2);
        assertNotNull(pool.daftarKendaraan()[0]);
        assertNotNull(pool.daftarKendaraan()[0].tipe(), "Mobil");
        assertNotNull(pool.daftarKendaraan()[0].plat(), plat1);
        assertNotNull(pool.daftarKendaraan()[1]);
        assertNotNull(pool.daftarKendaraan()[1].tipe(), "Becak");
        assertNotNull(pool.daftarKendaraan()[1].plat(), plat2);

        String plat3 = "BL333";
        SepedaMotor sepedaMotor = new SepedaMotor(plat3);
        pool = new Pool(new Kendaraan[] {mobil, becak, sepedaMotor});
        assertEquals(pool.jumlah(), 3);
        assertNotNull(pool.daftarKendaraan());
        assertEquals(pool.daftarKendaraan().length, 3);
        assertNotNull(pool.daftarKendaraan()[0]);
        assertNotNull(pool.daftarKendaraan()[0].tipe(), "Mobil");
        assertNotNull(pool.daftarKendaraan()[0].plat(), plat1);
        assertNotNull(pool.daftarKendaraan()[1]);
        assertNotNull(pool.daftarKendaraan()[1].tipe(), "Becak");
        assertNotNull(pool.daftarKendaraan()[1].plat(), plat2);
        assertNotNull(pool.daftarKendaraan()[2]);
        assertNotNull(pool.daftarKendaraan()[2].tipe(), "SepedaMotor");
        assertNotNull(pool.daftarKendaraan()[2].plat(), plat3);
    }
}