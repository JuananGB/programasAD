
import java.io.Serializable;

/**
 *
 * @author juagsa
 */
public class mclase implements Serializable {

    private String nome;

    //private int numero1;
    
    private transient int numero1;

    private double numero2;
    
    
    public mclase(){
        
    }

    public mclase(String nome, int numero1, double numero2) {
        this.nome = nome;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero1() {
        return numero1;
    }

    public double getNumero2() {
        return numero2;
    }
    
     @Override
    public String toString() {
        return "s=" + nome + "; i=" + numero1 + "; d=" + numero2;
    }

}
