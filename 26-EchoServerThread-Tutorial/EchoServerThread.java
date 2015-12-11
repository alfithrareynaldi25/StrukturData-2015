import java.net.Socket;
import java.net.ServerSocket;
import java.net.BindException;
import java.net.InetAddress;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class EchoServerThread {
    public EchoServerThread(int port) throws BindException, IOException {
        serverSocket = new ServerSocket(port);
    }
    
    public void dengar() {
        while (true) {
            try  {
                // Tunggu sampai ada koneksi dari client
                Socket koneksi = serverSocket.accept();
                
                // Buat thread untuk proses
                ProcessClientThread satuProcess = new ProcessClientThread(koneksi);
                Thread satuProcessThread = new Thread(satuProcess);
                satuProcessThread.start();                
            }
            catch(IOException err) {
                System.out.println(err);
            }
        }
    }
    
    private ServerSocket serverSocket = null;
    
    public static void main(String args[]) {
        try {            
            EchoServerThread server = new EchoServerThread(33333);
            server.dengar();
        }
        catch(BindException err) {
            System.out.println(err);
        }
        catch(IOException err) {
            System.out.println(err);
        }
    }
}
