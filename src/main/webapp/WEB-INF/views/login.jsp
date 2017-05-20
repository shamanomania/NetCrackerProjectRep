<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>Netcracker</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
    <link href="../../css/stylesForLogin.css" rel="stylesheet">
    <style>
        <%@include file="/css/stylesForLogin.css"%>
    </style>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet"></link>
</head>
<body>

    <div class="container">
        <div class="row">

            <div class="col-md-5 col-xs-5 text-left">

                <form action="login" method="post">
                    <p>
                        <label class="label" for="email">Email address</label>
                    </p>
                    <p><input class="input-lg" type="text" name="email" id="email"/>
                    </p>
                    <p>
                        <label class="label"  for="password">Password</label>
                    </p>
                    <p>
                        <input class="input-lg" type="password" name="password" id="password"/>
                    </p>
                    <p>
                        <label class="label"  for="remember-me">Remember me</label>

                        <input class="checkbox-inline" type="checkbox" name="remember-me" id="remember-me"/>
                    </p>
                    <button class="btn center" type="submit">Sign in</button>
                    <button type="button" class="btn" onclick="location.href='/signup'">Sign up</button>
                </form>


                    <form name="FbLoginForm" action="/facebook/signin" >
                    <button type="submit" class="btn btn-block btn-social btn-facebook">
                        Login using Facebook
                    </button>
                </form>

                <form name="VkLoginForm" action="/hh/signin" >
                    <button type="submit" class="social-icon vk btn">
                       Login using HeadHunter
                    </button>
                </form>

                <form name="googleLoginForm" method="post" action="/google_oauth2_login">
                    <button type="submit" class="btn btn-block btn-social btn-google">
                        Login using Google
                    </button>
                </form>

            </div>
            <div class="col-md-5 col-xs-5 text-center">
                <p class="active">Test your skills!</p>
                <img class="pull-left" src="<c:url value="/images/login.jpg" />" alt="Netcracker">

            </div>
        </div>
    </div>


</body>
</html>