package proyectogrupo1.Negocio;

import java.sql.ResultSet;


import java.sql.Connection;

public class Libro {
    private int idLibro,stock, paginas ; 
   
    private String titulo,autor,ISBN,Stock;
    

    ConexionSQL conecxion = new ConexionSQL();
    
    static ResultSet res;

    public Libro(int idLibro, int stock, int paginas, String titulo, String autor, String iSBN, String stock2) {
        this.idLibro = idLibro;
        this.stock = stock;
        this.paginas = paginas;
        this.titulo = titulo;
        this.autor = autor;
        ISBN = iSBN;
        Stock = stock2;
    }

    public Libro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
