<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ShoppingServlet">
    <input type="hidden" name="http" value="query">
    请输入订单号：<input type="text" name="id"> <input type="submit" value="查询">
</form>
    购买信息如下：<br>
    ${oders[0].goods}<br>
    总价:￥${oders[0].total}.00
</body>
</html>
