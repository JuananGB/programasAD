
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author juagsa
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Conexion conex = new Conexion();
        conex.conexion();
        //conex.insertFilas();
        //conex.actualizaFila();
        
        conex.verTabla();
    }
}

class Conexion {

    Scanner sc;
    Connection conn;

    public Connection conexion() {
        conn = null;
        try {
            // 1. CREAR CONEXIÓN
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "postgres";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    //1)
    public void insertFilas() throws SQLException {

        sc = new Scanner(System.in);

        System.out.println("Inserta el código a imprimir: ");
        String codigo = sc.nextLine();

        System.out.println("Inserte la descricion  a imprimir: ");
        String descricion = sc.nextLine();

        System.out.println("Inserta el precio a imprimir: ");
        int prezo = sc.nextInt();
        sc.nextLine();

        System.out.println("Inserta la data a imprimir: ");
        String datac = sc.nextLine();

        String sql = "INSERT INTO produtos(codigo,descricion,prezo,datac) VALUES(?,?,?,?)";

        PreparedStatement prepa = conn.prepareStatement(sql);

        prepa.setString(1, codigo);

        prepa.setString(2, descricion);

        prepa.setInt(3, prezo);

        prepa.setDate(4, Date.valueOf(datac));

        int filasInsertadas = prepa.executeUpdate();

        if (filasInsertadas > 0) {
            System.out.println("Inserción finalizada");
        } else {
            System.out.println("Error en la inserción");
        }

    }

    //2
    public void actualizaFila() throws SQLException {
        sc = new Scanner(System.in);

        System.out.println("Inserte el codigo del producto a buscar: ");
        String codigo = sc.nextLine();

        System.out.println("Inserte el nuevo valor del campo descricion: ");
        String descricion = sc.nextLine();

        System.out.println("Inserta el nuevo precio a modificar: ");
        int prezo = sc.nextInt();

        sc.nextLine();

        System.out.println("Inserte ls nueva data a modificar: ");

        String datac = sc.nextLine();

        String sql = "UPDATE produtos SET descricion=?, prezo=?,datac=? where codigo=?";

        PreparedStatement prepa = conn.prepareStatement(sql);

        prepa.setString(1, descricion);
        prepa.setInt(2, prezo);
        prepa.setDate(3, Date.valueOf(datac));
        prepa.setString(4, codigo);

        int filasActualizadas = prepa.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Actualización completada");
        }

    }

    //3
    public void verTabla() throws SQLException {

        Statement state = conn.createStatement();

        ResultSet result = state.executeQuery("SELECT * FROM produtos ");
        
        System.out.println("TABLA PRODUTOS");
        //System.out.println("");

        while (result.next()) {

            String codigo = result.getString("codigo");
            String descricion = result.getString("descricion");
            int prezo = result.getInt("prezo");
            String datac = result.getString("datac");
            System.out.println(codigo + " " + descricion + " " + prezo + " " + datac);
        }

    }

}
