<%--
  Created by IntelliJ IDEA.
  User: Sid775
  Date: 05.05.2017
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tests_list</title>
</head>
<body>
    <form:form method="post" commandName="testForm" modelAttribute="testsForm">
        <c:forEach items="${tests}" var="test">
            <a href="/test/${test.getId()}">Test # ${test.getId()}</a>
            <p>${test}</p>
        </c:forEach>
    </form:form>
</body>
</html>
