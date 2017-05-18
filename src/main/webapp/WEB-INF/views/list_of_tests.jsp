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
        <%@include file="/css/stylesForTests.css"%>
    </style>
    <%--<link href="../../css/stylesForTests.css" rel="stylesheet">--%>
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
                    <li><a href="/partners/">Компании</a></li>
                    <li><a href="/login">Вход/Регистрация</a></li>
                    <li><a href="/login">Личный кабинет</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <div class="wrapper container">
        <div class="text-center">Are you ready for testing?</div>

        <div class="row">
            <%--<form:form commandName="testsForm" modelAttribute="testsForm">--%>
                <c:forEach items="${tests}" var="test">

                    <article class="col-md-3 col-xs-4">
                        <div class="text-hide"><img src="<c:url value="/images/apple.png" />" class="img-responsive" alt="Netcracker"></div>
                        <div class="text-info">
                            <p>
                                Описание:
                            </p>
                            ${test.getTitle()}<br>
                            <form method="get" action="/test/${test.getId()}"><button class="btn-default">Пройти тест <img src="<c:url value="/images/certificate.png" />" class="img-responsive" alt="Netcracker" ></button></form></div>
                    </article>
                </c:forEach>
            <%--</form:form>--%>
            <article class="col-md-3 col-xs-4">
                <div class="text-hide"><img src="<c:url value="/images/apple.png" />" class="img-responsive" alt="Netcracker"></div>
                <div class="text-info">
                <p>
                   Описание:
                </p>
                  Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diem nonummy
                    nibh euismod tincidunt ut lacreet dolore magna aliguam erat volutpat.<br>
                <button class="btn-default">Пройти тест <img src="<c:url value="/images/certificate.png" />" class="img-responsive" alt="Netcracker"></button></div>
            </article>
            <article class="col-md-3 col-xs-4">
                <div class="text-hide"><img src="../../img/android.png" class="img-responsive" alt="Netcracker"></div>
                <div class="text-info">
                <p>
                    Описание:
                </p>
                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diem nonummy
                    nibh euismod tincidunt ut lacreet dolore magna aliguam erat volutpat.<br>
                    <button class="btn-default">Пройти тест <img src="../../img/certificate.png" class="img-responsive" alt="Netcracker"></button></div>
            </article>
            <article class="col-md-3 col-xs-4">
                <div class="text-hide"><img src="../../img/ruby.png" class="img-responsive" alt="Netcracker"></div>
                <div class="text-info"><p>

                    Описание:
            </p>  Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diem nonummy
                    nibh euismod tincidunt ut lacreet dolore magna aliguam erat volutpat.<br>
                    <button class="btn-default">Пройти тест <img src="../../img/certificate.png" class="img-responsive" alt="Netcracker"></button></div>
            </article>
            <article class="col-md-3 col-xs-4">
                <div class="text-hide"><img src="../../img/css.png" class="img-responsive" alt="Netcracker"></div>
                <div class="text-info">
                <p>
                    Описание:
                </p>
                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diem nonummy
                    nibh euismod tincidunt ut lacreet dolore magna aliguam erat volutpat.<br>
                    <button class="btn-default">Пройти тест <img src="../../img/certificate.png" class="img-responsive" alt="Netcracker"></button></div>
            </article>
            <article class="col-md-3 col-xs-4">
                <div class="text-hide"><img src="../../img/java.png" class="img-responsive" alt="Netcracker"></div>
                <div class="text-info">
                <p>
                    Описание:
                </p>
                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diem nonummy
                    nibh euismod tincidunt ut lacreet dolore magna aliguam erat volutpat.<br>
                    <button class="btn-default">Пройти тест <img src="../../img/certificate.png" class="img-responsive" alt="Netcracker"></button></div>
            </article>
            <article class="col-md-3 col-xs-4">
                <div class="text-hide"><img src="../../img/ruby.png" class="img-responsive" alt="Netcracker"></div>
                <div class="text-info">
                <p> Описание:
            </p>
                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diem nonummy
                    nibh euismod tincidunt ut lacreet dolore magna aliguam erat volutpat.<br>
                    <button class="btn-default">Пройти тест <img src="../../img/certificate.png" class="img-responsive" alt="Netcracker"></button></div>
            </article>

        </div>
    </div>
</body>
</html>