<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
    <style type="text/css">
        span {
            height: 15px;
            background: #fff;
            color: #000;
            font-size: 12px;
            line-height: 15px;
            cursor: pointer;
            padding: 0 4px
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("span").click(function () {
                $(this).siblings(":text").val(eval($(this).siblings(":text").val() + $(this).text() + "1"))
            });
            $(".shopp-l").(function () {
                alert($(this).val())
            })
        })
    </script>
</head>
<body>
<table>
    <tr>
        <td>
            <span> - </span><input type="text" class="shopp-l"/><span>+</span>
        </td>
    </tr>
    <tr>
        <td>
        <%--<span> - </span><input type="text" class="shopp-l"/><span>+</span>--%>
        </td>
    </tr>
</table>

</body>
</html>
