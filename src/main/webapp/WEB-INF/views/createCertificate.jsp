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
    <div class="text-danger">
        <div class="text-success">
            <img class="pull-left" src="../../images/logo.png"/><br>
            <p class="pager">
                Сертификат
            </p>
            <p>Описание: <input id="titleOfCertificate" type="text" class="input-lg"/></p>
            <p style="font-size: 15pt">Пожалуйста, отметьте все тесты, которые будет необходимо пройти для получения данного сертификата</p>
            <img class="right" src="../../images/IP.png"/>
            <input type="submit" value="Создать" class="btn-info" onclick="createSertificate()"/>
        </div>
    </div>
    <div class=" row text-muted">
        <button class="col-md-1 col-xs-1" id="mybuttonclick1"><img src="../../images/arrow2.png" alt="Netcracker"></button>
        <c:forEach items="${createdTests}" var="createdTest" varStatus="test">
            <div id="${createdTest.getId()}" onclick="chooseTest(this)"><article class="col-xs-2 col-md-2 text-center" id="article_${createdTest.getId()}"><%--<button  class="btn"><img src="../../images/x.png" alt="Netcracker"></button >--%><br>Тест: ${createdTest.getId()}<br> ${createdTest.getTitle()}<%--<button  class="btn-default"><img src="../../images/yes.png" alt="Netcracker"></button>--%></article></div>
            <script>
                var index = ${test.index};
                if (index > 3){
                    $('#article_'+${createdTest.getId()})
                        .addClass("a");
                }
            </script>
        </c:forEach>
        <%--<article class="col-xs-2 col-md-2 text-center" id="p1">Тест: тест1</article>
        <article class="col-xs-2 col-md-2 text-center" id="2">Тест: тест2</article>
        <article class="col-xs-2 col-md-2 text-center" id="3">Тест: тест3</article>
        <article class="col-xs-2 col-md-2 text-center" id="4" >Тест: тест4</article>
        <article class="col-xs-2 col-md-2 text-center a" id="5" >Тест: тест5</article>
        <article class="col-xs-2 col-md-2 text-center a" id="6">Тест: тест6</article>
        <article class="col-xs-2 col-md-2 text-center a" id="7">Тест: тест7</article>
        <article class="col-xs-2 col-md-2 text-center a" id="8">Тест: тест8</article>
        <article class="col-xs-2 col-md-2 text-center a" id="9" >Тест: тест9</article>
        <article class="col-xs-2 col-md-2 text-center a" id="10">Тест: тест10</article>
        <article class="col-xs-2 col-md-2 text-center a" id="11">Тест: тест11</article>
        <article class="col-xs-2 col-md-2 text-center a" id="12">Тест: тест12</article>--%>
        <button class="col-md-1 col-xs-1" id="mybuttonclick2" id="9"><img src="../../images/arrow.png" alt="Netcracker"></button>
    </div>
</div>

<script type="text/javascript">

    $(document).ready( function() {
        var ar=$(".text-muted article");
        var length=ar.size();
        var i=0;
        $("#mybuttonclick2").click(function(){
            if (i < length-4){
                $(ar[i]).hide(100);
                $(ar[i+1]).fadeIn(300);
                $(ar[i+2]).fadeIn(300);
                $(ar[i+3]).fadeIn(300);
                $(ar[i+4]).fadeIn(300);
                i=i+1;

            }
            return false;

        });
        $("#mybuttonclick1").click(function()
        {
            if (i > 0){
                $(ar[i-1]).fadeIn(100);
                $(ar[i]).fadeIn(100);
                $(ar[i+1]).fadeIn(100);
                $(ar[i+2]).fadeIn(100);
                $(ar[i+3]).fadeOut(100);
                i--;
            }
            return false;
        });
    });

</script>
<script>
    'use strict';
    let map = new Map();
    function chooseTest(div) {
        map.set(div.id,div.id);
        console.log(map);
        $('#article_'+div.id)
            .prepend('<button class="btn" id="unselectBtn_'+ div.id +'" onclick="unselectTest('+div.id+')"><img src="../../images/x.png" alt="Netcracker"></button >');
        $('#article_'+div.id)
            .append('<img id="choosedImg_'+ div.id +'" src="../../images/yes.png" alt="Netcracker" class="tab-pane">');
        $('#'+div.id)
            .removeAttr('onclick');
    }
    
    function unselectTest(id) {
        console.log(id);
        map.delete(id.toString());
        console.log(map);
        $('#unselectBtn_'+ id.toString())
            .remove();
        $('#choosedImg_'+ id.toString())
            .remove();
        setTimeout(function(){$('#'+ id.toString())
            .attr('onclick','chooseTest(this)')},1000);

    }


    function createSertificate() {
        map = strMapToObj(map);
        map = objToArray(map);
        var object = {"tests" : map, "title" : $('#titleOfCertificate').val()};
        console.log(object);
        object = JSON.stringify(object);
        console.log(object);
        $.ajax({
            type: "POST",
            url: "/createcertificate",
            contentType: "application/json",
            //dataType: "json",
            data: object,
            success: function (obj) {
                location.href='/user';
            }
        });
    }

    function strMapToObj(strMap) {
        let obj = Object.create(null);
        for (let [k,v] of strMap) {
            // We don’t escape the key '__proto__'
            // which can cause problems on older engines
            obj[k] = v;
        }
        return obj;
    }

    function objToArray(object) {
        var array = [];
        for (var index in object){
            array.push(object[index]);
        }
        return array;
    }
</script>
</body>
</html>