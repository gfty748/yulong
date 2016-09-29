<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .jd_title {
            font-weight: bold;
            font-size: 24px;
        }
    </style>
</head>
<body>

<span style="background-color:#ffff00;">
    <div>
        ①丽江
        &mdash;
        ②甘海子
        &mdash;
        ③蓝月谷
        &mdash;
        ④云杉坪
        &mdash;
        ⑤雪厨餐厅
        &mdash;
        ⑥印象丽江
    </div>
</span>
<c:forEach items="${jds}" var="jd">
<a class="jd_title">${jd.jd_name}</a><br>
<img src="${jd.jd_img}">
${jd.jd_description}
</c:forEach>
</body>
</html>
