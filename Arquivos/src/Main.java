

public class Main {

    public static void main(String[] args) {
        String rutaBase = "/home/juagsa/NetBeansProjects/Arquivos";
       
        
        Arquivos a = new Arquivos();

        // 1) 
        a.creaDirectorio("arquivosDir");
        a.eDirectorio(rutaBase);
        
        
        // 2) 
        
        a.creaFicheiro("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir", "Products1.txt");
        
        a.eFicheiro("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir");
        
       

        // 3) 
        
        a.creaDirectorio("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir/subDir");
        a.creaFicheiro("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir/subDir","Products2.txt");
        
        // 4) 
        
        a.mContido("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir");

        
        // 5) 
        
        a.modoAcceso("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir", "Products1.txt");
        a.calculaLonxitude("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir","Products1.txt");
        //
        a.calculaLonxitude("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir","Products1.txt");

        
        // 6)
        
        a.mLectura("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir","Products1.txt");

        // 7) 
        
        a.mEscritura("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir","Products1.txt");

        // 8) 
       
        a.borraFicheiro("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir","Products1.txt");

        // 9) 
        
        a.borraFicheiro("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir/subDir", "Products2.txt");
        a.borraDirectorio("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir/subDir");
        a.borraDirectorio("/home/juagsa/NetBeansProjects/Arquivos/arquivosDir");


    }
}

