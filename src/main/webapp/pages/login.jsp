<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - X_pense</title>
    <link rel="stylesheet" href="../CSS/loginpageCSS.css">

</head>
<body>
<div>
    <jsp:include page="../component/navbar_noSignIn.jsp"></jsp:include>

</div>
<div class="content">
    <div class="right-side">
        <div class="right-side-noImg">
            <form name="loginform" method="post" action="login">
                <label>
                    User Name:
                    <input type="text" name="userName" placeholder="enter user name" required>
                </label>
                <br> <br>
                <label>
                    Password:
                    <input type="password" name="password" placeholder="enter password" required>
                </label>
                <br><br>
                <button type="submit" class="submit_button"><b>Login</b></button>
                <br>
                <button class="reset_button" type="reset"><b>Reset</b></button>

            </form>
        </div>
    </div>
    <div class="left-side">
        <div class="left-side-img">

        </div>
    </div>
</div>
</body>
</html>
