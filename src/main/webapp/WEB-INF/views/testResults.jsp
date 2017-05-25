<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Netcracker</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="/css/stylesForREsults.css"%>
    </style>
    <%--<link href="../../css/stylesForREsults.css" rel="stylesheet">--%>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<header>
    <div><img class="pull-left" src="<c:url value="/images/logo.png" />" alt="Netcracker"></div>

    <div>
        <nav class="navbar" role="navigation">
            <ul class="nav navbar-nav">
                <li><a href="../home">О нас</a></li>
                <li class="active"><a href="/about/">Тесты</a></li>
                <li><a href="/companies">Компании</a></li>
                <sec:authorize access="isAnonymous()">
                    <li><a href="/login">Вход/Регистрация</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="/user">Личный кабинет</a></li>
                    <li><a href="/logout">Выход</a></li>
                </sec:authorize>
            </ul>
        </nav>
    </div>
    <p class="text-center">Результаты тестов</p>
</header>
<div class="container">
    <c:forEach items="${tests}" var="passedTest">
        <div class="row">
            <article>
                <table>
                    <tr>
                        <td>Номер теста : ${passedTest.getTest().getId()}</td>
                        <td>Пользователь : <a href="/user/${passedTest.getPerson().getId()}"><c:if test="${passedTest.getPerson().getFirstName() != null}">${passedTest.getPerson().getFirstName()}</c:if> <c:if test="${passedTest.getPerson().getFirstName() == null}">${passedTest.getPerson().getId()}</c:if> </a></td>
                        <td>Результат : ${passedTest.getResult()}</td>
                    </tr>
                </table>
            </article>
        </div>
    </c:forEach>
</div>
</body>
</html>