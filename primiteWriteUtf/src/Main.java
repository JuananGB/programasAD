import java.io.*;

/**
 *
 * @author juagsa
 */
public class Main {

   
    public File creacionFichero() throws IOException {
        String contenido = "\no tempo está xélido";
        String fichero = "/home/juagsa/NetBeansProjects/primiteWriteUtf/texto1.txt";

        File texto = new File(fichero);
        if (!texto.exists()) {
            texto.createNewFile();
        }

        try (FileOutputStream fos = new FileOutputStream(texto);
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeUTF(contenido);
        }

        return texto;
    }

    public static void main(String[] args) throws IOException {
        Main mainInstance = new Main();

        
            // Llamé al método para crear y escribir en el archivo
            mainInstance.creacionFichero();
            
            String fichero = "/home/juagsa/NetBeansProjects/primiteWriteUtf/texto1.txt";
            File nuevofichero = new File("/home/juagsa/NetBeansProjects/primiteWriteUtf/texto3.txt");

            if (!nuevofichero.exists()) {
                nuevofichero.createNewFile();
            }

            try (FileInputStream ficheroLectura = new FileInputStream(fichero);
                 BufferedInputStream bufferLectura = new BufferedInputStream(ficheroLectura);
                 DataInputStream dataLectura = new DataInputStream(bufferLectura);
                 
                 FileOutputStream escrituraBytes = new FileOutputStream(nuevofichero, true);
                 BufferedOutputStream bufferEscritura = new BufferedOutputStream(escrituraBytes);
                 DataOutputStream dataEscritura = new DataOutputStream(bufferEscritura)) {

                while (dataLectura.available() > 0) {
                    String cadena = dataLectura.readUTF();
                    dataEscritura.writeUTF(cadena);
                    dataEscritura.writeUTF("\nquedan: " + dataEscritura.size() + " bytes por leer.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
