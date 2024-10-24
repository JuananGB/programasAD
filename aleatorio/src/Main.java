
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author juagsa
 */
public class Main {

    public static void main(String[] args) {

        String[] codes = {"p1", "p2", "p3"};
        String[] descricion = {"parafusos", "cravos ", "tachas"};
        int[] prices = {3, 4, 5};

        File f = new File("aleatorio.txt");

        try {

            if (!f.exists()) {
                f.createNewFile();
            } else {
                System.out.println("Fichero ya creado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Escritura
        try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) {

            for (int i = 0; i < codes.length; i++) {
                raf.writeUTF(codes[i]);
                raf.writeUTF(descricion[i]);
                raf.writeInt(prices[i]);
            }

            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Lectura
        try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {

            // Posicionar el puntero en el inicio del segundo registro
            raf.seek(0);  // Asegurarse de comenzar desde el principio
            // Saltar el primer registro
            raf.readUTF();  // Saltar el primer código
            raf.readUTF();  // Saltar la primera descripción
            raf.readInt();  // Saltar el primer precio

            // Leer el segundo registro
            String code = raf.readUTF();         // Leer el segundo código
            String description = raf.readUTF();  // Leer la segunda descripción
            int price = raf.readInt();           // Leer el segundo precio

            System.out.printf("Código: %s, Descripción: %s, Precio: %d%n", code, description, price);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
