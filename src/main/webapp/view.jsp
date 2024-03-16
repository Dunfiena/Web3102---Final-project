<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.web.Model.*" %>
<%@ page import="com.example.web.Controller.expenseController" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.web.Controller.incomeController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");
    Account account = (Account) session.getAttribute("account");
    incomeController iControl = new incomeController();
    expenseController eControl = new expenseController();

    ArrayList<Income> incomes;
    try {
        incomes = iControl.selectIncome(account.getAccount_id());
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    ArrayList<Expense> expenses;
    try {
        expenses = eControl.selectExpense(account.getAccount_id());
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    ArrayList<transaction> transactions = new ArrayList<>();
    transaction tran;
    if (incomes != null) {
        for (Income income : incomes) {
            boolean reocc = false;
            if (income.getReoccuring() == 1) {
                reocc = true;
            }
            tran = new transaction(income.getId(), "Income",
                    income.getTran_date(), income.getAmount(), income.getTag(), reocc);
            transactions.add(tran);
        }
    }

    if (expenses != null) {
        for (Expense expense : expenses) {
            boolean reocc = false;
            if (expense.getReoccuring() == 1) {
                reocc = true;
            }
            tran = new transaction(Math.toIntExact(expense.getId()), "Expense",
                    expense.getTran_date(), expense.getAmount(), expense.getTag(), reocc);
            transactions.add(tran);
        }
    }

    if (user == null) {
        user = new User();
        user.setUsername("guest");
    }
%>
<!Doctype>
<html>
<head>
    <link rel="stylesheet" href="CSS/viewCSS.css">
    <title>View Account</title>
</head>
<body>
<div class="view_body">
    <div class="top_bar">
        <div class="title">
            Account
            <br>View
        </div>
        <div class="account_info">
            User:
            <%=user.getUsername()%>
            <br>Balance:
            <%=account.getBalence()%>
            <br>Account ID:
            <%=account.getAccount_id()%>
            <br>
        </div>
    </div>
    <div class="bottom_bar">
        <div class="log">
            <table>
                <tr>
                    <th>Type</th>
                    <th>Date</th>
                    <th>Amount</th>
                    <th>Tag</th>
                    <th>Reoccurring</th>
                </tr>
                <% if(!transactions.isEmpty()){
                    for (transaction tra : transactions) { %>
            <tr>
                <td><%=tra.getType()%></td>
                <td><%=tra.getDate()%></td>
                <td><%=tra.getAmount()%></td>
                <td><%=tra.getTag()%></td>
                <td><%=tra.isReOccurring()%></td>
            </tr>

            <%}}%>
            </table>
        </div>
        <div class="nav_button">
            <a href="displayPage.jsp"><button class="navigateButton">Home Screen</button></a>
            <br>
            <a href="log_tran.jsp"><button class="navigateButton">Log Transaction</button></a>
            <br>
            <a href="view.jsp"><button class="navigateButton">View account</button></a>
            <br>
            <a href="index.jsp"><button class="navigateButton">Log out</button></a>
        </div>
    </div>
</div>
</body>
</html>
