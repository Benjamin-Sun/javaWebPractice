package Repository.imp;

import Entity.User;
import Repository.UserRepository;
import SqlUtils.Query;
import SqlUtils.ResultSetObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImp implements UserRepository {
    @Override
    public List<User> selectAll() throws SQLException {
        String sql = "SELECT * FROM t_user";
        List<User> list = Query.query(sql, new ResultSetObject<User>() {
            @Override
            public User getResult(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setPassword(resultSet.getString("upwd"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setAddress(resultSet.getString("address"));
                user.setUlevel(resultSet.getInt("ulevel"));
                return user;
            }
        });
        return list;
    }

    @Override
    public User selectByNamePassword(String uname, String pwd) throws SQLException {
        String sql="select * from t_user where uname=? and upwd=?";
        List<User> lists= Query.query(sql, new ResultSetObject<User>() {
            @Override
            public User getResult(ResultSet resultSet) throws SQLException {
                User user=new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setPassword(resultSet.getString("upwd"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setAddress(resultSet.getString("address"));
                user.setUlevel(resultSet.getInt("ulevel"));
                return user;
            }
        }, uname, pwd);
        if(lists==null){
            return null;
        }
        return lists.get(0);
    }

    @Override
    public User selectById(Integer id) throws SQLException {
        String sql = "SELECT * FROM t_user WHERE uid = ?";
        List<User> list = Query.query(sql, new ResultSetObject<User>() {
            @Override
            public User getResult(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setPassword(resultSet.getString("upwd"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setAddress(resultSet.getString("address"));
                user.setUlevel(resultSet.getInt("ulevel"));
                return user;
            }
        }, id);
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public int selectByName(String name) throws SQLException {
        String sql = "SELECT * FROM t_user WHERE uname = ?";
        List<User> list = Query.query(sql, new ResultSetObject<User>() {
            @Override
            public User getResult(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setPassword(resultSet.getString("upwd"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setAddress(resultSet.getString("address"));
                user.setUlevel(resultSet.getInt("ulevel"));
                return user;
            }
        }, name);
        if (list == null){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        String sql = "DELETE FROM t_user WHERE uid = ?";
        return Query.update(sql, id);
    }

    @Override
    public int insert(User user) throws SQLException {
        String sql = "INSERT INTO t_user (uid, uname, upwd, telephone, address, ulevel) VALUES(?, ?, ?, ?, ?, ?)";
        return Query.update(sql, user.getUid(), user.getUname(), user.getPassword(), user.getTelephone(), user.getAddress(), user.getUlevel());
    }

    @Override
    public int update(User user) throws SQLException {
        String sql = "UPDATE t_user SET uname = ?, upwd = ?, telephone = ?, address = ?, ulevel = ? WHERE uid = ?";
        return Query.update(sql, user.getUname(), user.getPassword(), user.getTelephone(), user.getAddress(), user.getUlevel(), user.getUid());
    }


}
