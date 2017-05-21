<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
>
<html>
<h:head>
    <title>Netcracker</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="/css/stylesForIndex1.css"%>
    </style>
    <%--<link href="../../css/stylesForIndex1.css" rel="stylesheet">--%>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</h:head>

<h:body>
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

        <div class="row">

            <article class="col-md-3">
                <p>
                    Каков смысл тестирования?
                </p>
                Смысл тестирования заключается в проверке и количественной оценке знаний в области программирования. Мы
                разработали тесты по самым востребованным и популярным языкам и технологиям.
            </article>
            <article class="col-md-3">
                <p>
                    Сертификаты?
                </p>
                <img class="pull-left" src="<c:url value="/images/certificate.png" />" alt="Netcracker">
                За тесты с этим значком выдаётся сертификат
            </article>
            <article class="col-md-3"><p>
                Как проходит тестирование?
            </p>В сертификационных тестах 45 заданий. Каждый участник тестирования получает уникальный набор вопросов,
                выбранных случайным образом из банка заданий. Время на тест определяется на основе анализа данного
                показателя участников, проходивших тестирование и получивших сертификат.
            </article>
            <article class="col-md-3">
                <p>
                    Результаты?
                </p>
                Представители известных компаний на основе ваших пройденных сертифицированных тестов могут связаться с
                вами
                и назначить собеседование, либо сразу же предложить вам выгодную должность.
            </article>
            <article class="col-md-3">
                <p>
                    Кто составляет тесты?
                </p>
                Составителем тестов может стать любой человек, заинтересованный в данной сфере. Достаточно лишь
                зарегестрироваться на нашем сайтом со специальным правом.
            </article>
            <article class="col-md-3"><p>
                Как начать тестирование?
            </p>
                Регистрируйтесь с правом участника, выбирайте наиболее интересные темы, компании и сложности. Всё только
                в
                ваших руках!
            </article>

        </div>
    </div>
    <footer>
        <div class="container">
            <div class="row">

            </div>
        </div>
    </footer>
</h:body>
</html>