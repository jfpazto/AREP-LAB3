package co.edu.escuelaing.app.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.sql.DriverManager;
/**
 * Clase que se encarga de establecer una conexion con la base de datos.
 * @author  Jonathan Fabian Paez Torres
 * @version 1.0.
 */
public class ServidorDB {
	private static String host = "jdbc:postgresql://ec2-54-237-143-127.compute-1.amazonaws.com:5432/d5bpln02rqrvb0?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	private static String usuario = "giztfiqhagopqq";
    private static String contraseña = "2ea2b8a97e2206c059b1340f0fc5c33ebcef0b007e538409d4b43aa584131a9c";
    private static Connection connection = null;
    /**
     * Metodo que crea la conexion con la base de datos.
     */
    public ServidorDB() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(host, usuario, contraseña);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que a partir de un query retorna una lista con los datos de la base
     * @return Retorna ArrayList.
     */
    public ArrayList<String[]> consultaBase(){
        ArrayList<String[]> lista = new ArrayList<>();
        String consulta = "SELECT * FROM Usuario;";
        try {

            Statement statement = connection.createStatement();
            ResultSet query =statement.executeQuery(consulta);
            while(query.next()){
                String nombre = query.getString("Nombre");
                String telefono = query.getString("Telefono");
                String email = query.getString("email");
                String ciudad = query.getString("ciudad");
                String[] tmp = {nombre,telefono,email,ciudad};
                lista.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}