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
        String sql = "SELECT * FROM t_category";
        List<Category> list = Query.query(sql, new ResultSetObject<Category>() {
            @Override
            public Category getResult(ResultSet resultSet) throws SQLException {
                Category category = new Category();
                category.setCid(resultSet.getInt("cid"));
                category.setCname(resultSet.getString("cname"));
                return category;
            }
        }, id);
        return list.get(0);
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        String sql = "DELETE FROM t_category WHERE cid = ?";
        return Query.update(sql, id);
    }

    @Override
    public int insert(Category category) throws SQLException {
        String sql = "INSERT INTO t_category (cid, cname) VALUES(?, ?)";
        return Query.update(sql, category.getCid(), category.getCname());
    }

    @Override
    public int update(Category category) throws SQLException {
        String sql = "UPDATE t_category SET cname = ? WHERE cid = ?";
        return Query.update(sql, category.getCname(), category.getCid());
    }
}
