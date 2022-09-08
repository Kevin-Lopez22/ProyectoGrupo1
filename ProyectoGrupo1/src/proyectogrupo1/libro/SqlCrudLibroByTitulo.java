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
public class SqlCrudLibroByTitulo implements SqlCrud<Libro,String>{
    Connection connection;

    public SqlCrudLibroByTitulo(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Libro e) throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement(
                "INSERT INTO LIBRO(IDLIBRO,TITULO,ISBN,AUTOR,STOCK,PAGINAS) VALUES("
                        + "?,?,?,?,?,?);"
        );
        prepStat.setString(1, e.getIdLibro());
        prepStat.setString(2, e.getTitulo());
        prepStat.setString(3, e.getISBN());
        prepStat.setString(4, e.getAutor());
        prepStat.setInt(5, e.getStock());
        prepStat.setInt(6, e.getPaginas());
        prepStat.execute();
        prepStat.close();
    }

    @Override
    public List<Libro> read(String lowerLimit, String upperLimit) throws SQLException {
                // TODO: Implementar
        PreparedStatement prepStat = connection.prepareStatement(
                "SELECT IDLIBRO,TITULO,ISBN,AUTOR,STOCK,PAGINAS "+ 
                      //1      ,2     ,3   ,4    ,5    ,6
                "FROM LIBRO "+
                "WHERE ? <= TITULO AND TITULO <= ?;"
        );
        prepStat.setString(1, lowerLimit);
        prepStat.setString(2, upperLimit);
        prepStat.execute();
        ResultSet rs = prepStat.getResultSet();
        
        LinkedList<Libro> libros = new LinkedList<>();
        while(rs.next()){
            libros.add(readRow(rs));
        }
        prepStat.close();
        return libros;
    }
    
        @Override
    public List<Libro> read() throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement(
                "SELECT IDLIBRO,TITULO,ISBN,AUTOR,STOCK,PAGINAS "+ 
                      //1      ,2     ,3   ,4    ,5    ,6
                "FROM LIBRO;"
        );
        prepStat.execute();
        ResultSet rs = prepStat.getResultSet();
        
        LinkedList<Libro> libros = new LinkedList<>();
        while(rs.next()){
            libros.add(readRow(rs));
        }
        prepStat.close();
        return libros;
    }
    
    private Libro readRow(ResultSet rs) throws SQLException{
        String idLibro = rs.getString(1).trim();
        String titulo = rs.getString(2).trim();
        String isbn = rs.getString(3).trim();
        String autor = rs.getString(4).trim();
        int stock = rs.getInt(5);
        int paginas = rs.getInt(6);
        
        return new Libro(idLibro, titulo, isbn, autor, stock, paginas);
    }

    @Override
    public void update(Libro e) throws SQLException {
        throw new SQLException("Operacion insegura");
    }

    @Override
    public void delete(Libro e) throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement(
                "DELETE FROM LIBRO "
              + "WHERE TITULO=?;"
        );
        
        prepStat.setString(1, e.getIdLibro());
        
        prepStat.execute();
        prepStat.close();
    }


    
}
