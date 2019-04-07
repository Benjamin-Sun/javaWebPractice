package Controller;

import Entity.Goods;
import Repository.GoodsRepository;
import Repository.imp.GoodsRepositoryImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "GoodsServlet", urlPatterns = "*.goods")
public class GoodsServlet extends HttpServlet {
    private GoodsRepository goodsRepository = new GoodsRepositoryImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        System.out.println(uri);
        //从"/"的下一位开始，到“."结束
        String path=uri.substring(uri.lastIndexOf("/")+1,uri.indexOf("."));
        System.out.println(path);

        try {
            if("list".equals(path)){
                list(request,response);}
//            }else if ("add".equals(path)){
//                add(request,response);
//            }else if ("delete".equals(path)){
//                delete(request,response);
//            }else if ("find".equals(path)){
//                find (request,response);
//            }else if ("update".equals(path)){
//                update(request,response);
//            }else if ("login".equals(path)){
//                login(request,response);
//            }else if ("checkName".equals(path)){
//                checkName(request,response);
//            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        response.getWriter().write(String.valueOf(goodsRepository.selectAll()));
    }
}
