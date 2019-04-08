package Repository;

import Entity.Category;
import Entity.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsRepository {
    public List<Goods> selectAll() throws SQLException;

    public Goods selectById(Integer id) throws SQLException;

    public int deleteById(Integer id) throws SQLException;

    public int insert(Goods goods) throws SQLException;

    public int update(Goods goods) throws SQLException;
}
