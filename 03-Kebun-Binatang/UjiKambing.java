import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiKambing {
    public UjiKambing() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }

    @Test
    public void Kambing() {
        Kambing kambing = new Kambing();
        assertNotNull(kambing);
        assertTrue(kambing instanceof Kambing);
        assertTrue(kambing instanceof Mamalia);
        assertTrue(kambing instanceof Binatang);
        assertEquals(kambing.suara(), "Mbek");
        assertEquals(kambing.jumlahKaki(), 4);
    }        
}