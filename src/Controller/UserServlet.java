package Controller;

import Entity.User;
import Repository.UserRepository;
import Repository.imp.UserRepositoryImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "*.user")
public class UserServlet extends HttpServlet {

    private UserRepository userRepository=new UserRepositoryImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        System.out.println(uri);
        //从"/"的下一位开始，到“."结束
        String path=uri.substring(uri.lastIndexOf("/")+1,uri.indexOf("."));
        System.out.println(path);

        try {
            if("list".equals(path)){
                list(request,response);
            }else if("add".equals(path)){
                add(request,response);
            }else if("delete".equals(path)){
                delete(request,response);
            }else if("find".equals(path)){
                find(request,response);
            }else if("update".equals(path)){
                update(request,response);
            }else if("login".equals(path)){
                login(request,response);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }


    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //1：从页面请求过来的的数据
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //2：查找有没有这个用户
        User user = userRepository.selectByNamePassword(username, password);
        HttpSession session=req.getSession();
        if(user == null){//用户是否存在
            resp.sendRedirect("login.jsp");
        }else{
            if(user.getUlevel()==0) {//是不是管理员
                session.setAttribute("user",user);
                resp.sendRedirect("list.user");

            }else{
                resp.sendRedirect("login.jsp");
            }
        }

    }
    /**
     * 收集网页中的数据，进行修改操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //1：收集网页中的数据
        String username=req.getParameter("username");
        String uid=req.getParameter("uid");
        String telephone=req.getParameter("telephone");
        String address=req.getParameter("address");

        //2:生成对象
        if(uid!=null && !"".equals(uid)){

            User user=new User();
            user.setUid(Integer.valueOf(uid));
            user.setUname(username);
            user.setTelephone(telephone);
            user.setAddress(address);

            //3：修改的功能的实现

            int i=userRepository.update(user);
            //4：重定向到list界面
            if(i!=-1){
                resp.sendRedirect("list.user");
            }
        }
    }
    /**
     * 根据id查找一条记录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //1：获取页面中id
        String id=req.getParameter("id");
        //2：判断id是否有效
        if(id!=null&&!"".equals(id)){
            Integer idi=Integer.valueOf(id);
            //3:通过id得到数据--一条记录
            User user=userRepository.selectById(idi);
            if(user!=null){
                req.setAttribute("user",user);
                req.getRequestDispatcher("userupdate.jsp").forward(req,resp);
            }

        }

    }
    /**
     * 根据id进行删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //1:从页面提取删除的id
        String id=req.getParameter("id");
        //2:删除
        if(id!=null&&!"".equals(id)) {
            int i = userRepository.deleteById(Integer.valueOf(id));
            if(i!=-1){
                resp.sendRedirect("list.user");
            }else{
                resp.sendRedirect("error.jsp");
            }
        }else{
            resp.sendRedirect("error.jsp");
        }

    }
    /**
     * 实现添加
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        /**
         * 1:提取页面中的所有表单元素的数据
         */
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String telephone=req.getParameter("telephone");
        String address=req.getParameter("address");
        /**
         * 2: 生成对象
         */
        User user=new User();
        user.setUname(username);
        user.setPassword(password);
        user.setTelephone(telephone);
        user.setAddress(address);
        user.setUlevel(1);

        /**
         * 3:添加功能的实现
         */
        int i=userRepository.insert(user);

        /**
         * 4：跳转
         */
        if(i!=-1){
            resp.sendRedirect("list.user");
        }else{
            resp.sendRedirect("useradd.jsp");
        }


    }
    /**
     * 查找全部数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<User> userlist=userRepository.selectAll();
        req.setAttribute("users",userlist);
        req.getRequestDispatcher("userlist.jsp").forward(req,resp);
    }
}
