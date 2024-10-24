
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main {
    
    public static void main(String[] args) throws IOException {
        
        String fichero= "/home/juagsa/NetBeansProjects/copybytesimaxe/foto.jpg";
        
        
        File nuevoFichero=new File("/home/juagsa/NetBeansProjects/copybytesimaxe2/foto2.jpg");
        
        nuevoFichero.createNewFile();
       
            try{
                
                FileInputStream lecturaBytes = new FileInputStream(fichero);
                
                //FileOutputStream escrituraBytes = new FileOutputStream(nuevoFichero);
                
                FileOutputStream escrituraBytes = new FileOutputStream(nuevoFichero,true);
                
                BufferedInputStream bufferLectura = new BufferedInputStream(lecturaBytes);
                BufferedOutputStream bufferEscritura = new BufferedOutputStream(escrituraBytes);
                
                
                int bytes;
                while((bytes=bufferLectura.read())!=-1){
                
                    bufferEscritura.write(bytes);
                }
                               
            }catch(Exception e){
                e.printStackTrace();
            }
    
    }
    
}
