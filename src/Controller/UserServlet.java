package Controller;

import Entity.User;
import Repository.UserRepository;
import Repository.imp.UserRepositoryImp;
import Service.UserService;

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

    private UserService userService=new UserService();

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
                userService.list(request,response);
            }else if ("add".equals(path)){
                userService.add(request,response);
            }else if ("delete".equals(path)){
                userService.delete(request,response);
            }else if ("find".equals(path)){
                userService.find (request,response);
            }else if ("update".equals(path)){
                userService.update(request,response);
            }else if ("login".equals(path)){
                userService.login(request,response);
            }else if ("checkName".equals(path)){
                userService.checkName(request,response);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}
