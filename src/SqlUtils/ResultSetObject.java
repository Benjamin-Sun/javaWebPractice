package SqlUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetObject<T> {
    T getResult(ResultSet resultSet) throws SQLException;
}
