import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiKomodo {
    public UjiKomodo() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }

    @Test
    public void Komodo() {
        Komodo komodo = new Komodo();
        assertNotNull(komodo);
        assertTrue(komodo instanceof Komodo);
        assertTrue(komodo instanceof Reptilia);
        assertTrue(komodo instanceof Binatang);
        assertEquals(komodo.suara(), "Sss");
        assertEquals(komodo.merayap(), false);
    }        
}