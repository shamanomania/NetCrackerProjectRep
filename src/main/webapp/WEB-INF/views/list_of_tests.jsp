<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                    <li><a href="/">О нас</a></li>
                    <li class="active"><a href="/tests">Тесты</a></li>
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
        <div class="text-center">Are you ready for testing?</div>

        <div class="row">
            <%--<form:form commandName="testsForm" modelAttribute="testsForm">--%>
                <c:forEach items="${tests}" var="passedTest">
                    <article class="col-md-3 col-xs-4">
                        <div class="left">
                        <div class="text-hide">
                            <img src="/myImage/imageDisplay?id=${passedTest.getImage().getId()}" class="img-responsive" alt="Netcracker">
                        </div>
                        <div class="text-info">
                            <p>
                                Описание:
                            </p>
                            ${passedTest.getTitle()}<br>
                        </div>
                        </div>
                            <form method="get" action="/test/${passedTest.getId()}">
                                <div class="text-primary">
                                    <button class="btn-default">Пройти тест <c:if test="${passedTest.getCertificates().size() != 0}"><img src="<c:url value="/images/certificate.png" />" class="img-responsive" alt="Netcracker" ></c:if></button>
                                </div>
                            </form>

                    </article>
                </c:forEach>
            <%--</form:form>--%>
        </div>
    </div>
</body>
</html>