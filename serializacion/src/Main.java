
import java.io.File;
import java.io.*;

/**
 *
 * @author juagsa
 */
public class Main {

    public static void main(String[] args) throws IOException {

        mclase clase1 = new mclase("ola", -7, 2.7E10);

        mclase clase2 = new mclase();

        File f = new File("serial.txt");

        if (!f.exists()) {
            f.createNewFile();
        } else {
            System.out.println("Fichero ya creado");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {

            oos.writeObject(clase1);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Serializacion del objeto1: ");
        System.out.println("Objeto1: "+clase1);
        
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {

            clase2=(mclase)ois.readObject();
            
       
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
         System.out.println("Deserializacion del objeto despues del cambio:");
         System.out.println("Objeto2: " + clase2);
        

    }
}
