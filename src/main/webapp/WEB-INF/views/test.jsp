<%--
  Created by IntelliJ IDEA.
  User: Sid775
  Date: 01.05.2017
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <style>
        <%@include file="/css/stylesForTestCreate.css"%>
    </style>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        <%@include file="/WEB-INF/views/jquery.serializejson.js"%>
    </script>
    <script>
        var id;
        var testHaveCType = false;

        function passTest() {
            var obj = $("#testForm").serializeJSON();
            console.log(obj);
            if (checkInput()) {
                blockInput();
                $('#finishButton')
                    .attr('type','hidden');
                $('#redirectButton')
                    .attr('type','button');
                if (testHaveCType) {
                    passTestWithC();
                } else {
                    passTestWithoutC();
                }
            } else {
                alert("Выбраны ответы не на все вопросы!");
            }
        }

        function blockInput() {
            $(':input:radio').attr('onclick', 'return false;');
            $(':text').prop('readonly', true);
        }

        function checkInput() {
            if ($('div[name^=answer_]:not(:has(:radio:checked))').filter($('div[name^=answer_]:has(input:radio)')).length) {
                console.log($('div[name^=answer_]:not(:has(:radio:checked))').filter($('div[name^=answer_]:has(input:radio)')).length);
                return false;
            } else {
                console.log($('div[name^=answer_]:not(:has(:radio:checked))').filter($('div[name^=answer_]:has(input:radio)')).length);
                return true;
            }
        }

        function passTestWithC() {
            var TOKEN = '047f8b1993984d03550a8acd891bd114';
            var finish = false;

            var data = {
                "language": 10,
                "sourceCode": $('#cPartCode').val()
            };

            var loadIDEResult = function () {
                var extra = '';
                if (finish) {
                    extra = '&withSource=1&withInput=1&withOutput=1&withStderr=1&withCmpinfo=1'
                }
                var url = 'http://dde71fd4.compilers.sphere-engine.com/api/3/submissions/' + sId + '/?access_token=' + TOKEN + extra;
                $.ajax({
                    url: url,
                    type: 'get',
                    dataType: 'json',
                    success: function (data) {

                        if (!finish) {
                            if (data['status'] != 0) {
                                setTimeout(loadIDEResult, 1000);
                            } else {
                                finish = true;
                                setTimeout(loadIDEResult, 1);
                            }
                        } else {
                            console.log(JSON.stringify(data));
                            $('#cPartResult')
                                .attr('value', data.output);
                            console.log()
                            passTestWithoutC();
                        }
                    },
                    error: function (data) {
                        console.log('connect error');
                    }
                });

            };

            var url = 'http://api.compilers.sphere-engine.com/api/3/submissions/?access_token=' + TOKEN;
            $.ajax({
                url: url,
                type: 'post',
                data: data,
                dataType: 'json',
                success: function (data) {
                    sId = data['id'];
                    console.log(sId);
                    loadIDEResult();
                },
                error: function (data) {
                    console.log("connect error");
                }
            });
        }

        function passTestWithoutC() {
            checkInput();
            var obj = $("#testForm").serializeJSON();
            console.log(obj);
            obj = JSON.stringify(obj);
            console.log(obj);

            var answersF = [];
            var correctAnswersF = [];

            $.ajax({
                type: "POST",
                url: "/test/${id}",
                contentType: "application/json",
                dataType: "json",
                data: obj,
                success: function (response) {
                    console.log("test finished " + response.answers[0].id);
                    for (var i = 0; i < response.answers.length; i++) {
                        if (response.answers[i].id.length <= 3) {
                            response.answers[i].id = response.answers[i].id.toString().match(/\d+/g);
                            if (response.answers[i].id[0] != response.answers[i].id[1]) {
                                $('#aAnswer_' + i + '_' + response.answers[i].id[0])
                                    .after('<img src="../../images/x.png" class="img-rounded">');
                            }

                            $('#aAnswer_' + i + '_' + response.answers[i].id[1])
                                .after('<img src="../../images/yes.png" class="img-rounded">');
                        } else {
                            $('#bAnswer_' + i)
                                .append(
                                    $('<p>')
                                        .append(
                                            response.answers[i].id
                                        )
                                );
                            $('#cAnswer_' + i + '_2')
                                .append(
                                    $('<p>')
                                        .append(
                                            response.answers[i].id
                                        )
                                );
                        }

                        answersF.push(response.answers[i].id);
                    }
                    console.log(answersF);
                }
            });
        }
    </script>
</head>
<body>
<header>
    <div><img class="pull-left" src="<c:url value="/images/logo.png" />" alt="Netcracker"></div>

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
<div class="container">
    <div class="row">
        <div class="text-left">
            <p class="text-center left">Тест</p>
            <form:form method="post" commandName="testForm" modelAttribute="testForm">
                <script>id = ${test.getId()};</script>
                <input type="hidden" name="id" value="${id}">
                <c:forEach var="i" items="${test.getQuestions()}" varStatus="iterator">
                    <div id="answer_${iterator.index}" name="answer_${iterator.index}">
                        <c:if test="${i.getType() eq '1' }">
                            <div>${i.getTitle()}</div>
                            <c:forEach items="${i.getAnswers()}" var="answer" varStatus="innerIterator">
                                <label id="aAnswer_${iterator.index}_${innerIterator.index}"><input type="radio"
                                                                                                    name="answers[${iterator.index}]"
                                                                                                    id="answers[${iterator.index}]"
                                                                                                    value="${answer.getTitle()}"/>${answer.getTitle()}
                                </label> <br>
                            </c:forEach>
                        </c:if>

                        <c:if test="${i.getType() eq '2' }">
                            <div>${i.getTitle()}</div>
                            <div id="bAnswer_${iterator.index}"><input class="input-lg text-center" type="text"
                                                                       name="answers[${iterator.index}]"/>
                            </div>
                        </c:if>

                        <c:if test="${i.getType() eq '3'}">
                            <div>${i.getTitle()}</div>
                            <div id="cAnswer_${iterator.index}_1"><input type="text" class="input-lg text-center"
                                                                         name="cPartResult" id="cPartCode"/>
                            </div>
                            <div id="cAnswer_${iterator.index}_2"><input type="text" class="input-lg text-center"
                                                                         name="answers[${iterator.index}]"
                                                                         id="cPartResult" hidden/></div>
                            <script>
                                testHaveCType = true;
                            </script>
                        </c:if>
                    </div>
                </c:forEach>
                <script>
                    console.log(testHaveCType);
                </script>
                <div class="text-center">
                    <input type="button" id="finishButton" class="btn-defaul text-center" onclick="passTest()" value="Завершить" />
                    <input type="hidden" id="redirectButton" class="btn-defaul text-center" onclick="location.href='/user'" value="Вернуться в личный кабинет" />
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>



