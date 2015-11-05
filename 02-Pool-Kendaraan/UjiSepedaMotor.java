import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiSepedaMotor {
    public UjiSepedaMotor() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }
    
    @Test
    public void constructor() {
        sepedaMotor = new SepedaMotor(plat);
        assertTrue(sepedaMotor instanceof SepedaMotor);
        assertTrue(sepedaMotor instanceof Kendaraan);
        assertEquals(sepedaMotor.plat(), plat);
        assertEquals(sepedaMotor.tipe(), "SepedaMotor");
    }
    
    @Test
    public void plat() {
        sepedaMotor = new SepedaMotor(plat);
        assertEquals(sepedaMotor.plat(), plat);
    }

    @Test
    public void tipe() {
        sepedaMotor = new SepedaMotor(plat);
        assertEquals(sepedaMotor.tipe(), "SepedaMotor");
    }

    private String plat = "BLBLBL";
    private SepedaMotor sepedaMotor;
}