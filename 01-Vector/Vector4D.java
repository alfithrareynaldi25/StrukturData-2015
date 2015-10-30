
import java.util.Date;

public class Vector4D extends Vector3D {
    
    private double x;
    private double y;
    private double z;
    private Date t;
    
    public Vector4D (double x, double y, double z, Date t) {
        super(x,y,z);
        this.t=t;
    }
    
    Date getT() {
        return t;
    }
}