/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1.prestamo;

import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import org.javatuples.Triplet;
import proyectogrupo1.SqlCrud;
import proyectogrupo1.cliente.Cliente;
import proyectogrupo1.cliente.SqlCrudClienteByID;
import proyectogrupo1.libro.Ejemplar;
import proyectogrupo1.libro.Libro;
import proyectogrupo1.libro.SqlCrudEjemplar;
import proyectogrupo1.libro.SqlCrudLibro;

/**
 *
 * @author luism
 */
public class SqlCrudPrestamoByFields implements SqlCrud<Prestamo, Triplet<String,String,Integer>>{
    private Connection connection;
    
    public SqlCrudPrestamoByFields(Connection connection) {
        this.connection = connection;
    }
    
    
    @Override
    public void create(Prestamo e) throws SQLException {
        SqlCrudPrestamoById.create(e,connection);
    }
    


    @Override
    public List<Prestamo> read(Triplet<String,String,Integer> lowerLimit, Triplet<String,String,Integer> upperLimit) throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement(
                "SELECT IDPRESTAMO,CODIGOCLIENTE,CODIGOLIBRO,CODEJEMPLAR,FECHAPRESTAMO,FECHAVENCIMIENTO,FECHADEVOLUCION "+ 
                      //1         ,2            ,3          ,4          ,5            ,6               ,7
                "FROM PRESTAMO "+
                "WHERE ? <= CODIGOCLIENTE AND CODIGOCLIENTE <= ? "+
                "AND   ? <= CODIGOLIBRO AND CODIGOLIBRO <= ? " +
                "AND   ? <= CODEJEMPLAR AND CODEJEMPLAR <= ?;"
        );
        prepStat.setString(1, lowerLimit.getValue0());
        prepStat.setString(2, upperLimit.getValue0());
        prepStat.setString(3, lowerLimit.getValue1());
        prepStat.setString(4, upperLimit.getValue1());
        prepStat.setInt(5, lowerLimit.getValue2());
        prepStat.setInt(6, upperLimit.getValue2());
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
        PreparedStatement prepStat = connection.prepareStatement(
                "SELECT IDPRESTAMO,CODIGOCLIENTE,CODIGOLIBRO,CODEJEMPLAR,FECHAPRESTAMO,FECHAVENCIMIENTO,FECHADEVOLUCION "+ 
                      //1         ,2            ,3          ,4          ,5            ,6               ,7
                "FROM PRESTAMO;"
        );
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
    public void update(Prestamo e) throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement(
                "UPDATE PRESTAMO " +
                "SET " +
                "FECHADEVOLUCION=? " +  // 1
                "WHERE CODIGOCLIENTE=? ;" + // 2
                "AND CODIGOLIBRO=?," + // 3
                "AND CODEJEMPLAR=?" // 4
        );
        prepStat.setDate(1, java.sql.Date.valueOf(SqlCrudPrestamoById.toLocalDate(e.getFechaDevolucion())));
        prepStat.setString(2, String.valueOf(e.getCliente().getIdCliente()));
        prepStat.setString(3, e.getLibro().getIdLibro());
        prepStat.setInt(4, e.getEjemplar().getIdEjemplar());
        
        prepStat.execute();
        prepStat.close();
    }

    @Override
    public void delete(Prestamo e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



       Prestamo readRow(ResultSet rs) throws SQLException{
        //IDPRESTAMO,CODIGOCLIENTE,CODIGOLIBRO,CODEJEMPLAR,FECHAPRESTAMO,FECHAVENCIMIENTO,FECHADEVOLUCION
        int idPrestamo = Integer.parseInt(rs.getString(1));
        Cliente cliente = new SqlCrudClienteByID(connection).read(rs.getString(2)).get(0);
        Libro libro = new SqlCrudLibro(connection).read(rs.getString(3)).get(0); // TODO: Implementar libro
        Ejemplar ejemplar = new SqlCrudEjemplar(connection).read(rs.getInt(4)).get(0); // TODO: Implementar ejemplar
        java.util.Date fechaGeneracion = rs.getDate(5);
        java.util.Date fechaVencimiento = rs.getDate(6);
        java.util.Date fechaDevolucion = rs.getDate(7);
        return new Prestamo(idPrestamo, cliente, libro, ejemplar, fechaGeneracion, fechaVencimiento, fechaDevolucion);
    }
    
}
