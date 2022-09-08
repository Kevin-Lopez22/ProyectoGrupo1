/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1.prestamo;

import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import org.javatuples.Triplet;
import proyectogrupo1.SqlCrud;

/**
 *
 * @author luism
 */
public class SqlCrudPrestamoByFields implements SqlCrud<Prestamo, Triplet<Integer,Integer,Integer>>{
    private Connection connection;
    
    public SqlCrudPrestamoByFields(Connection connection) {
        this.connection = connection;
    }
    
    
    @Override
    public void create(Prestamo e) throws SQLException {
        SqlCrudPrestamoById.create(e,connection);
    }
    


    @Override
    public List<Prestamo> read(Triplet<Integer, Integer, Integer> lowerLimit, Triplet<Integer, Integer, Integer> upperLimit) throws SQLException {
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

    @Override
    public List<Prestamo> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
