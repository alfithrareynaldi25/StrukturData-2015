import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiMobil {
    public UjiMobil() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }
    
    @Test
    public void constructor() {
        mobil = new Mobil(plat);
        assertTrue(mobil instanceof Kendaraan);
        assertTrue(mobil instanceof Mobil);
        assertEquals(mobil.plat(), plat);
        assertEquals(mobil.tipe(), "Mobil");
    }
    
    @Test
    public void plat() {
        mobil = new Mobil(plat);
        assertEquals(mobil.plat(), plat);
    }

    @Test
    public void tipe() {
        mobil = new Mobil(plat);
        assertEquals(mobil.tipe(), "Mobil");
    }

    private String plat = "BLBLBL";
    private Mobil mobil;
}