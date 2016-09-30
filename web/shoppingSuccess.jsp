<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
 ${message}<br>
订单号为：${ddh}
 <a href="ShoppingServlet?http=query">点击查询订单</a>
</body>
</html>
