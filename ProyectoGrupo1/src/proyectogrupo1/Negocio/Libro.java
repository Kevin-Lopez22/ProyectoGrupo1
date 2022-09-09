package proyectogrupo1.Negocio;

import proyectogrupo1.ConexionSQL;
import java.sql.ResultSet;


import java.sql.Connection;

public class Libro { 
   
    private String idLibro,titulo, autor, isbn;
    private int  paginas, stock;

    ConexionSQL conecxion = new ConexionSQL();
    
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

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
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

    public ConexionSQL getConecxion() {
        return conecxion;
    }

    public void setConecxion(ConexionSQL conecxion) {
        this.conecxion = conecxion;
    }

    public static ResultSet getRes() {
        return res;
    }

    public static void setRes(ResultSet res) {
        Libro.res = res;
    }
    
    
}
