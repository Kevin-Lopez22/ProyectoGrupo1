
package proyectogrupo1;
import java.sql.SQLException;
import java.util.List;

/**
 * De SQL y CRUD SqlCrud es una interfaz que provee las funciones CRUD (Create
 * , Read, Update, Delete) con para una conexión SQL (De ahí los throw
 * SQLException).
 * 
 * @author luism
 * @param <E> Clase asociada a el tipo de Objecto/Clase que se manejará. En 
 * cierta manera, E es la clase asociada al CRUD. Esta clase deberá tener un campo
 * tipo {@code F} que pueda ser ocupado como PK
 * @param <F> Clase de la primary key
 */
public interface SqlCrud<E,F extends Comparable<F>> {
    
    /**
     * Funcion create del CRUD
     * Recibe un objeto {@code e} el cual será insertado a la tabla
     * @param e Objeto a insertar
     * @throws SQLException 
     */
    void create(E e) throws SQLException;
    
    /**
     * Funcion read del CRUD(1)
     * Recibe un límite inferior y un límite superior para el PK, se leeran
     * y devolverán todos los Objetos en la tabla cuya PK se encuentre dentro
     * de este rango. Este deberá ser inclusivo [a,b]
     * @param lowerLimit Limite inferior de la PK
     * @param upperLimit Limite inferior de la PK
     * @return Una List con todos los objetos leídos dentro del rango
     * @throws SQLException 
     */
    List<E> read(F lowerLimit, F upperLimit) throws SQLException;
    
    /**
     * Funcion read del CRUD(2)
     * Recibe la PK del objetivo y devuelve una lista con las coincidencias
     * @param key
     * @return List con los elemenetos con PK=key
     * @throws SQLException 
     */
    default List<E> read(F key) throws SQLException{
        return read(key,key);
    }
    
    /**
     * Funcion update del CRUD
     * Recibe un objeto y actualiza la tupla en la tabla respectiva.
     * El objeto deberá ocupar la PK para identificar a la tupla la cual actualizar
     * esta PK es inmutable
     * @param e Objeto a actualizar
     * @throws SQLException 
     */
    void update(E e) throws SQLException;;
    
    /**
     * Funcion delete del CRUD
     * Recibe un objeto y elimina la tupla en la tabla respectiva.
     * La tupla se identificará por la PK. La eliminación no es reversible
     * @param e Objeto a eliminar
     * @throws SQLException 
     */
    void delete(E e) throws SQLException;;
}
