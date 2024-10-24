
import java.io.*;



/**
 *
 * @author juagsa
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        File f = new File("Texto1.txt");
        
        if(!f.exists()){
            f.createNewFile();
        }else{
            System.out.println("Fichero ya creado¡¡¡¡¡");
        }
        
        try(PrintWriter pW=new PrintWriter(new BufferedWriter(new FileWriter("Texto1.txt")))){
            
            pW.println("a arbore");
            pW.println("os nenos");
            pW.println("as casas");
        }catch(IOException e){
            e.printStackTrace();
        }
        
        try{
            FileReader fR=new FileReader("Texto1.txt");
            BufferedReader bR=new BufferedReader(fR);
            FileWriter fW=new FileWriter("Texto2.txt");
            
            String c;
            
            while((c=bR.readLine())!=null){
                
                fW.write(c + System.lineSeparator()); // Separación del texto
                
            }
            fW.close();
        }catch(IOException e){
            
            e.printStackTrace();
            
        }
        
    }
    
}
