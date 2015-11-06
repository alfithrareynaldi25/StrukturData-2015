
public class Profil {
    
    private String nama = "Alfithra Reynaldi";
    private String nim = "1408107010040";
    
    public Profil(){
    }
    
    public Profil(String nama, String nim){
        this.nama=nama;
        this.nim=nim;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getNim(){
        return nim;
    }
}