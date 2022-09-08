package proyectogrupo1.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import proyectogrupo1.SQLIndex;


public class Cliente extends Persona{
   public static SQLIndexIdCliente sQLIndexIdCliente;

   private final int idCliente;
   private boolean isSuspendido;

    Cliente(int idCliente, String cedula, String nombre, String apellido, String telefono, String direccion, String correo, boolean isSuspendido) {
        super(cedula, nombre, apellido, telefono, direccion, correo);
        this.idCliente = idCliente;
        this.isSuspendido = isSuspendido;
        //this.idCliente = (int) Math.random(); Crear metodo para obtener id de la base de datos
    }

   
    Cliente(int idCliente, String cedula, String nombre, String apellido, String telefono, String direccion, String correo) {
        this(idCliente,cedula,nombre,apellido,telefono,direccion,correo,false);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setSuspendido(boolean isSuspendido) {
        this.isSuspendido = isSuspendido;
    }
    
    public boolean isSuspendido() {
        return isSuspendido;
    }
                   
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente +",isSuspendido="+ String.valueOf(isSuspendido) + ", "+super.toString()+'}';
    }

    public static class SQLIndexIdCliente implements SQLIndex<Integer>{
        final static String INDEX_NAME = "idCliente";
        Connection connection;

        
        public SQLIndexIdCliente(Connection connection) {
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
