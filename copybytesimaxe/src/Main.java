
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juan Antonio Gzlez Boloña
 */
public class Main {
    
     public static void main(String[] args) throws IOException {
        
        String fichero= "/home/juagsa/NetBeansProjects/copybytesimaxe/foto.jpg";
        
        
        File nuevoFichero=new File("/home/juagsa/NetBeansProjects/copybytesimaxe/foto2.jpg");
        
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
