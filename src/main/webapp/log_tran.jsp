<%@ page import="com.example.web.Model.User" %>
<%@ page import="com.example.web.Model.Account" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User)session.getAttribute("user");
    Account account = (Account) session.getAttribute("account");

    if (user == null){
        user = new User();
        user.setUsername("guest");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="CSS/basicpage.css">
    <link rel="stylesheet" href="CSS/log_tranCSS.css">

    <title>Log transaction</title>
</head>
<script>
    function setAction(action){
        ("actionForm").action = action
    }

</script>
<body>
<div class="page_title">
    Log Transaction
</div>
<div class="displayBody">
    <div class="left-side_log">
        <div class="account_info">
            User:
            <%=user.getUsername()%>
            <br>Balance:
            <%=account.getBalence()%>
            <br>Account:
            <%=account.getAccount_id()%>
            <br>
        </div>
        <div class="nav_button">
            <a href="displayPage.jsp"><button class="navigateButton">Home Screen</button></a>
            <a href="log_tran.jsp"><button class="navigateButton">Log Transaction</button></a>
            <a href="view.jsp"><button class="navigateButton">View account</button></a>
            <a href="index.jsp"><button class="navigateButton">Log out</button></a>
        </div>
    </div>


    <div class="right-side_log">
        <form class="log_form" id="actionForm" method="get" action="logTransaction">
            <label>
                Type:
                <br>
                Income:
                <input type="radio" name="action" value="income" checked>
                Expense:
                <input type="radio" name="action" value="expense">
            </label>
            <br><br>
            <label>
                Amount:
                <input type="number" name="amount">
            </label>
            <br>
            <label>
                Tag:
                <input type="text" name="tag" placeholder="Enter a brief description">
            </label>
            <br><br>
            <label>
                Reoccurring:
                <input type="radio" name="reoccurring" value="true">
                <input type="radio" name="reoccurring" value="false" checked>

                <br><br>
                <input type="hidden" value="<%=account.getAccount_id()%>" name="accountID">
                <button type="submit" class="submit_button"><b>Submit</b></button>
                &nbsp;
                <button class="reset_button" type="reset"><b>Reset</b></button>

            </label>
        </form>
    </div>
</div>

</body>
</html>
