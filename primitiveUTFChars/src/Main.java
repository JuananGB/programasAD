

/**
 *
 * @author juagsa
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        String cadea = "Está en casa";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("text6.dat"))) {

            // 1. Primera cadena escrita con WriteUTF
            System.out.println("writeUTF escribindo: " + cadea);
            dos.writeUTF(cadea);
            System.out.println("bytes totais escritos: " + dos.size() + " bytes");

            // 2. Segunda cadena escrita con writeChars
            System.out.println("writeChars escribindo: " + cadea);
            for (char ch : cadea.toCharArray()) {  //Bucle necesario para recorrer la cadena
                dos.writeChar(ch);
            }
            System.out.println("bytes totais escritos: " + dos.size() + " bytes");

            // 3. Terceira cadena escrita con writeUTF
            System.out.println("writeUTF escribindo: " + cadea);
            dos.writeUTF(cadea);
            System.out.println("bytes totais escritos: " + dos.size() + " bytes");

        } catch (IOException e) {
            e.printStackTrace();
        }

          
        try (DataInputStream dis = new DataInputStream(new FileInputStream("text6.dat"))) {
            System.out.println("bytes totais por ler = " + dis.available() + " bytes");

            // Lellendo la primera cadena grabada con readUTF
            String cadea1 = dis.readUTF();
            System.out.println("lemos a primeira cadea en UTF: " + cadea1);
            System.out.println("numero de bytes por ler: " + dis.available() + " bytes");

            // Lellendo la segunda cadena grabada con writeChars (usando readChar)
            System.out.print("lemos a segunda cadea con readChar() en bucle: ");
            StringBuilder cadea2 = new StringBuilder();
            for (int i = 0; i < cadea.length(); i++) {
                cadea2.append(dis.readChar());
            }
            System.out.println(cadea2);
            System.out.println("numero de bytes por ler: " + dis.available() + " bytes");

            // Lellendo la terceira cadena grabada con readUTF
            String cadea3 = dis.readUTF();
            System.out.println("lemos a terceira cadea mediante readUTF: " + cadea3);
            System.out.println("numero de bytes por ler: " + dis.available() + " bytes");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

