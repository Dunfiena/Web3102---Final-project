package com.example.web;

import java.io.*;
import java.sql.SQLException;

import com.example.web.Controller.userController;
import com.example.web.Model.User;
import com.example.web.Repo.userRepo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class EXPENSE_SERVLET01_USERFUNCS extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String url = request.getServletPath();
        switch (url){
            case "/login":
                try {
                    login(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/register":
                try {
                    register(request, response);
                } catch (SQLException | ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/income":
                income(request,response);
                break;
            case "/expense":
                expense(request,response);
                break;

        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        userController uControl = new userController();

        User user = uControl.login(username, password);

        request.setAttribute("user", user);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/displayPage.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("pages/displayPage.jsp");

    }
    public void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("userName");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        userController uControl = new userController();

        uControl.registerUser(username,fname,lname,email,password);

        User user = uControl.login(username, password);

        request.setAttribute("user", user);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/displayPage.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("pages/displayPage.jsp");

    }

    public void income(HttpServletRequest request, HttpServletResponse response){

    }

    public void expense(HttpServletRequest request, HttpServletResponse response){

    }

    public void destroy() {
    }
}