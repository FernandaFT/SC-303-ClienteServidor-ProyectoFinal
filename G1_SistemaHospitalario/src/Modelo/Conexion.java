
package Modelo;

import java.sql.*;

/**
 *
 * @author fernandafajardo
 */
public class Conexion {
    
    Connection con = null;
    String db = "registro_usuario";
    String url = "jdbc:mysql://localhost:3306/" + db;
    String usuario = "root";
    String password = "";
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario,password);
        }catch(ClassNotFoundException | SQLException e){
            System.err.println();
        }
        return con;
    }
}
