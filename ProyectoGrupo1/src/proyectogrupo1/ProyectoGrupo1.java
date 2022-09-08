/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1;

import InterfazAlfa.JFMen;
import proyectogrupo1.Negocio.ConexionSQL;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author denni
 */
public class ProyectoGrupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // dennis chamba
        // 10 de agosto
        try{
            Statement sql = ConexionSQL.getConexion().createStatement();
            JFMen menu = new JFMen();
            
            menu.setVisible(true);
            String consulta = "Select * from baseBiblioteca.dbo.LIBRO";
          
            
            ResultSet resultado = sql.executeQuery(consulta);
            
            
            while(resultado.next()){
                System.out.println(resultado.getString(1));
            }
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    
}
