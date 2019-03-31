package SqlUtils;

import java.sql.*;

public class Tools {
    static {
        try {
            Class.forName(Conn.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(Conn.URL, Conn.USERNAME, Conn.PASSWORD);
    }

    public static void insertParam(PreparedStatement ps, Object ...objects){
        if (objects != null && objects.length > 0){
            for (int i = 0; i < objects.length; i++){
                try {
                    ps.setObject(i + 1, objects[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void close(Object ...objects){
        if (objects != null && objects.length > 0){
            for (Object o : objects){
                try {
                    if (o instanceof Connection){
                        ((Connection) o).close();
                    }
                    if (o instanceof Statement){
                        ((Statement) o).close();
                    }
                    if (o instanceof ResultSet){
                        ((ResultSet) o).close();
                    }
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
