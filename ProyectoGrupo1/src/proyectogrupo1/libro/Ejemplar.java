package proyectogrupo1.libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectogrupo1.SQLIndex;
import static proyectogrupo1.SQLIndex.TABLE_NAME;
import proyectogrupo1.cliente.Cliente;

public class Ejemplar {
    private final int idEjemplar;
    private final Libro libro;
    private String estadoEjemplar;

    public Ejemplar(int idEjemplar, Libro libro) {
        this(idEjemplar,libro,"Disponible");
    }
    
    public Ejemplar(int idEjemplar, Libro libro, String estadoEjemplar) {
        this.idEjemplar = idEjemplar;
        this.libro = libro;
        this.estadoEjemplar = estadoEjemplar;
    }

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getEstadoEjemplar() {
        return estadoEjemplar;
    }

    public void setEstadoEjemplar(String estadoEjemplar) {
        this.estadoEjemplar = estadoEjemplar;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "idEjemplar=" + idEjemplar + ", libro=" + libro + ", estadoEjemplar=" + estadoEjemplar + '}';
    }

       @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ejemplar other = (Ejemplar) obj;
        if(this.idEjemplar == other.idEjemplar) return true;
        return false;
    }
    
    
    public static class SQLIndexIdEjemplar implements SQLIndex<Integer>{
        final static String INDEX_NAME = "idEjemplar";
        Connection connection;

        
        public SQLIndexIdEjemplar(Connection connection) {
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
