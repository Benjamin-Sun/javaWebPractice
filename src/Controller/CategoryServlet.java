package Controller;

import Entity.Category;
import Repository.CategoryRepository;
import Repository.imp.CategoryRepositoryImp;

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
    private CategoryRepository categoryRepository = new CategoryRepositoryImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        //从"/"的下一位开始，到“."结束
        String path = uri.substring(uri.lastIndexOf("/") + 1, uri.indexOf("."));
        System.out.println(path);

        //通过反射来实现方法的调用
        try {
            Method method = this.getClass().getMethod(path, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
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

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Category> lists = categoryRepository.selectAll();
        req.setAttribute("cates", lists);
        req.getRequestDispatcher("catelist.jsp").forward(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String cname = req.getParameter("cname");
        Category category = new Category();
        category.setCname(cname);

        int i = categoryRepository.insert(category);

        resp.sendRedirect("list.cate");

    }

    public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String cid = req.getParameter("id");
        if (cid != null) {
            Category category = categoryRepository.selectById(Integer.valueOf(cid));
            req.setAttribute("cate", category);
            req.getRequestDispatcher("cateupdate.jsp").forward(req, resp);

        }
        resp.sendRedirect("list.cate");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String cname = req.getParameter("cname");
        String cid = req.getParameter("cid");
        if (cid != null) {
            Category category = new Category();
            category.setCname(cname);
            category.setCid(Integer.valueOf(cid));

            int i = categoryRepository.update(category);
        }
        resp.sendRedirect("list.cate");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String cid = req.getParameter("id");
        if (cid != null) {
            int i= categoryRepository.deleteById(Integer.valueOf(cid));
        }
        resp.sendRedirect("list.cate");
    }
}
