
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



/**
 *
 * @author juagsa
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        String fichero= "/home/juagsa/NetBeansProjects/copybytestexto/texto1.txt";
        
        
        File nuevoFichero=new File("/home/juagsa/NetBeansProjects/copybytestexto/texto2.txt");
        
        nuevoFichero.createNewFile();
       
            try{
                
                FileInputStream lecturaBytes = new FileInputStream(fichero);
                
                //FileOutputStream escrituraBytes = new FileOutputStream(nuevoFichero);
                
                FileOutputStream escrituraBytes = new FileOutputStream(nuevoFichero,true);
                
                int bytes;
                     
                while((bytes=lecturaBytes.read())!=-1){
                    
                    escrituraBytes.write(bytes);
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
                  
    }
    
}
