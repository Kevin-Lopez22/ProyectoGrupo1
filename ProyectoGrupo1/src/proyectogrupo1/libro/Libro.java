package proyectogrupo1.libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectogrupo1.SQLIndex;
import static proyectogrupo1.SQLIndex.TABLE_NAME;


public class Libro { 
    public static SQLIndexIdLibro sQLIndexIdLibro;
    
    private final String idLibro;
    private String titulo, autor, isbn;
    private int  paginas, stock;

    
    static ResultSet res;

    public Libro(String idLibro, String titulo, String isbn, String autor, int stock, int paginas) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.stock = stock;
        this.paginas = paginas;   
    }

    public Libro() {
        this.idLibro = "";
        this.titulo = "";
        this.autor = "";
        this.isbn = "";
        this.stock = 0;
        this.paginas = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String ISBN) {
        this.isbn = ISBN;
    }

    public String getIdLibro() {
        return idLibro;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public static ResultSet getRes() {
        return res;
    }

    public static class SQLIndexIdLibro implements SQLIndex<Integer>{
        final static String INDEX_NAME = "idLibro";
        Connection connection;

        
        public SQLIndexIdLibro(Connection connection) {
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
        final Libro other = (Libro) obj;
        if(this.idLibro.equals(other.idLibro)) return true;
        return false;
    }
    
    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", paginas=" + paginas + ", stock=" + stock + '}';
    }
    
    
}
