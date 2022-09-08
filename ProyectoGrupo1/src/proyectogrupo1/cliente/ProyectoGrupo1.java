/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1.cliente;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectogrupo1.ConexionSQL;

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
            
            SqlCrudCliente sqlCrudCliente = new SqlCrudCliente(ConexionSQL.getConexion());
//            for(Cliente c: sqlCrudCliente.read("0", "999999999"))
//                sqlCrudCliente.delete(c);
            
            // Preparacion de los Objetos cliente
            Cliente a, b;
            a = new Cliente(1, "2", "3-nombre", "4-apellido", "5", "6-direccion", "7-correo");
            b = new Cliente(2, "3", "3-nombre", "4-apellido", "5", "6-direccion", "7-correo");
            System.out.println(sqlCrudCliente.read("0", "999999999"));                      // Lectura en la DB (Ejemplo de READ)

            // Ejemplo Create/Insercion
            sqlCrudCliente.create(a);
            sqlCrudCliente.create(b);
            System.out.println(sqlCrudCliente.read("0", "999999999")); // Lectura en la DB

            // Ejemplo Delete/Eliminar
            sqlCrudCliente.delete(a);
            System.out.println(sqlCrudCliente.read("0", "999999999")); // Lectura en la DB

            // Ejemplo Update excepto la cedul
            b.setNombre("nuevo");
            sqlCrudCliente.update(b);
            System.out.println(sqlCrudCliente.read("0", "999999999")); // Lectura en la DB

            // Limpieza de la DB
            sqlCrudCliente.delete(b);

            //Ejemplos útiles
            //con rango
            sqlCrudCliente.read("0", "999999999"); // Lee los clientes con CI 0 < ci < 999999999
            sqlCrudCliente.read("4", "4"); // Lee los clientes con CI ci = 4

            //Creación del GUIGestorCliente
            GUIGestorCliente gUIGestorCliente = new GUIGestorCliente(new SqlCrudCliente(ConexionSQL.getConexion()));
            gUIGestorCliente.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoGrupo1.class.getName()).log(Level.SEVERE, null, ex);
        }

}

}
