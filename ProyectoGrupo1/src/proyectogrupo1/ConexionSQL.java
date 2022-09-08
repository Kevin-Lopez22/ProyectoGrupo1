package proyectogrupo1;


import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionSQL {
    //trabajando con jre17
    
    public static Connection getConexion(){
        String conexionUrl = "jdbc:sqlserver://192.168.191.2:1433; "//puerto por defecto
                + "database = baseBibliotecaAux;"
                + "user = sa;"
                + "password = dXXTOR66;"//pilas la clave // "I only cannot see this going well"
                + "loginTimeout = 40;"; //tiempo para la conexion 
        try{
            Connection con = DriverManager.getConnection(conexionUrl);
            return con;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Conexion fallida: "+ex.toString());
                return null;
        }
        
        
    }
    
}
