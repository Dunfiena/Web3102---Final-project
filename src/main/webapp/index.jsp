<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="CSS/landingpageCSS.css">
  <link rel="stylesheet" href="CSS/basicpage.css">
  <title>JSP - Hello World</title>
</head>
<body>
<div class="landingbody">
  <div class="left-side">
    <div class="call">
      E<br>x<br>p<br>e<br>n<br>s<br>e
    </div>

  </div>
  <div class="semi">

  </div>
  <div class="right-side">
    <div>
      <jsp:include page="component/navbarIndex.jsp"></jsp:include>

    </div>
      <div class="subCall">
      Track <br> the way <br> you spend
      </div>
  </div>
</div>
</body>
</html>