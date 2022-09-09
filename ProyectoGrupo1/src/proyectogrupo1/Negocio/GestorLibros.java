/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1.Negocio;

import proyectogrupo1.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcelinne
 */
public class GestorLibros {
    
    ConexionSQL conexion = new ConexionSQL();
    static ResultSet res;
     
   
    public boolean eliminarLibro(String IdLibro) {
        CallableStatement con = null; 
        boolean respuesta = true;
        
        try{              
            con = ConexionSQL.getConexion().prepareCall("{call eliminarLibro(?)}");

            con.setString(1, IdLibro);
            respuesta = con.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }

    
    
    public void buscarLibro(JTable jTabla, String consulta) throws SQLException{
        //Carga la informacion de buscar libro y lo pone en el jtable 
        DefaultTableModel modelo = (DefaultTableModel) jTabla.getModel();
        modelo.setRowCount(0);
        res = proyectogrupo1.ConexionSQL.consulta(consulta);
        try{
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getInt(5));
                v.add(res.getInt(6));
                modelo.addRow(v);
                jTabla.setModel(modelo);
            }
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    public void buscarEjemplar(JTable jTabla, String consulta) throws SQLException{
        //Carga la informacion de buscar libro y lo pone en el jtable 
        DefaultTableModel modelo = (DefaultTableModel) jTabla.getModel();
        modelo.setRowCount(0);
        res = proyectogrupo1.ConexionSQL.consulta(consulta);
        try{
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getInt(2));
                v.add(res.getString(3));
                modelo.addRow(v);
                jTabla.setModel(modelo);
            }
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

   
    public boolean agregarLibro(Libro libro){
        CallableStatement con = null; 
        boolean respuesta = true;
        
        try{
            con = ConexionSQL.getConexion().prepareCall("{call insertarLibro(?,?,?,?,?,?)}");
                                 
            con.setString(1, libro.getIdLibro());
            con.setString(2, libro.getTitulo());
            con.setString(3, libro.getISBN());
            con.setString(4, libro.getAutor());
            con.setInt(5, libro.getStock());
            con.setInt(6, libro.getPaginas());
            
            respuesta = con.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
   
    public boolean agregarEjemplar(String idLibro,String descripcion){
        CallableStatement con = null; 
        boolean respuesta = true;
        
        try{
            con = ConexionSQL.getConexion().prepareCall("{call insertarEjemplar(?,?)}");
            con.setString(1, idLibro);
            con.setString(2, descripcion);
            respuesta = con.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
      
    public boolean eliminarEjemplar(int idEjemplar){
        CallableStatement con = null; 
        boolean respuesta = true;
        
        try{
            con = ConexionSQL.getConexion().prepareCall("{call eliminarEjemplar(?)}");
            
            con.setInt(1, idEjemplar);
            respuesta = con.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public boolean modificarDisponibilidad (String id_libro, String descripcion){
        Connection con = null;
        CallableStatement entrada = null;
        boolean respuesta = true;
        
        try{
            con = ConexionSQL.getConexion();
            con.setAutoCommit(false);
            
            entrada = ConexionSQL.getConexion().prepareCall("{call actualizarDescripcion(?, ?)}");
            
            entrada.setString(1, id_libro);
            entrada.setString(2, descripcion);
            respuesta = entrada.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }   
    
}
