<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/1
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table style="margin: 0 auto;" align="center" width="704" height="500" border="0">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${customers.list}" var="customer" varStatus="status">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.age}</td>
            <td>
                <c:if test="${sessionScope.loginCustomer.id != customer.id}">
                    <a href="/customer/delete/${customer.id}">删除</a>
                </c:if>
                <a href="#">修改</a>
            </td>
        </tr>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4">
            当前页${customers.pageNum}/总页数${customers.pages}
            <a href="/customer/list">首页</a>
            <c:if test="${not customers.isFirstPage}">
                <a href="/customer/list?pageNum=${customers.pageNum-1}">上一页</a>
            </c:if>
            <c:if test="${not customers.isLastPage}">
                <a href="/customer/list?pageNum=${customers.pageNum+1}">下一页</a>
            </c:if>
            <a href="/customer/list?pageNum=${customers.pages}">末页</a>
        </td>
</table>
</body>
</html>
