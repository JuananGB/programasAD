import java.io.File;
import java.io.IOException;

public class Arquivos {

    // 1)
    
    public  void eDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (directorio.isDirectory()) {
            System.out.println("é un directorio");
        } else {
            System.out.println("non é un directorio");
        }
    }

    // 2)
    
    public  void eFicheiro(String ruta) {
        File ficheiro = new File(ruta);
        if (ficheiro.isFile()) {
            System.out.println("é un ficheiro");
        } else {
            System.out.println("non é un ficheiro");
        }
    }

    // 3)
    
    public void creaDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("Directorio creado con éxito.");
            } else {
                System.out.println("Non se puido crear o directorio.");
            }
        } else {
            System.out.println("O directorio xa existe.");
        }
    }

    // 4)
    
    public  void creaFicheiro(String dirName, String fileName) {
        File ficheiro = new File(dirName, fileName);
        if (!ficheiro.exists()) {
            try {
                if (ficheiro.createNewFile()) {
                    System.out.println("Ficheiro creado con éxito.");
                } else {
                    System.out.println("Non se puido crear o ficheiro.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O ficheiro xa existe.");
        }
    }

    // 5)
    
    public void modoAcceso(String dirName, String fileName) {
        File ficheiro = new File(dirName, fileName);
        if (ficheiro.canWrite()) {
            System.out.println("escritura si");
        } else {
            System.out.println("escritura non");
        }
        if (ficheiro.canRead()) {
            System.out.println("lectura si");
        } else {
            System.out.println("lectura non");
        }
    }

    // 6) 
    
    public void calculaLonxitude(String dirName, String fileName) {
        File ficheiro = new File(dirName, fileName);
        System.out.println("Lonxitude: " + ficheiro.length() + " bytes");
    }

    // 7)
    
    public void mLectura(String dirName, String fileName) {
        File ficheiro = new File(dirName, fileName);
        if (ficheiro.setReadOnly()) {
            System.out.println("O ficheiro agora é de só lectura.");
        } else {
            System.out.println("Non se puido cambiar a só lectura.");
        }
    }

    // 8) 
    
    public void mEscritura(String dirName, String fileName) {
        File ficheiro = new File(dirName, fileName);
        if (ficheiro.setWritable(true)) {
            System.out.println("O ficheiro agora é editable.");
        } else {
            System.out.println("Non se puido cambiar a modo editable.");
        }
    }

    // 9) 
    
    public void borraFicheiro(String dirName, String fileName) {
        File ficheiro = new File(dirName, fileName);
        if (ficheiro.exists()) {
            if (ficheiro.delete()) {
                System.out.println("Ficheiro eliminado.");
            } else {
                System.out.println("Non se puido eliminar o ficheiro.");
            }
        } else {
            System.out.println("Ficheiro inexistente.");
        }
    }

    // 10) 
    public static void borraDirectorio(String dirName) {
        File directorio = new File(dirName);
        if (directorio.exists()) {
            if (directorio.delete()) {
                System.out.println("Directorio eliminado.");
            } else {
                System.out.println("Non se puido eliminar o directorio. Pode ter arquivos dentro.");
            }
        } else {
            System.out.println("Ruta inexistente ou con descendencia.");
        }
    }

    // 11) 
    public static void mContido(String dirName) {
        File directorio = new File(dirName);
        if (directorio.isDirectory()) {
            String[] contidos = directorio.list();
            if (contidos != null) {
                for (String contido : contidos) {
                    System.out.println(contido);
                }
            }
        } else {
            System.out.println("Non é un directorio válido.");
        }
    }

   
}

     
