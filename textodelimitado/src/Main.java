
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author juagsa
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};

        File f = new File("Texto1.txt");

        if (!f.exists()) {
            f.createNewFile();
            System.out.println("Fichero creado");
        } else {
            System.out.println("Fichero ya creado con anterioridad");
        }

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f,true)))) {
            
            pw.println("Resultado de la lectura:\n");

            for (int i = 0; i < cod.length; i++) {

                pw.println("Código: " + cod[i]);
                pw.println("Descripción: " + desc[i]);
                pw.println("Precio: " + prezo[i] + "€");
                pw.println("\t");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            String c;

            while ((c = br.readLine()) != null) {

                System.out.println(c);
            }
            br.close();
        }

    }

}
