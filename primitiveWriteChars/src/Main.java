

import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juagsa
 */
public class Main {
    
    
    public File escribirFichero() throws IOException{
        
        String cadea="o tempo está xélido";
        
        String fichero="/home/juagsa/NetBeansProjects/primitiveWriteChars/texto5.dat";
        
        File texto = new File(fichero);
        
        if(!texto.exists()){
            texto.createNewFile();
        }else{
            System.out.println("Fichero creado");
        }
        
        try{
            FileOutputStream bos = new FileOutputStream(texto);
            
            DataOutputStream dos= new DataOutputStream(bos);
            
            dos.writeChars(cadea);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return texto;
    }
    
    
    public static void main(String[] args) throws IOException {
        
        Main miInstancia= new Main();
        
        miInstancia.escribirFichero();
        
        
        String fichero="/home/juagsa/NetBeansProjects/primitiveWriteChars/texto5.dat";
        
        
        FileInputStream fis = new FileInputStream(fichero);
        
        BufferedInputStream bis = new BufferedInputStream(fis);
        
        DataInputStream dis = new DataInputStream(bis);
        
        StringBuilder resultado = new StringBuilder(); // Clase para poder ver el texto no codificado.
       
        
        
        try{
            while(dis.available()>0){
            
            char caracter = dis.readChar();
            
            resultado.append(caracter);
            
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            dis.close();
        }
        
        System.out.println("Texto leído: "+ resultado.toString());

    }
}
       
        
        
        
        
    
    

