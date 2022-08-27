/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author denni
 */
public class ProyectoGrupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // LuisM45
            SqlCrud<Cliente,Integer> sqlCrudCliente = new SqlCrudCliente(ConexionSQL.getConexion());
            
            Cliente a,b;
            a = new Cliente(1, "2", "3-nombre", "4-apellido", "5", "6-direcc", "7-correo");
            b = new Cliente(2, "3", "3-nombre", "4-apellido", "5", "6-direcc", "7-correo");
            System.out.println(sqlCrudCliente.read((int)0, (int)9999));
            
            sqlCrudCliente.create(a); //create
            sqlCrudCliente.create(b);
            System.out.println(sqlCrudCliente.read((int)0, (int)9999));
            
            sqlCrudCliente.delete(a);
            System.out.println(sqlCrudCliente.read((int)0, (int)9999));
            
            b.setNombre("nuevo");
            sqlCrudCliente.update(b);
            System.out.println(sqlCrudCliente.read((int)0, (int)9999));
            
            sqlCrudCliente.delete(b);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoGrupo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
}
