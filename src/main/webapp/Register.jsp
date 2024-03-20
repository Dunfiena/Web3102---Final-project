<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login - X_pense</title>
    <link rel="stylesheet" href="CSS/registerCSS.css">
    <link rel="stylesheet" href="CSS/basicpage.css">

</head>
<body>
<div class="content">
    <div class="left-side">
        <div class="left-side-noImg">
            <div class="formtitle">Register to Expense</div>
            <form class="regform" method="get" action="register">

                <label>
                    User Name:
                    <input type="text" name="userName" placeholder="enter user name" required>
                </label>
                <br>
                <label>
                    First Name:
                    <input type="text" name="fname" placeholder="enter first name" required>
                </label>
                <br>
                <label>
                    Last Name:
                    <input type="text" name="lname" placeholder="enter last name" required>
                </label>
                <br>
                <label>
                    Email:
                    <input type="text" name="email" placeholder="enter a valid email" required>
                </label>
                <br>
                <label>
                    Password:
                    <input type="password" name="password" placeholder="enter password" required>
                </label>
                <label>
                    Balance:
                    <input type="number" name="balance" placeholder="enter account balance" required>
                </label>
                <br><br>
                <button type="submit" class="submit_button"><b>Register</b></button>
                &nbsp;
                <button type="reset" class="reset_button"><b>Reset</b></button>
            </form>
        </div>
    </div>
    <div class="right-side">
        <div>
            <jsp:include page="component/navbarIndex.jsp"></jsp:include>
        </div>
        <div class="right-side-img">
            <div class="regImage"><img src="CSS/img/Register_splash_image.jpg" alt="wealth vibes" width="100%"></div>
        </div>
    </div>
</div>
</body>
</html>
