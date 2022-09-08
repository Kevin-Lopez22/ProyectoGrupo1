/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1.prestamo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import proyectogrupo1.SQLIndex;
import static proyectogrupo1.SQLIndex.TABLE_NAME;
import proyectogrupo1.cliente.Cliente;
/**
 *
 * @author denni
 */
public class Prestamo {
    public static SQLIndexIdPrestamo sQLIndexIdPrestamo;
    private final int idPrestamo;
    private final Cliente cliente;
    private final Object libro;
    private final Object ejemplar;
    private final Date fechaGeneracion;
    private final Date fechaVencimiento;
    private Date fechaDevolucion;
    

    public Prestamo(int idPrestamo, Cliente cliente, Object libro, Object ejemplar, Date fechaGeneracion, Date fechaVencimiento, Date fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.cliente = cliente;
        this.libro = libro;
        this.ejemplar = ejemplar;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public Prestamo(int idPrestamo, Cliente cliente, Object libro, Object ejemplar, Date fechaGeneracion, Date fechaVencimiento) {
        this(idPrestamo,cliente,libro,ejemplar,fechaGeneracion,fechaVencimiento,null);
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Object getLibro() {
        return libro;
    }

    public Object getEjemplar() {
        return ejemplar;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    
    
    public static class SQLIndexIdPrestamo implements SQLIndex<Integer>{
        final static String INDEX_NAME = "idPrestamo";
        Connection connection;

        
        public SQLIndexIdPrestamo(Connection connection) {
            this.connection = connection;
        }

        @Override
        public Integer peek() throws SQLException {
            PreparedStatement prepStat = connection.prepareStatement("SELECT lastIdx FROM "+TABLE_NAME+" WHERE nombre='"+INDEX_NAME+"'");
            prepStat.execute();
            ResultSet rs = prepStat.getResultSet();
            rs.next();
            String result = rs.getString(1);
            prepStat.close();
            return Integer.valueOf(result);
        }

        

        @Override
        public void increment() throws SQLException {
            PreparedStatement prepStat = connection.prepareStatement("UPDATE "+TABLE_NAME+" SET lastIdx=lastIdx+1 WHERE nombre='"+INDEX_NAME+"'");
            prepStat.execute();
            prepStat.close();
        }

        @Override
        public void decrement() throws SQLException {
            PreparedStatement prepStat = connection.prepareStatement("UPDATE "+TABLE_NAME+" SET lastIdx=lastIdx-1 WHERE nombre='"+INDEX_NAME+"'");
            prepStat.execute();
            prepStat.close();
        }
        
        public void close() throws SQLException {
            connection.close();
        }
    }
}
