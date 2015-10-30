import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UnitTest01.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UnitTest01 {
    /**
     * Default constructor for test class UnitTest01
     */
    public UnitTest01() { }

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
        assertEquals(vector3D.x, x, 0.01);
        assertEquals(vector3D.y, y, 0.01);
        assertEquals(vector3D.z, z, 0.01);
    }
    
    @Test
    public void vector3DUbahNilai() {        
        double xBaru = 9.87;
        double yBaru = 6.54;
        double zBaru = 3.21;   
        Vector3D vector3D = new Vector3D(x, y, z);
        
        vector3D.x = xBaru;
        vector3D.y = yBaru;
        vector3D.z = zBaru;
        assertEquals(vector3D.x, xBaru, 0.01);
        assertEquals(vector3D.y, yBaru, 0.01);
        assertEquals(vector3D.z, zBaru, 0.01);
    }
    
    private double x = 1.23;
    private double y = 4.56;
    private double z = 7.89;   
}