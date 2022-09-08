/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1.prestamo;

import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import proyectogrupo1.SqlCrud;
import proyectogrupo1.cliente.Cliente;
import proyectogrupo1.cliente.SqlCrudClienteByID;

/**
 *
 * @author luism
 */
public class SqlCrudPrestamoById implements SqlCrud<Prestamo, Integer>{
    private Connection connection;
    
    public SqlCrudPrestamoById(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Prestamo e) throws SQLException {
        SqlCrudPrestamoById.create(e,connection);
    }

    @Override
    public List<Prestamo> read(Integer lowerLimit, Integer upperLimit) throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement(
                "SELECT IDPRESTAMO,CODIGOCLIENTE,CODIGOLIBRO,CODEJEMPLAR,FECHAPRESTAMO,FECHAVENCIMIENTO,FECHADEVOLUCION "+ 
                      //1         ,2            ,3          ,4          ,5            ,6               ,7
                "FROM PRESTAMO "+
                "WHERE ? <= IDPRESTAMO AND IDPRESTAMO <= ?;"
        );
        prepStat.setString(1, String.valueOf(lowerLimit));
        prepStat.setString(2, String.valueOf(upperLimit));
        prepStat.execute();
        ResultSet rs = prepStat.getResultSet();
        
        LinkedList<Prestamo> prestamos = new LinkedList<>();
        while(rs.next()){
            prestamos.add(readRow(rs));
        }
        prepStat.close();
        return prestamos;
    }

        @Override
    public List<Prestamo> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void update(Prestamo e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Prestamo e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    static void create(Prestamo e, Connection connection) throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement(
                "INSERT INTO PRESTAMO(IDPRESTAMO,CODIGOCLIENTE,CODIGOLIBRO,CODEJEMPLAR,FECHAPRESTAMO,FECHAVENCIMIENTO,FECHADEVOLUCION) VALUES("
                        + "?,?,?,?,?,?,?,?);"
        );
        prepStat.setString(1, String.valueOf(e.getIdPrestamo()));
        prepStat.setString(2,  String.valueOf(e.getCliente().getIdCliente()));
        prepStat.setString(3, e.getLibro().toString()); // TODO: Codigo libro
        prepStat.setInt(4, e.getEjemplar().hashCode()); // TODO: Codigo ejemplar
        prepStat.setDate(5, java.sql.Date.valueOf(toLocalDate(e.getFechaGeneracion())));
        prepStat.setDate(6, java.sql.Date.valueOf(toLocalDate(e.getFechaVencimiento())));
        prepStat.setDate(7, java.sql.Date.valueOf(toLocalDate(e.getFechaDevolucion())));
        prepStat.execute();
        prepStat.close();
    }
    
    private static LocalDate toLocalDate(java.util.Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    private Prestamo readRow(ResultSet rs) throws SQLException{
        //IDPRESTAMO,CODIGOCLIENTE,CODIGOLIBRO,CODEJEMPLAR,FECHAPRESTAMO,FECHAVENCIMIENTO,FECHADEVOLUCION
        int idPrestamo = Integer.parseInt(rs.getString(1));
        Cliente cliente = new SqlCrudClienteByID(connection).read(rs.getString(2)).get(0);
        Object libro = null; // TODO: Implementar libro
        Object ejemplar = null; // TODO: Implementar ejemplar
        java.util.Date fechaGeneracion = rs.getDate(5);
        java.util.Date fechaVencimiento = rs.getDate(6);
        java.util.Date fechaDevolucion = rs.getDate(7);
        return new Prestamo(0, cliente, rs, rs, fechaGeneracion, fechaVencimiento, fechaDevolucion);
    }


}
