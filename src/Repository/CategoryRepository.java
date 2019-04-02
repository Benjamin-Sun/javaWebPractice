package Repository;

import Entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryRepository {
    public List<Category> selectAll() throws SQLException;

    public Category selectById(Integer id) throws SQLException;

    public int deleteById(Integer id) throws SQLException;

    public int insert(Category category) throws SQLException;

    public int update(Category category) throws SQLException;

}
