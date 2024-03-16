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
            case "/logTransaction":
                try {
                    logTransaction(request,response);
                } catch (SQLException | ServletException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession sess = request.getSession();

        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        user = uControl.login(username, password);
        account = aControl.getAccount(user.getUser_id());

        sess.setAttribute("user", user);
        sess.setAttribute("account", account);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayPage.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("displayPage.jsp");

    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession sess = request.getSession();

        String username = request.getParameter("userName");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        double balance = Double.parseDouble(request.getParameter("balance"));

        uControl.registerUser(username, fname, lname, email, password);
        user = uControl.login(username, password);

        aControl.registerAccount(user.getUser_id(), balance);
        account = aControl.getAccount(user.getUser_id());

        sess.setAttribute("user", user);
        sess.setAttribute("account", account);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayPage.jsp");
        rd.include(request, response);
        rd.forward(request, response);
        response.sendRedirect("displayPage.jsp");

    }

    public void logTransaction(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession sess = request.getSession();
        user = (User)sess.getAttribute("user");

        String action = request.getParameter("action");
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        String reoccurring = request.getParameter("reoccurring");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String tag = request.getParameter("tag");
        int reocc = 0;
        if (Objects.equals(reoccurring, "true")){
            reocc = 1;
        }
        accountController aControl = new accountController();
        account = aControl.getAccount(user.getUser_id());
        if (Objects.equals(action, "income")) {
            iControl.addIncome(accountID, reocc, amount, tag);
            account.setBalence(account.getBalence()+amount);
            aControl.update(account);
        }else {
            eControl.addExpense(accountID,reocc,amount, tag);
            account.setBalence(account.getBalence()-amount);
            aControl.update(account);
        }
        sess.setAttribute("account", account);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/log_tran.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("log_tran.jsp");

    }

    public void destroy() {
    }
}