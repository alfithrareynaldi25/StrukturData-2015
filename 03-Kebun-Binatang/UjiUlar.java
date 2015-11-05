import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiUlar {
    public UjiUlar() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }

    @Test
    public void Ular() {
        Ular ular = new Ular();
        assertNotNull(ular);
        assertTrue(ular instanceof Ular);
        assertTrue(ular instanceof Reptilia);
        assertTrue(ular instanceof Binatang);
        assertEquals(ular.suara(), "Sss");
        assertEquals(ular.merayap(), true);
    }        
}