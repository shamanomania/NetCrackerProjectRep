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
        <%@include file="/css/stylesForUser.css"%>
    </style>
    <%--
    <link href="../../css/stylesForUser.css" rel="stylesheet">
    --%>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<script type="text/javascript">
    $('#my-tabs b').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
</script>
<div class="wrapper container">
    <div class="row text-danger">
        <div class="col-md-3 col-xs-3 left">
            <div class="text-muted left">
                <img src="../../images/avatar.png" alt="netckracker"/>
                <br>
                <p class="text-success">Личные данные: </p>

                <div style="display: -webkit-inline-box;">
                    <p class="text-success" id="lastNameField">Фамилия:</p>
                    <input class="right" value="${loggedUser.getLastName() }"/>
                    <p>
                        <input class="input-lg" type="hidden" name="" id="lastName"
                               value="${loggedUser.getLastName()}"/>
                    </p>
                </div>

                <div style="display: -webkit-inline-box;">
                    <p class="text-success" id="firstNameField">Имя:</p>
                    <input class="right" value="${loggedUser.getFirstName()}"/>
                    <p>
                        <input class="input-lg" type="hidden" name="" id="firstName"
                               value="${loggedUser.getFirstName()}"/>
                    </p>
                </div>

                <div style="display: -webkit-inline-box;">
                    <p class="text-success" id="emailField">e-mail:</p>
                    <input class="right" value="${loggedUser.getEmail()}"/>
                    <p>
                        <input class="input-lg" type="hidden" name="" id="email" value="${loggedUser.getEmail()}"/>
                    </p>
                </div>

                <div style="display: -webkit-inline-box;">
                    <p class="text-success" id="addressField">Адрес:</p>
                    <input class="right" value="${loggedUser.getAddress()}"/>
                    <p>
                        <input class="input-lg" type="hidden" name="" id="address" value="${loggedUser.getAddress()}"/>
                    </p>
                </div>


                <input class="btn-info" onclick="changeInfo()" type="button" value="Редактировать информацию"/>
                <button class="btn-info" onclick="saveChangeInfo()">Редактировать информацию</button>
                <script type="application/javascript">
                    function changeInfo() {

                    }

                    function saveChangeInfo() {

                    }
                </script>
                <button class="btn-block" onclick="location.href='/tests'">Тесты</button>
                <button class="btn-block" onclick="location.href='/companies'">Компании</button>
                <button class="btn-block" onclick="location.href='/'">На главную</button>
            </div>
        </div>
        <div class="col-md-9 col-xs-4"><p class="text-center">Your contribution</p>
            <div id="exTab1">
                <ul class="nav nav-pills">
                    <li class="active">
                        <a href="#1a" data-toggle="tab">Пройденные тесты</a>
                    </li>
                    <li><a href="#2a" data-toggle="tab">Полученные сертификаты</a>
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
                            <c:forEach items="${loggedUser.getCertificates()}" var="getedCertificate" varStatus="t">
                                <article class="col-xs-5 col-md-5">
                                    <div class="left">Сертификат
                                        #${getedCertificate.getId()}<br>Описание:<br>${getedCertificate.getTitle()}
                                    </div>
                                    <div class="text-primary">
                                        <button class="btn"
                                                onclick="location.href='/certificate/${getedCertificate.getId()}'">
                                            Перейти к сертификату
                                        </button>
                                    </div>
                                </article>
                            </c:forEach>
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