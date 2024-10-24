
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author juagsa
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File f = new File("Texto1.txt");

        if (!f.exists()) {
            f.createNewFile();

        } else {
            System.out.println("El archivo ya existe.");
        }

        try (FileWriter ff = new FileWriter("Texto1.txt")) {
            ff.write("a arbore\n");
            ff.write("o libro\n");
            ff.write("o neno\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader("Texto1.txt"); FileWriter fw = new FileWriter("Texto2.txt")) {

            int c;

            while ((c = fr.read()) != -1) {
                fw.write(c);
            }
            System.out.println("Contenido copiado de 'Texto1.txt' a 'Texto2.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
