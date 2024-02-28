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
        <div class="right-side-img">

        </div>
    </div>
    <div class="left-side">
        <div class="left-side-noImg">
            <form name="registerform" method="post" action="register">

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
                    Date of Birth:
                    <input type="date" name="dob">
                </label>
                <br>
                <label>
                    Phone number:
                    <input type="text" name="phone" placeholder="enter phone number" required>
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
                <br><br>
                <button type="submit" class="submit_button"><b>Register</b></button>
                <br>
                <button type="reset" class="reset_button"><b>Reset</b></button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
