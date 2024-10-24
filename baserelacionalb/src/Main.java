
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author juagsa
 */
public class Main {

    public static void main(String[] args) {
        Conexion conex = new Conexion();

        conex.conexion(); // conexión a postgres

        conex.listarFilas(); // listamos el contenido de la tabla produtos

        //conex.actualizaPrecio(); //Actualizamos el precio del producto p1
        
        //conex.insertarNuevaTabla(); // Insertamos un nuevo producto
        
        //conex.borrarFila(); //Borrar el producto con codigo="p3"
        
    }

}

class Conexion {

    Connection conn;
    Statement state;
    ResultSet result;
    Scanner sc;

    public Connection conexion() {
        conn = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "postgres";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("No se ha podido conectar a postgresql.");
            e.printStackTrace();
        }

        return conn;
    }

    public void listarFilas() {

        try {
            //Garantiza que el REsultSet sea deeplazable y actualizable
            state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            result = state.executeQuery("SELECT * FROM produtos");

            while (result.next()) { //iteramos desde la primera fila hasta la última
                String codigo = result.getString("codigo");
                String descricion = result.getString("descricion");
                int prezo = result.getInt("prezo");
                Date datac = result.getDate("datac");

                System.out.println(codigo + " " + descricion + " " + prezo + " " + datac);

            }

            state.close();
            result.close();

        } catch (Exception e) {
            System.out.println("Error en visualizar las filas");
            e.printStackTrace();
        }

    }

    public void actualizaPrecio() {

        try {
            state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            result = state.executeQuery("SELECT * FROM produtos");

            if (result.first()) {
                result.absolute(1); //Nos posicionamos en la primera fila
                result.updateInt("prezo", 8); //Modificamos el precio 
                result.updateRow(); // Actualizamos

                System.out.println("Precio actualizado");
            } else {
                System.out.println("No se pudo actualizar el precio");
            }

            state.close();
            result.close();

        } catch (Exception e) {
            System.out.println("Campo precio imposible de modificar");
            e.printStackTrace();
        }

    }

    public void insertarNuevaTabla() {
        try {
            state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            result = state.executeQuery("SELECT * FROM produtos");

            Date nuevaFecha = Date.valueOf("2020-08-21");  // Convertimos la cadena de fecha a java.sql.Date

            result.moveToInsertRow(); // Nos posicionamos en la fila para la inserción
            //Establecemos los nuevos valores oara la nueva fila
            result.updateString("codigo", "p4");
            result.updateString("descricion", "mochila");
            result.updateInt("prezo", 10);
            result.updateDate("datac", nuevaFecha);
            result.insertRow(); //Insetamos la nueva fila en la base de datos
            result.moveToCurrentRow();

            System.out.println("Inserción completada");

        } catch (Exception e) {
            System.out.println("Campo imposible de insertar en la tabla");
            e.printStackTrace();
        }

    }

    public void borrarFila() {
        try {
            state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            result = state.executeQuery("SELECT * FROM produtos");

            if (result.first()) {
                result.absolute(2);
                result.deleteRow();
                
                System.out.println("Borrado completado");
            } else {
                System.out.println("Borrado fallido");
            }
            
           state.close();
           result.close();
          
        } catch (Exception e) {
            System.out.println("No se ha podido borrar el campo");
        }
        
    }

}
