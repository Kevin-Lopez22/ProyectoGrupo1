
package proyectogrupo1;
import java.sql.SQLException;
import java.util.List;

public interface SqlCrud<E,F extends Comparable<F>> {
    void create(E e) throws SQLException;
    List<E> read(F lowerLimit, F upperLimit) throws SQLException;;
    void update(E e) throws SQLException;;
    void delete(E e) throws SQLException;;
}
