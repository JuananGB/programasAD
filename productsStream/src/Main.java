
import java.io.*;

/**
 
 * @author juagsa
 */
public class Main {
    public static void main(String[] args)  {
        
        
        System.out.println("Lista de productos guardados en el archivo products.txt");
        
        
        //1)crear un  obxecto da clase Product  cos argumentos: "cod1", "parafusos", 3.0 
        
        Product p1=new Product("cod1", "parafusos", 3.0 );
        
        /*2)gardar os valores do producto creado   nun ficheiro denominado produtos.txt mediante 
            os metodos adecuados de  DataOutputStream (amosados ao final deste texto)
        */
        
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("products.txt",true))){
            
            dos.writeUTF(p1.getCodigo());
            
            dos.writeUTF(p1.getDescricion());
            
            dos.writeDouble(p1.getPrezo());
          
        }catch(IOException e){
            e.printStackTrace();
        }
        
        /*
        3) crear outro  obxecto da clase Product  cos argumentos: "cod2","cravos",4.0 e gardalo como anterormente
        */
        
        Product p2=new Product("cod2","cravos",4.0);
        
         try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("products.txt",true))){
            
            dos.writeUTF(p2.getCodigo());
            
            dos.writeUTF(p2.getDescricion());
            
            dos.writeDouble(p2.getPrezo());
          
        }catch(IOException e){
            e.printStackTrace();
        }
         
        
       /*
         4) crear outro  obxecto da clase Product  cos argumentos: "cod3","tachas",6.0 e gardalo como anterormente
        */
       
        Product p3=new Product("cod3","tachas",6.0);
        
         try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("products.txt",true))){
            
            dos.writeUTF(p3.getCodigo());
             
            dos.writeUTF(p3.getDescricion());
            
            dos.writeDouble(p3.getPrezo());
          
        }catch(IOException e){
            e.printStackTrace();
        }
         
         /*
         5) crear outro  obxecto da clase Product  cos argumentos: "cod4","grapas",2.0 e gardalo como anterormente
         */
         
         Product p4=new Product("cod4","grapas",2.0);
        
         try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("products.txt",true))){
            
            dos.writeUTF(p4.getCodigo());
            
            dos.writeUTF(p4.getDescricion());
            
            dos.writeDouble(p4.getPrezo());
          
        }catch(IOException e){
            e.printStackTrace();
        }
         
        //6) gardar os valores do producto creado no ficheiro produtos.txt
        
        try(DataInputStream dis=new DataInputStream(new FileInputStream("products.txt"))){
            
           while (dis.available() > 0) {
                /*
                System.out.println("Codigo: " + dis.readUTF());
                System.out.println("Descripcion: " + dis.readUTF());
                System.out.println("Prezo: " + dis.readDouble());
                */
                
                System.out.println("Código: "+dis.readUTF()+",Descripción: "+dis.readUTF()+",Prezo: "+dis.readDouble());
                
                
            }
           
          
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
       Product po3=new Product(); 
        
        
        
       
        
    }
}
