package Repository.imp;

import Entity.Category;
import Repository.CategoryRepository;
import SqlUtils.Query;
import SqlUtils.ResultSetObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryRepositoryImp implements CategoryRepository {
    @Override
    public List<Category> selectAll() throws SQLException {
        String sql = "SELECT * FROM t_category";
        List<Category> list = Query.query(sql, new ResultSetObject<Category>() {
            @Override
            public Category getResult(ResultSet resultSet) throws SQLException {
                Category category = new Category();
                category.setCid(resultSet.getInt("cid"));
                category.setCname(resultSet.getString("cname"));
                return category;
            }
        });
        return list;
    }

    @Override
    public Category selectById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Category category) throws SQLException {
        return 0;
    }

    @Override
    public int update(Category category) throws SQLException {
        return 0;
    }
}
