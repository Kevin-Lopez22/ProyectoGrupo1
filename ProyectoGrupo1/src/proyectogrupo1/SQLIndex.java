/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectogrupo1;

import java.sql.SQLException;

/**
 *
 * @author luism
 */
public interface SQLIndex<E> {
    final static String TABLE_NAME = "indices";
    
    E peek() throws SQLException ;
    
    default E pop() throws SQLException {
        E ret = peek();
        increment();
        return ret;
    }
    
    void increment() throws SQLException ;
    void decrement() throws SQLException ;
    void close() throws SQLException;
}
