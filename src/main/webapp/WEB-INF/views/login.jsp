<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">

<head>
    <title>Netcracker</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
    <!--<link href="../../css/stylesForLogin.css" rel="stylesheet"></link>-->
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet"></link>
</head>
<body>

    <div class="container">
        <div class="row">

            <div class="col-xs-12 text-left">
                <a href="login.jsp"> <button class="btn">Sign in</button></a>
                <a href="user_create.jsp"> <button class="btn">Sign up</button></a>
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
                </form>

            </div>
            <div class="col-xs-12 text-center">
                <p class="active">Test your skills!</p>

                <img src="http://imgdepo.com/id/10486399.jpg" border="0" alt="!"/>

            </div>
        </div>
    </div>


</body>
</html>