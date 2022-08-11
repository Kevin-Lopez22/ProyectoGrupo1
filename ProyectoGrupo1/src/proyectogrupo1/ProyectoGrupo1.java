/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1;

/**
 *
 * @author denni
 */
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProyectoGrupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // dennis chamba
        // 10 de agosto
        try{
            Statement sql = ConexionSQL.getConexion().createStatement();
            
            String consulta = "Select * from baseBiblioteca.dbo.BIBLIOTECARIOS";
            
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                System.out.println(resultado.getString(1));
            }
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }        
        
    }
    
}
