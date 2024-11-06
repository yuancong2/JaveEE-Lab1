/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserService;

/**
 *
 * @author 12906
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (UserService.login(username, password)==0) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("success.jsp");
        } else if (UserService.login(username, password)==1){
            request.setAttribute("error", "密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (UserService.login(username, password)==2){
            request.setAttribute("error", "账户不存在");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
    }

    

}
