<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<head>
    <title>Netcracker</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <style>
        <%@include file="/css/stylesForLogin.css"%>
    </style>
    <%--<link href="../../css/stylesForLogin.css" rel="stylesheet"></link>--%>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet"/>
    <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script src="http://www.xiper.net/examples/js-plugins/forms/autoresize/js/autoresize.jquery.js"></script>


    <script type="text/javascript">
        <%@include file="/WEB-INF/views/jquery.serializejson.js"%>

    </script>
    <script type="text/javascript">
        function upload() {
//            $(document).on("click", "#upload", function() {
            var file_data = $("#avatar").prop("files")[0];   // Getting the properties of file from file field
            var form_data = new FormData();                  // Creating object of FormData class
            form_data.append("file", file_data)              // Appending parameter named file with properties of file_field to form_data
            form_data.append("test_id", 123)                 // Adding extra parameters to form_data
            $.ajax({
                url: "/uploadImage1",
//                    dataType: 'script',
                cache: false,
                contentType: false,
                processData: false,
                data: form_data,                         // Setting the data attribute of ajax with file_data
                type: 'post',
                success: function () {
                    console.log("картинка загружена");
                    $('#form').submit();
//                        }
                },
                error: function () {
                    console.log("error!")
                }
            });
        }
//            });
        $("document").ready(function(){

            $("#upload").change(function() {
                alert('changed!');
            });


        });
        var input = document.querySelector("input[type='file']");
        input.onchange = function () {
            upload();
        }

    </script>

</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-xs-5 col-md-5 text-left">
            <form:form method="post" commandName="companyCreateForm" modelAttribute="companyCreateForm" id="form">
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
                        <td class="label"><br>Загрузить картинку:</br>
                        <script type="application/javascript">
                            function chooseFile() {
                                $('#avatar').click();
                            }
                        </script>
                        <input type="button" onclick="chooseFile()" value="Загрузить картинку" class="input-sm"/>

                        <label for="avatar">
                            <span aria-hidden="true"></span>
                            <input id="avatar" name="avatar" type="file" value="Загрузить файл" style="display:none">
                        </label>

                        </td>
                        <%--<td class="label"><br>Загрузить картинку:</br><input id="avatar" type="file" name="avatar" id="upload" value="Загрузить файл" /></td>--%>
                    </tr>


                    <tr>
                        <td>
                            <button class="btn center " type="button" onclick="upload()">Create</button>
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