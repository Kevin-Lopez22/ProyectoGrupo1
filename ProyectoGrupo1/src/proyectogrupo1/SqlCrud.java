
package proyectogrupo1;
import java.sql.SQLException;
public interface SqlCrud<E> {
    void create(E e) throws SQLException;
    E read() throws SQLException;;
    void update(E e) throws SQLException;;
    void delete(E e) throws SQLException;;
}
