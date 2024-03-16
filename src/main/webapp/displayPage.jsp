<%@ page import="com.example.web.Model.User" %>
<%@ page import="com.example.web.Model.Account" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.web.Model.Income" %>
<%@ page import="com.example.web.Model.Expense" %>
<%@ page import="com.example.web.Controller.incomeController" %>
<%@ page import="com.example.web.Controller.expenseController" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.web.Controller.accountController" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
    incomeController iControl = new incomeController();
    expenseController eControl = new expenseController();

    User user = (User)session.getAttribute("user");
    Account account = (Account)session.getAttribute("account") ;
    int transactions_count=0;

    ArrayList<Income> incomes = new ArrayList<Income>();
    ArrayList<Expense> expenses = new ArrayList<Expense>();
    try {
        incomes = iControl.selectIncome(account.getAccount_id());
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    try {
        expenses = eControl.selectExpense(account.getAccount_id());
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    if(!incomes.isEmpty() && !expenses.isEmpty()) {
        transactions_count = incomes.size() + expenses.size();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/basicpage.css">
    <link rel="stylesheet" href="CSS/displayPageCSS.css">
    <title>Welcome <%=user.getUsername()%></title>
</head>
<body>

<div class="displayBody">
    <div class="section1">
        <div class="welcome">
            <div class="welcome_text">
                Welcome,<br>
            </div>
            <div class="name">
                <%=user.getUsername()%>
            </div>
        </div>
        <div class="balance_display">
            <table>
                <tr>
                    <th>Balance:</th>
                    <td><%=account.getBalence()%></td>
                </tr>
                <tr>
                    <th>Number of transactions:</th>
                    <td><%=transactions_count%>
                </tr>
                <tr>
                    <th>Next reoccurring income transaction:</th>
                    <% if (!incomes.isEmpty()){ %>
                    <td><%=incomes.get(0).getTran_date()%></td>
                    <%}%>
                </tr>
                <tr>
                    <th>Next reoccurring expense transaction:</th>
                    <% if (!expenses.isEmpty()){ %>
                    <td><%=expenses.get(0).getTran_date()%></td>
                    <%}%>

                </tr>
            </table>
        </div>
        <div class="nav_button">
            <a href="displayPage.jsp"><button class="navigateButton">Home Screen</button></a>
            <a href="log_tran.jsp"><button class="navigateButton">Log Transaction</button></a>
            <a href="view.jsp"><button class="navigateButton">View account</button></a>
            <a href="index.jsp"><button class="navigateButton">Log out</button></a>
        </div>
    </div>


    <div class="section2">
        <div class="section_title">
            Income
        </div>
        <div class="transaction_column">
            <table>
                <tr>
                    <th>Date</th>
                    <th>Amount</th>
                    <th>Reoccurring</th>
                </tr>
                <% if (!incomes.isEmpty()){
                    for(Income income: incomes){ %>
                <tr>
                    <td><%=income.getTran_date()%></td>
                    <td><%=income.getAmount()%></td>
                    <td> <%if(income.getReoccuring() == 1){%>
                        Yes
                        <%}else{%>
                        No
                        <%}%></td>
                </tr>
                <%}}%>
            </table>

        </div>
    </div>


    <div class="section3">
        <div class="section_title">
            Expense
        </div>
        <div class="transaction_column">
            <table>
                <tr>
                    <th>Date</th>
                    <th>Amount</th>
                    <th>Reoccurring</th>
                </tr>
                <% if (!expenses.isEmpty()){
                    for(Expense expense: expenses){ %>
                <tr>
                    <td><%=expense.getTran_date()%></td>
                    <td><%=expense.getAmount()%></td>
                    <td><%if(expense.getReoccuring() == 1){%>
                        Yes
                        <%}else{%>
                        No
                        <%}%></td>
                </tr>
                <%}
                }%>
            </table>
        </div>
    </div>


</div>
<div></div>
</body>
</html>
