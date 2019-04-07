package Repository.imp;

import Entity.Category;
import Entity.Goods;
import Repository.GoodsRepository;
import SqlUtils.Query;
import SqlUtils.ResultSetObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GoodsRepositoryImp implements GoodsRepository {
    @Override
    public List<Goods> selectAll() throws SQLException {
        String sql = "SELECT * FROM t_good";
        List<Goods> list = Query.query(sql, new ResultSetObject<Goods>() {
            @Override
            public Goods getResult(ResultSet resultSet) throws SQLException {
                Goods goods = new Goods();
                goods.setGname(resultSet.getString("gname"));
                goods.setGnum(resultSet.getString("gnum"));
                goods.setGprice(resultSet.getBigDecimal("gprice"));
                goods.setGsell(resultSet.getInt("gsell"));
                goods.setGstock(resultSet.getInt("gstock"));
                return goods;
            }
        });
        return list;
    }

    @Override
    public Goods selectById(Integer id) throws SQLException {
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
