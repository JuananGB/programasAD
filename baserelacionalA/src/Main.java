
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Conexion conex = new Conexion();

        conex.conexion(); //Conectarse a la base de datos

       //conex.insereproducto(); // Inserción de datos;
        conex.listaproducto(); //Listar productos
       // conex.listaproductoCodigo(); //Listar produtos por código
       //conex.actualizaPre(); //Modificar el precio donde indiquemos el código
       
       //conex.eliminaProducto(); //Borrar producto indicando el código a buscar

    }
}

class Conexion {

    Connection conn;

    Scanner sc;

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

    public void insereproducto() throws SQLException {

        sc = new Scanner(System.in);

        try {

            // Insertar los valores
            System.out.println("Inserta el código: ");
            String codigo = sc.nextLine();
            System.out.println("Inserta la descripción: ");
            String descricion = sc.nextLine();
            System.out.println("Inserta el precio: ");
            int prezo = sc.nextInt();
            sc.nextLine();  // Limpiar el buffer
            System.out.println("Inserta la fecha (AAAA-MM-DD): "); // AAAA=año ; MM=Mes; DD=dia
            String datac = sc.nextLine();

            // 3. CREAR CONSULTA PREPARADA
            String sql = "INSERT INTO produtos (codigo, descricion, prezo, datac) VALUES (?, ?, ?, ?)";
            PreparedStatement prepa = conn.prepareStatement(sql);
            prepa.setString(1, codigo);
            prepa.setString(2, descricion);
            prepa.setInt(3, prezo);
            prepa.setDate(4, Date.valueOf(datac));

            // 4. EJECUTAR CONSULTA DE INSERCIÓN
            int filasInsertadas = prepa.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Campo insertado correctamente");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void listaproducto() throws SQLException {

        try {
            Statement state = conn.createStatement();

            ResultSet result = state.executeQuery("SELECT * FROM produtos");

            while (result.next()) {

                String codigo = result.getString("codigo");
                String descricion = result.getString("descricion");
                int prezo = result.getInt("prezo");
                String datac = result.getString("datac");
                System.out.println(codigo + " " + descricion + " " + prezo + " " + datac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listaproductoCodigo() throws SQLException {
        sc=new Scanner(System.in);
        try {
            System.out.println("Inserte el código del producto: ");
            String codigo = sc.nextLine();
            PreparedStatement prepa = conn.prepareStatement("SELECT * FROM produtos WHERE codigo=?");
            prepa.setString(1, codigo);

            ResultSet result = prepa.executeQuery();

            while (result.next()) {

                codigo = result.getString("codigo");
                String descricion = result.getString("descricion");
                int prezo = result.getInt("prezo");
                String datac = result.getString("datac");

                System.out.println(codigo + " " + descricion + " " + prezo + " " + datac);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void actualizaPre() throws SQLException{
        sc=new Scanner(System.in);
        System.out.println("Inserte el código a buscar: ");
        String codigo=sc.nextLine();
       
        System.out.println("Inserte el nuevo precio: ");
        int prezo=sc.nextInt();
        PreparedStatement prepa=conn.prepareStatement("UPDATE produtos SET prezo=? where codigo=?");
        prepa.setInt(1, prezo);
        prepa.setString(2, codigo);
        
        int filasActualizadas=prepa.executeUpdate(); 
        
        if (filasActualizadas > 0) {
            System.out.println("El producto con código " + codigo + " fue actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún producto con el código " + codigo + ".");
        }
        
    }
    
    public void eliminaProducto() throws SQLException{
        sc=new Scanner(System.in);
        
        System.out.println("Índique el código del producto a borrar: ");
        String codigo=sc.nextLine();
        PreparedStatement prepa=conn.prepareStatement("DELETE FROM produtos WHERE codigo=?");
        prepa.setString(1, codigo);
        
        int filasBorradas=prepa.executeUpdate();
        
        if(filasBorradas>0){
            System.out.println("EL producto con código: "+codigo+" a sido borrado correctamente");
        }else{
            System.out.println("Código no encontrado");
        }
    }
}
