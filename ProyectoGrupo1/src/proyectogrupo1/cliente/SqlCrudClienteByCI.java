package proyectogrupo1.cliente;
import java.sql.*;
import java.util.*;
import proyectogrupo1.SqlCrud;

final public class SqlCrudClienteByCI implements SqlCrud<Cliente,String>{

    Connection connection;

    public SqlCrudClienteByCI(Connection connection) {
        this.connection = connection;
    }
    
    
    @Override
    public void create(Cliente e) throws SQLException{
        // TODO: Implementar
        PreparedStatement prepStat = connection.prepareStatement(
                "INSERT INTO CLIENTES(IDCLIENTE,CICLIENTE,NOMBRECLIENTE,APELLIDOCLIENTE,DIRECCION,TELEFONO,CORREO,SUSPENDIDO) VALUES("
                        + "?,?,?,?,?,?,?,?);"
        );
        prepStat.setString(1, String.valueOf(e.getIdCliente()));
        prepStat.setString(2, e.getCedula());
        prepStat.setString(3, e.getNombre());
        prepStat.setString(4, e.getApellido());
        prepStat.setString(5, e.getDireccion());
        prepStat.setString(6, e.getTelefono());
        prepStat.setString(7, e.getCorreo());
        prepStat.setBoolean(8, e.isSuspendido());
        prepStat.execute();
        prepStat.close();

    }

    @Override
    public List<Cliente> read(String lowerLimit, String upperLimit) throws SQLException{
        // TODO: Implementar
        PreparedStatement prepStat = connection.prepareStatement(
                "SELECT IDCLIENTE,CICLIENTE,NOMBRECLIENTE,APELLIDOCLIENTE,DIRECCION,TELEFONO,CORREO,SUSPENDIDO "+ 
                      //1        ,2        ,3            ,4              ,5        ,6       ,7     ,8
                "FROM CLIENTES "+
                "WHERE ? <= CICLIENTE AND CICLIENTE <= ?;"
        );
        prepStat.setString(1, lowerLimit);
        prepStat.setString(2, upperLimit);
        prepStat.execute();
        ResultSet rs = prepStat.getResultSet();
        
        LinkedList<Cliente> clientes = new LinkedList<>();
        while(rs.next()){
            clientes.add(readRow(rs));
        }
        prepStat.close();
        return clientes;
    }

    public List<Cliente> read() throws SQLException{
        // TODO: Implementar
        PreparedStatement prepStat = connection.prepareStatement(
                "SELECT IDCLIENTE,CICLIENTE,NOMBRECLIENTE,APELLIDOCLIENTE,DIRECCION,TELEFONO,CORREO,SUSPENDIDO "+ 
                      //1        ,2        ,3            ,4              ,5        ,6       ,7     ,8
                "FROM CLIENTES;"
        );
        prepStat.execute();
        ResultSet rs = prepStat.getResultSet();
        
        LinkedList<Cliente> clientes = new LinkedList<>();
        while(rs.next()){
            clientes.add(readRow(rs));
        }
        prepStat.close();
        return clientes;
    }
    
    private Cliente readRow(ResultSet rs) throws SQLException{
        int idCliente = Integer.parseInt(rs.getString(1).trim());
        String cedula = rs.getString(2).trim();
        String nombre = rs.getString(3).trim();
        String apellido = rs.getString(4).trim();
        String direccion = rs.getString(5).trim();
        String telefono = rs.getString(6).trim();
        String correo = rs.getString(7).trim();
        boolean isSuspendido = rs.getBoolean(8);
        
        return new Cliente(idCliente,cedula,nombre,apellido,telefono,direccion,correo,isSuspendido);
    }
    
    @Override
    public void update(Cliente e) throws SQLException{
        // TODO: Implementar
        PreparedStatement prepStat = connection.prepareStatement(
                "UPDATE CLIENTES "
              + "SET "
              + "NOMBRECLIENTE=?,"    // 1
              + "APELLIDOCLIENTE=?,"  // 2
              + "DIRECCION=?,"        // 3
              + "TELEFONO=?,"         // 4
              + "CORREO=?, "           // 5
              + "SUSPENDIDO=? "           // 6
              + "WHERE CICLIENTE=?;" // 7
        );
        prepStat.setString(1, e.getNombre());
        prepStat.setString(2, e.getApellido());
        prepStat.setString(3, e.getDireccion());
        prepStat.setString(4, e.getTelefono());
        prepStat.setString(5, e.getCorreo());
        prepStat.setBoolean(6, e.isSuspendido());
        prepStat.setString(7, String.valueOf(e.getCedula()));
        
        prepStat.execute();
        prepStat.close();

    }

    @Override
    public void delete(Cliente e) throws SQLException{
        PreparedStatement prepStat = connection.prepareStatement(
                "DELETE FROM CLIENTES "
              + "WHERE CICLIENTE=?;"
        );
        
        prepStat.setString(1, String.valueOf(e.getCedula()));
        
        prepStat.execute();
        prepStat.close();

    }
    
    public void close() throws SQLException{
        connection.close();
    }
}

