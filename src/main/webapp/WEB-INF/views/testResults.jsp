<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <li class="active"><a href="/tests">Тесты</a></li>
                <li><a href="/partners/">Компании</a></li>
                <li><a href="/login">Вход/Регистрация</a></li>
                <li><a href="/login">Личный кабинет</a></li>
            </ul>
        </nav>
    </div>
    <p class="text-center">Результаты тестов</p>
</header>
<div class="container">
    <c:forEach items="${tests}" var="passedTest">
        ${passedTest.testId}
    </c:forEach>
    <div class="row">
        <article>
            <table>
                <tr>
                    <td>Название теста : тест1</td>
                    <td>Пользователь : <a>Иванов Иван Иванович</a></td>
                    <td>Результат : 5/5</td>
                </tr>
            </table>
        </article>

    </div>
    <div class="row">
        <article>
            <table>
                <tr>
                    <td>Название теста : тест1</td>
                    <td>Пользователь : <a>Иванов Иван Иванович</a></td>
                    <td>Результат : 5/5</td>
                </tr>
            </table>
        </article>

    </div>
    <div class="row">
        <article>
            <table>
                <tr>
                    <td>Название теста : тест1</td>
                    <td>Пользователь : <a>Иванов Иван Иванович</a></td>
                    <td>Результат : 5/5</td>
                </tr>
            </table>
        </article>

    </div>
    <div class="row">
        <article>
            <table>
                <tr>
                    <td>Название теста : тест1</td>
                    <td>Пользователь : <a>Иванов Иван Иванович</a></td>
                    <td>Результат : 5/5</td>
                </tr>
            </table>
        </article>

    </div>
    <div class="row">
        <article>
            <table>
                <tr>
                    <td>Название теста : тест1</td>
                    <td>Пользователь : <a>Иванов Иван Иванович</a></td>
                    <td>Результат : 5/5</td>
                </tr>
            </table>
        </article>

    </div>
    <div class="row">
        <article>
            <table>
                <tr>
                    <td>Название теста : тест1</td>
                    <td>Пользователь : <a>Иванов Иван Иванович</a></td>
                    <td>Результат : 5/5</td>
                </tr>
            </table>
        </article>

    </div>
    <div class="row">
        <article>
            <table>
                <tr>
                    <td>Название теста : тест1</td>
                    <td>Пользователь : <a>Иванов Иван Иванович</a></td>
                    <td>Результат : 5/5</td>
                </tr>
            </table>
        </article>

    </div>
</div>
</body>
</html>