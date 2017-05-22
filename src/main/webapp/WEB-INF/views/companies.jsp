<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Netcracker</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="/css/stylesForCompanies.css"%>
    </style>
    <%--<link href="../../css/stylesForCompanies.css" rel="stylesheet">--%>
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
                <li><a href="/login">Вход/Регистрация</a></li>
                <li><a href="/login">Личный кабинет</a></li>
            </ul>
        </nav>
    </div>
</header>

<div class="wrapper container">
    <div class="text-center">Наши компании</div>

    <div class="row">
        <%--<form:form commandName="testsForm" modelAttribute="testsForm">--%>
        <c:forEach items="${companies}" var="company">

            <article class="col-md-3 col-xs-4">
                <div class="left">
                    <div class="text-hide"><img src="<c:url value="/images/apple.png" />" class="img-responsive"
                                                alt="Netcracker"></div>
                    <div class="text-info">
                        <p>
                            Описание:
                        </p>
                            ${company.getTitle()}<br>
                    </div>
                </div>
                <form method="get" action="/company/${company.getId()}">
                    <div class="text-primary">
                        <button class="btn-default">Информация</button>
                    </div>
                </form>
            </article>
        </c:forEach>
        <%--</form:form>--%>
    </div>
</div>
</body>
</html>