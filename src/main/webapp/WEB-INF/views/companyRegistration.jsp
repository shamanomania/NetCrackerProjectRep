<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
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
            <form:form method="post" commandName="userCreateForm" modelAttribute="userCreateForm">
                <table>
                    <tr>
                        <td class="label">Address:<br><form:input class="input-lg lable" path="email"/></td>

                        <td><span class="error"><form:errors path="email"/></span></td>
                    </tr>
                    <tr>
                        <td class="label"><br>Title:<br><form:password class="input-lg lable" path="password"/></td>

                        <td><span class="error"><form:errors path="password"/></span></td>
                    </tr>

                    <tr>
                        <td><p>
                            <input class="checkbox-inline" type="checkbox" name="remember-me" id="remember-me"/>
                        </p></td>
                    </tr>

                    <tr>
                        <td>
                            <button class="btn center " type="submit">Sign up</button>
                            <button type="button" class="btn" onclick="location.href='/signip'">Sign in</button>
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