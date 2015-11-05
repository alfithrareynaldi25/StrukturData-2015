import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiMangga {
    public UjiMangga() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }

    @Test
    public void Mangga() {
        Mangga mangga = new Mangga();
        assertNotNull(mangga);
        assertTrue(mangga instanceof Mangga);
        assertTrue(mangga instanceof Tumbuhan);
        assertEquals(mangga.berbuah(), true);
    }        
}