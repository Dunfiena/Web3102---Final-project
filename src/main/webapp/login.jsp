<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login - X_pense</title>
    <link rel="stylesheet" href="CSS/basicpage.css">
    <link rel="stylesheet" href="CSS/loginpageCSS.css">

</head>
<body>

<div class="content">
    <div class="left-side">
        <div class="left-side-img">
            <div class="loginImage"><img src="CSS/img/Login_splash_image.jpg" alt="wealth vibes" width="100%"></div>
        </div>
    </div>

    <div class="right-side">
        <div>
            <jsp:include page="component/navbarIndex.jsp"></jsp:include>
        </div>
        <div class="right-side-noImg">
            <div class="formtitle">Login to Expense</div>
            <form class="loginform" method="get" action="login">
                <label>
                    User Name:<br>
                    <input type="text" name="userName" placeholder="enter user name" required>
                </label>
                <br>
                <label>
                    Password:<br>
                    <input type="password" name="password" placeholder="enter password" required>
                </label>
                <br><br>
                <button type="submit" class="submit_button"><b>Login</b></button>
                &nbsp;
                <button class="reset_button" type="reset"><b>Reset</b></button>

            </form>
        </div>
    </div>
</div>
</body>
</html>
