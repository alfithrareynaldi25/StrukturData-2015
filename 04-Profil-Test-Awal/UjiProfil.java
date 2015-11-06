import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UjiProfil {
    public UjiProfil() { }

    @Before
    public void setUp() { }

    @After
    public void tearDown() { }
    
    @Test
    public void constructorDefault() {
        profil = new Profil();
        assertTrue(profil instanceof  Profil);
        assertNotNull(profil.getNama());
        assertTrue(profil.getNama() instanceof  String);
        assertNotNull(profil.getNim());
        assertTrue(profil.getNim() instanceof  String);
        
        String nim = profil.getNim();
        String hasilStr = nim.substring(nim.length()-4, nim.length());
        System.out.println(hasilStr);
        long hasil = Long.valueOf(hasilStr)*3;
        System.out.println(hasil);
        System.out.print("Isi angka berikut di form: ");
        System.out.println(hasil);
    }

    @Test
    public void constructor() {
        profil = new Profil(nama, nim);
        assertNotNull(profil);
        assertTrue(profil instanceof  Profil);
    }
    
    @Test
    public void getNama() {
        profil = new Profil(nama, nim);
        assertTrue(profil instanceof  Profil);
        assertNotNull(profil.getNama());
        assertTrue(profil.getNama() instanceof  String);
        assertEquals(profil.getNama(), nama);
    }
    
    @Test
    public void getNim() {
        profil = new Profil(nama, nim);
        assertTrue(profil instanceof  Profil);
        assertNotNull(profil.getNim());
        assertTrue(profil.getNim() instanceof  String);
        assertEquals(profil.getNim(), nim);
    }
    
    private String nama = "NamaKu";
    private String nim = "NIMKu";
    private Profil profil;
}