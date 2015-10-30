import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UnitTest02.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UnitTest02 {
    /**
     * Default constructor for test class UnitTest02
     */
    public UnitTest02() { }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() { }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() { }
    
    @Test
    public void vector3D() {        
        Vector3D vector3D = new Vector3D(x, y, z);
        assertEquals(vector3D.getX(), x, 0.01);
        assertEquals(vector3D.getY(), y, 0.01);
        assertEquals(vector3D.getZ(), z, 0.01);
    }

    private double x = 1.23;
    private double y = 4.56;
    private double z = 7.89;   
}
