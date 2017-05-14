<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
        PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:p="http://primefaces.org/ui">
<head>
    <title>Netcracker</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
    <style>
        <%@include file="/css/stylesForLogin.css"%>
    </style>
    <%--<link href="../../css/stylesForLogin.css" rel="stylesheet"></link>--%>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet"></link>
</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-xs-12 text-left">
            <form:form method="post" commandName="userCreateForm" modelAttribute="userCreateForm">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email" /></td>
                    <td><span class="error"><form:errors path="email" /></span></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                    <td><span class="error"><form:errors path="password" /></span></td>
                </tr>
                <tr>
                    <td>Confirm Password:</td>
                    <td><form:password path="passwordRepeated" /></td>
                    <td><span class="error"><form:errors path="passwordRepeated" /></span></td>
                </tr>
                <tr>
                    <td>Role:</td>
                    <form:select size="1" path="role">
                        <form:option value="1">User</form:option>
                        <form:option value="2">Company</form:option>
                    </form:select>
                    <%--<td><form:password path="role" /></td>--%>
                    <td><span class="error"><form:errors path="role" /></span></td>

                </tr>
                <p>
                    <%--<label class="label" for="remember-me">Remember me</label>--%>

                    <input class="checkbox-inline" type="checkbox" name="remember-me" id="remember-me"/>
                </p>
                <button class="btn center" type="submit">Sign up</button>
            </table>

            </form:form>

                <%--<a href="login.jsp">
                <button class="btn">Sign in</button>
            </a>
            <a href="user_create.jsp">
                <button class="btn">Sign up</button>
            </a>--%>

        </div>
        <div class="col-xs-12 text-center">
            <p class="active">Test your skills!</p>

            <img src="http://imgdepo.com/id/10486399.jpg" border="0" alt="!"/>

        </div>
    </div>
</div>

</body>
</html>