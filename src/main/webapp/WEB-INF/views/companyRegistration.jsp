<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
        PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Netcracker</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <style>
        <%@include file="/css/stylesForLogin.css"%>
    </style>
    <%--<link href="../../css/stylesForLogin.css" rel="stylesheet"></link>--%>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-xs-5 col-md-5 text-left">
            <form:form method="post" commandName="companyCreateForm" modelAttribute="companyCreateForm">
                <table>
                    <tr>
                        <td class="label">Название:<br><form:input class="input-lg lable" path="name"/></td>

                        <td><span class="error"><form:errors path="name"/></span></td>
                    </tr>
                    <tr>
                        <td class="label">Описание:<br><form:input class="input-lg lable" path="title"/></td>

                        <td><span class="error"><form:errors path="title"/></span></td>
                    </tr>
                    <tr>
                        <td class="label"><br>Адрес:<br><form:input class="input-lg lable" path="address"/></td>

                        <td><span class="error"><form:errors path="address"/></span></td>
                    </tr>

                    <tr>
                        <td>
                            <button class="btn center " type="submit">Create</button>
                            <%--<button type="button" class="btn" onclick="location.href='/signip'">Sign in</button>--%>
                        </td>
                    </tr>
                </table>

            </form:form>

            <%--<a href="login.jsp">
            <button class="btn">Sign in</button>
        </a>
            <a href="user_create.jsp">
                <button class="btn">Sign up</button>
            </a>--%>

        </div>
        <div class="col-xs-5 col-md-5 text-center">
            <p class="active">Test your skills!</p>

            <img class="pull-left" src="<c:url value="/images/login.jpg" />" alt="Netcracker">

        </div>
    </div>
</div>

</body>
</html>