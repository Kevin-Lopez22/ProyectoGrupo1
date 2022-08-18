/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;


import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author denni
 */
public class ConexionSQL {
    //trabajando con jre17
    
    public static Connection getConexion(){
        String conexionUrl = "jdbc:sqlserver://localhost:1433; "//puerto por defecto
                + "database = baseBilbioteca;"
                + "user = sa;"
                + "password = 12345;"//pilas la clave 
                + "loginTimeout = 40;"; //tiempo para la conexion 
        try{
            Connection con = DriverManager.getConnection(conexionUrl);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
            return con;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Conexion fallida: "+ex.toString());
            return null;
        }
        
        
    }
    
}
