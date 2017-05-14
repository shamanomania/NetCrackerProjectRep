<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html
        PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xml:lang="en"
      xmlns:p="http://primefaces.org/ui"
      lang="en">
<head>
    <title></title>
</head>
<body>

<h2>Hi ${userEmail}</h2>
${loggedUser}
<c:forEach items="${testsPassedByUser}" var="test">
    _____________________________________<br/>
    Test id: ${test.getTest().getId()}<br/>
    Result: ${test.getResult()}<br/>
    _____________________________________<br/>
</c:forEach>

<a href="/tests">Tests</a>
</body>
</html>