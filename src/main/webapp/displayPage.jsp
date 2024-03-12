<%@ page import="com.example.web.Model.User" %>
<%@ page import="com.example.web.Model.Account" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.web.Model.Income" %>
<%@ page import="com.example.web.Model.Expense" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User)request.getAttribute("user");
    Account account = (Account) request.getAttribute("account");
//    ArrayList<Income> incomes = (ArrayList<Income>)request.getAttribute("incomes");
//    ArrayList<Expense> expenses = (ArrayList<Expense>)request.getAttribute("expenses");

//    int transactions_count = incomes.size() + expenses.size();

    if (user == null){
        user = new User();
        user.setUsername("guest");
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
<%--            <table>--%>
<%--                <tr>--%>
<%--                    <th>Balance:</th>--%>
<%--                    <td><%=account.getBalence()%></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Number of transactions:</th>--%>
<%--                    <td><%=transactions_count%>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Next reoccurring income transaction:</th>--%>
<%--                    <td><%=incomes.get(-0).getTran_date()%></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Next reoccurring expense transaction:</th>--%>
<%--                    <td><%=expenses.get(-0).getTran_date()%></td>--%>
<%--                </tr>--%>
<%--            </table>--%>
        </div>
        <div class="nav_button">
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
<%--                <% if (incomes !=null){for(Income income: incomes){ %>--%>
                <tr>
<%--                    <td><%=income.getTran_date()%></td>--%>
<%--                    <td><%=income.getAmount()%></td>--%>
<%--                    <td><%=income.getReoccuring()%></td>--%>
                </tr>
<%--                <%}}%>--%>
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
<%--                <% if (expenses !=null){for(Expense expense: expenses){ %>--%>
                <tr>
<%--                    <td><%=expense.getTran_date()%></td>--%>
<%--                    <td><%=expense.getAmount()%></td>--%>
<%--                    <td><%=expense.getReoccuring()%></td>--%>
                </tr>
<%--                <%}}%>--%>
            </table>
        </div>
    </div>


</div>
<div></div>
</body>
</html>
