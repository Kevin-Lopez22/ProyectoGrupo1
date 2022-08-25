package proyectogrupo1;
import java.sql.*;
import java.util.*;

final class SqlCrudCliente implements SqlCrud<Cliente,Long>{

    Connection connection;

    public SqlCrudCliente(Connection connection) {
        this.connection = connection;
    }
    
    
    @Override
    public void create(Cliente e) throws SQLException{
        // TODO: Implementar
        PreparedStatement prepStat = connection.prepareStatement(
                "INSERT INTO CLIENTES(IDCLIENTE,CICLIENTE,NOMBRECLIENTE,APELLIDOCLIENTE,DIRECCION,TELEFONO,CORREO) VALUES("
                        + "?,?,?,?,?,?,?);"
        );
        prepStat.setString(0, String.valueOf(e.getIdCliente()));
        prepStat.setString(1, String.valueOf(e.getCedula()));
        prepStat.setString(2, e.getNombre());
        prepStat.setString(3, e.getApellido());
        prepStat.setString(4, e.getDireccion());
        prepStat.setString(5, String.valueOf(e.getTelefono()));
        prepStat.setString(6, e.getCorreo());
        prepStat.execute();
    }

    @Override
    public List<Cliente> read(Long lowerLimit, Long upperLimit) throws SQLException{
        // TODO: Implementar
        PreparedStatement prepStat = connection.prepareStatement(
                "SELECT IDCLIENTE,CICLIENTE,NOMBRECLIENTE,APELLIDOCLIENTE,DIRECCION,TELEFONO,CORREO "+ 
                "FROM CLIENTES "+
                "WHERE ? <= CICLIENTE AND CICLIENTE <= ?;"
        );
        prepStat.setString(0, String.valueOf(lowerLimit));
        prepStat.setString(1, String.valueOf(upperLimit));
        prepStat.execute();
        ResultSet rs = prepStat.getResultSet();
        
        LinkedList<Cliente> clientes = new LinkedList<>();
        while(rs.next()){
            clientes.add(readRow(rs));
        }
        return clientes;
    }

    private Cliente readRow(ResultSet rs) throws SQLException{
        int idCliente = Integer.parseInt(rs.getString(1));
        String cedula = rs.getString(2);
        String nombre = rs.getString(3);
        String apellido = rs.getString(4);
        long telefono = Long.parseLong(rs.getString(5));
        String direccion = rs.getString(6);
        String correo = rs.getString(7);
        
        return new Cliente(idCliente,cedula,nombre,apellido,telefono,direccion,correo);
    }
    
    @Override
    public void update(Cliente e) throws SQLException{
        // TODO: Implementar
        PreparedStatement prepStat = connection.prepareStatement(
                "UPDATE CLIENTES "
              + "SET "
              + "NOMBRECLIENTE = ?,"    // 1
              + "APELLIDOCLIENTE = ?,"  // 2
              + "DIRECCION = ?,"        // 3
              + "TELEFONO = ?,"         // 4
              + "CORREO = ? "           // 5
              + "WHERE CICLIENTE == ?;" // 6
        );
        prepStat.setString(1, e.getNombre());
        prepStat.setString(2, e.getApellido());
        prepStat.setString(3, e.getDireccion());
        prepStat.setString(4, String.valueOf(e.getTelefono()));
        prepStat.setString(5, e.getCorreo());
        prepStat.setString(6, String.valueOf(e.getIdCliente()));
        
        prepStat.execute();
    }

    @Override
    public void delete(Cliente e) throws SQLException{
        PreparedStatement prepStat = connection.prepareStatement(
                "DELETE FROM CLIENTE "
              + "WHERE CICLIENTE == ?;"
        );
        
        prepStat.setString(1, String.valueOf(e.getIdCliente()));
        
        prepStat.execute();
    }
    
    public void close() throws SQLException{
        connection.close();
    }
}

