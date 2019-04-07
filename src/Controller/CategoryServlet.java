package Controller;

import Entity.Category;
import Repository.CategoryRepository;
import Repository.imp.CategoryRepositoryImp;
import Service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "*.cate")
public class CategoryServlet extends HttpServlet {

    private CategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        //从"/"的下一位开始，到“."结束
        String path = uri.substring(uri.lastIndexOf("/") + 1, uri.indexOf("."));
        System.out.println(path);

        //通过反射来实现方法的调用
        try {
            Method method = CategoryService.class.getMethod(path, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(categoryService, request, response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
