/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author denni
 */
public class Prestamo {


    public Prestamo() {

    }

    public void RegistrarPrestamo(String cliente, String libro, String ejemplar, LocalDate fPrestamo, LocalDate fFin) {
        try {
            Statement sql = ConexionSQL.getConexion().createStatement();

            String consulta = "Insert into baseBiblioteca.dbo.PRESTAMO values('" + cliente + "',"
                    + "'" + libro + "','" + ejemplar + "','" + fPrestamo + "','" + fFin + "')";
            sql.executeUpdate(consulta);

            //cambio de estado del libro
            consulta = "update baseBiblioteca.dbo.ejemplares set estado = 'prestado' where IDEjemplar = '" + ejemplar + "'";
            sql.executeUpdate(consulta);

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
