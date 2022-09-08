/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1.libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import proyectogrupo1.SqlCrud;
import proyectogrupo1.cliente.Cliente;

/**
 *
 * @author luism
 */
public class SqlCrudEjemplar implements SqlCrud<Ejemplar, String>{
    Connection connection;

    public SqlCrudEjemplar(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Ejemplar e) throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement(
                "INSERT INTO EJEMPLARES(IDEJEMPLAR,IDLIBRO,ESTADO) VALUES("
                        + "?,?,?);"
        );
        prepStat.setInt(1, e.getIdEjemplar());
        prepStat.setString(2, e.getLibro().getIdLibro());
        prepStat.setString(3, e.getEstadoEjemplar());
        prepStat.execute();
        prepStat.close();
    }

    @Override
    public List<Ejemplar> read(String lowerLimit, String upperLimit) throws SQLException {
        // TODO: Implementar
        PreparedStatement prepStat = connection.prepareStatement(
                "SELECT IDEJEMPLAR,IDLIBRO,ESTADO "+ 
                      //1        ,2        ,3
                "FROM EJEMPLARES "+
                "WHERE ? <= IDEJEMPLAR AND IDEJEMPLAR <= ?;"
        );
        prepStat.setString(1, lowerLimit);
        prepStat.setString(2, upperLimit);
        prepStat.execute();
        ResultSet rs = prepStat.getResultSet();
        
        LinkedList<Ejemplar> ejemplares = new LinkedList<>();
        while(rs.next()){
            ejemplares.add(readRow(rs));
        }
        prepStat.close();
        return ejemplares;
    }
    
    @Override
    public List<Ejemplar> read() throws SQLException {
                // TODO: Implementar
        PreparedStatement prepStat = connection.prepareStatement(
                "SELECT IDEJEMPLAR,IDLIBRO,ESTADO "+ 
                      //1        ,2        ,3
                "FROM EJEMPLARES;"
        );
        prepStat.execute();
        ResultSet rs = prepStat.getResultSet();
        
        LinkedList<Ejemplar> ejemplares = new LinkedList<>();
        while(rs.next()){
            ejemplares.add(readRow(rs));
        }
        prepStat.close();
        return ejemplares;
    }

    private Ejemplar readRow(ResultSet rs) throws SQLException{
        int idEjemplar = rs.getInt(1);
        Libro libro = new SqlCrudLibro(connection).read(rs.getString(2)).get(0);
        String estadoEjemplar = rs.getString(3);
        
        return new Ejemplar(idEjemplar, libro,estadoEjemplar);
    }
    
    @Override
    public void update(Ejemplar e) throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement(
                "UPDATE EJEMPLARES "
              + "SET "
              + "ESTADO =? "    // 1
              + "WHERE IDEJEMPLAR=?;" // 2
        );
        prepStat.setString(1, e.getEstadoEjemplar());
        prepStat.setInt(2, e.getIdEjemplar());
        
        prepStat.execute();
        prepStat.close();
    }

    @Override
    public void delete(Ejemplar e) throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement(
                "DELETE FROM EJEMPLARES "
              + "WHERE IDEJEMPLAR=?;"
        );
        
        prepStat.setInt(1, e.getIdEjemplar());
        
        prepStat.execute();
        prepStat.close();
    }

    
}
