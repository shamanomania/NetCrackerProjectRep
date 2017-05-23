<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>Netcracker</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="/css/stylesForCompany.css"%>
    </style>
    <%--<link href="../../css/stylesForCompany.css" rel="stylesheet">--%>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<script type="text/javascript">
    $('#my-tabs a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
</script>
<div class="wrapper container">
    <div class="row text-danger">
        <div class="col-md-3 col-xs-3 ">
            <div class="text-muted left">
                <img src="../../images/avatar.png" alt="netckracker"/>
                <br>
                <p class="text-success">Фамилия: ${loggedUser.getLastName()}</p>
                <p class="text-success">Имя: ${loggedUser.getFirstName()}</p>
                <p class="text-success">e-mail: ${loggedUser.getEmail()}</p>
                <p class="text-success">Адрес: ${loggedUser.getAddress()}</p>
                <button class="btn-block" onclick="location.href='/tests'">Тесты</button>
                <button class="btn-block" onclick="location.href='/testresults'">Результаты тестов</button>
                <button class="btn-block" onclick="location.href='/companies'">Компании</button>
                <button class="btn-block" onclick="location.href='/tests'">Присоединиться к компании</button>
                <button class="btn-block" onclick="location.href='/companyregistration'">Зарегестрировать компанию</button>
                <button class="btn-block" onclick="location.href='/createsertificate'">Создать сертификат</button>
                <button class="btn-block" onclick="location.href='/tests/create'">Создать тест</button>
                <button class="btn-block" onclick="location.href='/'">На главную</button>
            </div>
        </div>
        <div class="col-md-9 col-xs-4"><p class="text-center">Your contribution</p>
            <div id="exTab1">
                <ul class="nav nav-pills">
                    <li class="active">
                        <a href="#1a" data-toggle="tab">Пройденные тесты</a>
                    </li>
                    <li><a href="#2a" data-toggle="tab">Созданные тесты</a>
                    </li>
                    <li><a href="#3a" data-toggle="tab">Созданные сертификаты</a>
                    </li>
                </ul>

                <div class="tab-content clearfix">
                    <div class="tab-pane active" id="1a">
                        <div class="row text-left">
                            <c:forEach items="${testsPassedByUser}" var="passedTest" varStatus="t">
                                <article class="col-xs-5 col-md-5">
                                    <div class="left">Тест
                                        #${passedTest.getTest().getId()}<br>Описание:<br>${passedTest.getTest().getTitle()}
                                        <br>Результат: ${passedTest.result} <br>
                                    </div>
                                    <div class="text-primary">
                                        <button class="btn"
                                                onclick="location.href='/test/${passedTest.getTest().getId()}'">
                                            Перейти к тесту
                                        </button>
                                    </div>
                                </article>
                            </c:forEach>
                            <%--
                            <article class="col-xs-5 col-md-5">Тест<br>Описание:<br>"Lorem ipsum dolor sit amet,
                                consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
                                aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                aliquip ex ea commodo consequat.
                                <button class="btn">Перейти к тесту</button>
                            </article>
                            --%>
                            <%--
                            <article class="col-xs-5 col-md-5">Тест<br>Описание:<br>"Lorem ipsum dolor sit amet,
                                consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
                                aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                aliquip ex ea commodo consequat.
                                <button class="btn">Перейти к тесту</button>
                            </article>
                            --%>
                        </div>
                    </div>
                    <div class="tab-pane" id="2a">
                        <div class="row text-left">
                            <c:forEach items="${createdTests}" var="createdTest" varStatus="t">
                            <article class="col-xs-5 col-md-5">
                                <div class="left">Тест
                                #${createdTest.getId()}<br>Описание:<br>${createdTest.getTitle()}
                                </div>
                                <div class="text-primary">
                                    <button class="btn"
                                            onclick="location.href='/test/${createdTest.getId()}'">
                                        Перейти к тесту
                                    </button>
                                </div>
                            </article>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="tab-pane" id="3a">
                        <div class="row text-left">
                            <article class="col-xs-5 col-md-5">Сертификат<br>Описание:<br>"Lorem ipsum dolor sit amet,
                                consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
                                aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                aliquip ex ea commodo consequat.
                            </article>

                        </div>
                    </div>
                </div>
            </div>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
            <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        </div>
    </div>
</div>
</body>
</html>