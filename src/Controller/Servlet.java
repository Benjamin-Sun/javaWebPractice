package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
//@WebServlet(name = "servlet", urlPatterns = "/login", loadOnStartup = 1)
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
//        System.out.println(name + "  " + password);
        String[] boxValues = request.getParameterValues("box");


        //生成响应页面
//        response.setContentType("text/html;charset=utf-8");
//        response.setCharacterEncoding("utf-8");
//        PrintWriter out = response.getWriter();
//
//        if (!name.equals("") && !password.equals("")){
//            out.println("<h3>用户名是：</h3>" + name + "</br>");
//            out.println("<h3>welcome</h3>");
//        }else {
//            out.println("<h3>error</h3>");
//        }
//
//        for (int i = 0; i < boxValues.length; i++){
//            out.println(boxValues[i]);
//        }

        //页面跳转
//        request.setAttribute("username", name);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("res.jsp");
//        dispatcher.forward(request, response);

        HttpSession session = request.getSession();

        //重定向
        //重定向一般只用于跳转，无法传参数
//        response.sendRedirect("res.jsp");

        response.sendRedirect("sessionShow.jsp");
        session.setAttribute("username", name);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
