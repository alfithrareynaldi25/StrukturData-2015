import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiAlien {
    public UjiAlien() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }

    @Test
    public void Alien() {
        Alien alien = new Alien();
        assertNotNull(alien);
        assertTrue(alien instanceof Alien);
        assertTrue(alien instanceof Reptilia);
        assertTrue(alien instanceof Binatang);
        assertTrue(alien instanceof Komodo);
        assertTrue(alien instanceof Tumbuhan);
        assertEquals(alien.suara(), "Bip");
        assertEquals(alien.merayap(), false);
        assertEquals(alien.berbuah(), true);
    }        
}