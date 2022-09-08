package proyectogrupo1.Negocio;

import java.sql.ResultSet;


import java.sql.Connection;

public class Libro { 
   
    private String titulo, autor, ISBN;
    private int idLibro, paginas, stock;

    ConexionSQL conecxion = new ConexionSQL();
    
    static ResultSet res;

    public Libro(int idLibro, String titulo, String autor, String isbn, int paginas, int stock) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = isbn;
        this.stock = stock;
        this.paginas = paginas;   
    }

    public Libro() {
        this.idLibro = 0;
        this.titulo = "";
        this.autor = "";
        this.ISBN = "";
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
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
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
