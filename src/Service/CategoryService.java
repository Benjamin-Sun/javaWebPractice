package Service;

import Entity.Category;
import Repository.CategoryRepository;
import Repository.imp.CategoryRepositoryImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CategoryService {

    private CategoryRepository categoryRepository = new CategoryRepositoryImp();

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
