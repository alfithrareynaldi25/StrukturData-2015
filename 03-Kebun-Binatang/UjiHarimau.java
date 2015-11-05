import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiHarimau {
    public UjiHarimau() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }

    @Test
    public void Harimau() {
        Harimau harimau = new Harimau();
        assertNotNull(harimau);
        assertTrue(harimau instanceof Harimau);
        assertTrue(harimau instanceof Mamalia);
        assertTrue(harimau instanceof Binatang);
        assertEquals(harimau.suara(), "Aum");
        assertEquals(harimau.jumlahKaki(), 4);
    }        
}