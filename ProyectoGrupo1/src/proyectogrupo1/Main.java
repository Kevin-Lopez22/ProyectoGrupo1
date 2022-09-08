/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import javax.swing.JFrame;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectogrupo1.cliente.Cliente;
import proyectogrupo1.libro.Ejemplar;
import proyectogrupo1.libro.Libro;
import proyectogrupo1.libro.SqlCrudEjemplar;
import proyectogrupo1.libro.SqlCrudLibro;
import proyectogrupo1.prestamo.*;

/**
 *
 * @author luism
 */
public class Main {
    public static void main(String[] args) {
        // Init Indices
        Connection c = ConexionSQL.getConexion();
        Cliente.sQLIndexIdCliente = new Cliente.SQLIndexIdCliente(c);
        Prestamo.sQLIndexIdPrestamo = new Prestamo.SQLIndexIdPrestamo(c);
        Libro.sQLIndexIdLibro = new Libro.SQLIndexIdLibro(c);
        // Make visible and start
        Libro l1 = new Libro("101", "El primero", "XXXXX", "Marcelo", 1000, 200);
        if(false){
            try {
                SqlCrudLibro sqlCrudLibro = new SqlCrudLibro(c);
                for(Libro l: sqlCrudLibro.read())sqlCrudLibro.delete(l);
                sqlCrudLibro.create(l1);
                sqlCrudLibro.create(new Libro("102", "El segundo", "XXXXX", "Marcelo", 1000, 200));
                sqlCrudLibro.create(new Libro("103", "El tercero", "XXXXX", "Marcelo", 1000, 200));
                System.out.println(sqlCrudLibro.read());
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(true){
            try {
                SqlCrudEjemplar sqlCrudEjemplar = new SqlCrudEjemplar(c);
                for(Ejemplar l: sqlCrudEjemplar.read())sqlCrudEjemplar.delete(l);
                sqlCrudEjemplar.create(new Ejemplar(0, l1));
                sqlCrudEjemplar.create(new Ejemplar(1, l1));
                sqlCrudEjemplar.create(new Ejemplar(2, l1));
                System.out.println(sqlCrudEjemplar.read());
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(true){
            InterfazPrestamos pgui = new InterfazPrestamos();
            pgui.setVisible(true);
        }
    }
}
