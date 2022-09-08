/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1.prestamo;

/**
 *
 * @author denni
 */
import com.sun.jdi.connect.spi.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import proyectogrupo1.ConexionSQL;


public class ProyectoGrupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // dennis chamba
        // 10 de agosto....
        
        PrestamoGUI d = new PrestamoGUI("1725661183","1","2");
        d.show();
        
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        //System.out.println(dtf.format(LocalDateTime.now()));
        
        //Date fecha = new Date(dtf.format(LocalDateTime.now()));
        
        //System.out.println(fecha);
        try{
            Statement sql = ConexionSQL.getConexion().createStatement();
            
            //String consulta = "Select count(*) from baseBiblioteca.dbo.CLIENTES where cicliente = '1725661183' ";
            String consulta = "Select * from baseBiblioteca.dbo.LIBRO where titulo = 'luna de pluton'";

            ResultSet resultado = sql.executeQuery(consulta);
            resultado.next();
            System.out.println(resultado.getString("autor"));
            /*
            while(resultado.next()){
                System.out.println(resultado.getString(1));
            }*/
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }        
        
    }
    
}
