package proyectogrupo1;
import java.sql.*;

final class SqlCrudCliente implements SqlCrud<Cliente>{

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
    public Cliente read() throws SQLException{
        // TODO: Implementar
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Cliente e) throws SQLException{
        // TODO: Implementar
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Cliente e) throws SQLException{
        // TODO: Implementar
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void close() throws SQLException{
        connection.close();
    }
}
