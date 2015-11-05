import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiBecak {
    public UjiBecak() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }
    
    @Test
    public void constructor() {
        becak = new Becak(plat);
        assertTrue(becak instanceof Becak);
        assertTrue(becak instanceof Kendaraan);
        assertEquals(becak.plat(), plat);
        assertEquals(becak.tipe(), "Becak");
    }
    
    @Test
    public void plat() {
        becak = new Becak(plat);
        assertEquals(becak.plat(), plat);
    }

    @Test
    public void tipe() {
        becak = new Becak(plat);
        assertEquals(becak.tipe(), "Becak");
    }

    private String plat = "BLBLBL";
    private Becak becak;
}