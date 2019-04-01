package Repository;

import Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    public List<User> selectAll() throws SQLException;

    public User selectById(Integer id) throws SQLException;

    public int deleteById(Integer id) throws SQLException;

    public int insert(User user) throws SQLException;

    public int update(User user) throws SQLException;

    public static User selectByNamePassword(String uname, String pwd) throws SQLException;
}
