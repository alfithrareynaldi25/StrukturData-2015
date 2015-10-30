import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class UnitTest03 {
    /**
     * Default constructor for test class UnitTest03
     */
    public UnitTest03() { }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() { 
        t = new Date();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() { }
    
    @Test
    public void vector4D() {        
        Vector4D vector4D = new Vector4D(x, y, z, t);
        assertTrue(vector4D instanceof Vector4D);
        assertTrue(vector4D instanceof Vector3D);
        assertEquals(vector4D.getX(), x, 0.01);
        assertEquals(vector4D.getY(), y, 0.01);
        assertEquals(vector4D.getZ(), z, 0.01);
        assertNotNull(vector4D.getT());
        assertEquals(vector4D.getT(), t);
    }

    private double x = 1.23;
    private double y = 4.56;
    private double z = 7.89;   
    private Date t;
}