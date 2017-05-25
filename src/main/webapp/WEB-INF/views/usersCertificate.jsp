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
    <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="/css/stylesForCertificate.css"%>
    </style>
    <%--
    <link href="../../css/stylesForCertificate.css" rel="stylesheet">
    --%>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <![endif]-->
</head>
<body>
<header>
    <!-- <div>  img class="pull-left" src="<c:url value="/images/logo.png" />" alt="Netcracker"></div>!-->
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
</header>

<div class="wrapper container">
    <div class="text-danger">
        <div class="text-success">
            <img class="pull-left" src="../../images/logo.png"/><br>
            <p class="pager">
                Сертификат #${certificate.getId()}
            </p>
            <p>${certificate.getTitle()}</p>
            <img class="right" src="../../images/IP.png"/>
            <%--<input type="submit" value="Создать" class="btn-info" onclick="createSertificate()"/>--%>
        </div>
    </div>
</div>


</body>
</html>