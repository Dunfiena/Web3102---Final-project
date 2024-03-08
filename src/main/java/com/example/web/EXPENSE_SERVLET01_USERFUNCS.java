package com.example.web;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import com.example.web.Controller.accountController;
import com.example.web.Controller.expenseController;
import com.example.web.Controller.incomeController;
import com.example.web.Controller.userController;
import com.example.web.Model.Account;
import com.example.web.Model.Expense;
import com.example.web.Model.Income;
import com.example.web.Model.User;
import com.example.web.Repo.userRepo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


public class EXPENSE_SERVLET01_USERFUNCS extends HttpServlet {

    userController uControl = new userController();
    incomeController iControl = new incomeController();
    expenseController eControl = new expenseController();
    accountController aControl = new accountController();

    Account account;
    User user;
    Income income;
    Expense expense;
    ArrayList<Income> incomes;
    ArrayList<Expense> expenses;

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String url = request.getServletPath();
        switch (url){
            case "/login":
                try {
                    login(request, response);
                } catch (ServletException | SQLException e) {
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
                try {
                    income(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/expense":
                try {
                    expense(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        user = uControl.login(username, password);
        account = aControl.getAccount(user.getUser_id());

        request.setAttribute("user", user);
        request.setAttribute("account", account);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/displayPage.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("pages/displayPage.jsp");
//        setRequestReturn(request, response);

    }
    public void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("userName");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        double balance = Double.parseDouble(request.getParameter("balance"));

        uControl.registerUser(username,fname,lname,email,password);
        user = uControl.login(username, password);

        aControl.registerAccount(user.getUser_id(), balance);
        account = aControl.getAccount(user.getUser_id());
        request.setAttribute("user", user);
        request.setAttribute("account", account);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/displayPage.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("pages/displayPage.jsp");
//        setRequestReturn(request, response);

    }

//    private void setRequestReturn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("user", user);
//        request.setAttribute("account", account);
//
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/displayPage.jsp");
//        rd.include(request,response);
//        rd.forward(request,response);
//        response.sendRedirect("pages/displayPage.jsp");
//    }

    public void income(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Long accountID = Long.valueOf(request.getParameter("accountID"));
        String reoccurring = request.getParameter("reoccurring");
        double amount = Double.parseDouble(request.getParameter("amount"));
        int reocc = 0;
        if (Objects.equals(reoccurring, "true")){
            reocc = 1;
        }
        iControl.addIncome(accountID,reocc,amount);
    }

    public void expense(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Long accountID = Long.parseLong(request.getParameter("accountID"));
        String reoccurring = request.getParameter("reoccurring");
        double amount = Double.parseDouble(request.getParameter("amount"));

        int reocc = 0;
        if (Objects.equals(reoccurring, "true")){
            reocc = 1;
        }
        eControl.addExpense(accountID,reocc,amount);
    }

    public void destroy() {
    }
}