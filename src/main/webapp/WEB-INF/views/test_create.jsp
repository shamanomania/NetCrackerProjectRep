<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        <%@include file="/css/stylesForTestCreate.css"%>
    </style>
    <title>Add test page</title>
    <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        <%@include file="/WEB-INF/views/jquery.serializejson.js"%>
    </script>
    <%--<style>
        <%@include file="/WEB-INF/css/style.css"%>
    </style>--%>
    <script type="text/javascript">

        var total = -1;
        var choseTypeFieldID;
        var cChoosen = false;

        function check(){
            if  (checkInput()) {
                var obj = $("#testCreateForm").serializeJSON();
                console.log(obj);
                obj = JSON.stringify(obj);
                console.log(obj);
                $.ajax({
                    type: "POST",
                    url: "/tests/create",
                    contentType: "application/json",
                    dataType: "json",
                    data: obj,
                    success: function (obj) {
                        alert(obj.toString());
                    }
                });
            }else {
                alert("Выбраны не все верные ответы!");
            }
        }

        function checkInput() {
            if ($('div[id^=answer_]:not(:has(:radio:checked))').filter($('div[id^=answer_]:has(input:radio)')).length) {
                console.log($('div[id^=answer_]:not(:has(:radio:checked))').filter($('div[id^=answer_]:has(input:radio)')).length);
                return false;
            } else {
                console.log($('div[id^=answer_]:not(:has(:radio:checked))').filter($('div[id^=answer_]:has(input:radio)')).length);
                return true;
            }
        }

        function addAnswer(field) {
            var choseAddAnswerFieldID = field.name;
            var choseAddAnswerID ;
            choseAddAnswerID = choseAddAnswerFieldID.toString().match(/\d+/g);
            console.log(choseAddAnswerID);

            $('input[name=questions\\['+choseAddAnswerID[0]+'\\]\\[answers\\]\\['+choseAddAnswerID[1]+'\\]]').removeAttr('onclick');
            $('input[name=questions\\['+choseAddAnswerID[0]+'\\]\\[answers\\]\\['+choseAddAnswerID[1]+'\\]]').removeAttr('placeholder');

            $('#answer_'+choseAddAnswerID[0])
                .append(
                    $('<input>')
                        .attr('type','radio')
                        .attr('name','questions['+choseAddAnswerID[0]+'][rightAnswers]')
                        .attr('value',choseAddAnswerID[1])
                );

            ++choseAddAnswerID[1];

            $('#answer_'+choseAddAnswerID[0]).append('<br>');

            console.log(choseAddAnswerID);
            $('<input class="input-lg text-center">')
                .attr('type', 'text')
                .attr('name', 'questions[' + choseAddAnswerID[0] + '][answers][' + choseAddAnswerID[1] + ']')
                .attr('onclick', 'addAnswer(this)')
                .attr('placeholder', 'Add answer')
                .appendTo('#answer_' + choseAddAnswerID[0]);
        }

        function chooseAnswerTypeA(button) {
            choseTypeFieldID = button.name;
            console.log(choseTypeFieldID);
            var questionNumber = choseTypeFieldID.toString().match(/\d+/g);
            console.log(questionNumber);


            $('<div>')
            .attr('id','answer_'+questionNumber)
                .append(
                    $('<p>')
                        .append('Введите варианты ответа, правильный отметьте чекбоксом:')
                )
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type', 'hidden')
                        .attr('name', 'questions[' + questionNumber + '][type]')
                        .attr('value', '1')
                )
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type', 'text')
                        .attr('name', 'questions[' + questionNumber + '][answers][0]')
                )
                .append(
                    $('<input>')
                        .attr('type','radio')
                        .attr('name','questions['+questionNumber+'][rightAnswers]')
                        .attr('value','0')
                ).append('<br>')
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type', 'text')
                        .attr('name', 'questions[' + questionNumber + '][answers][1]')
                )
                .append(
                    $('<input>')
                        .attr('type','radio')
                        .attr('name','questions['+questionNumber+'][rightAnswers]')
                        .attr('value','1')
                ).append('<br>')
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type', 'text')
                        .attr('name', 'questions[' + questionNumber + '][answers][2]')
                        .attr('onclick', 'addAnswer(this)')
                        .attr('placeholder', 'Add answer')
                )
                .appendTo('#question_' + questionNumber);

            $('#answer_type_div' + questionNumber).remove();

        }

        function chooseAnswerTypeB(button) {
            choseTypeFieldID = button.name;
            choseTypeFieldID = choseTypeFieldID.toString().match(/\d+/g); //parseInt(choseTypeFieldID.slice(-1));//have last char(id of button) from string(button name)
            $('<div>')
                .attr('id','answer_'+total)
                .append(
                    $('<p>')
                        .append('Введите верный ответ:')
                )
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type', 'hidden')
                        .attr('name', 'questions[' + total + '][type]')
                        .attr('value', '2')
                )
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type', 'text')
                        .attr('name', 'questions[' + total + '][answers][0]')
                )
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type', 'hidden')
                        .attr('name', 'questions[' + total + '][rightAnswers]')
                        .attr('value', '0')
                )
                .appendTo('#question_' + choseTypeFieldID);

            $('#answer_type_div' + choseTypeFieldID).remove();

        }

        function chooseAnswerTypeC(button) {
            cChoosen = true;
            choseTypeFieldID = button.name;
            choseTypeFieldID = choseTypeFieldID.toString().match(/\d+/g); //parseInt(choseTypeFieldID.slice(-1));//have last char(id of button) from string(button name)
            $('<div>')
                .attr('id', 'answer_' + total)
                .append(
                    $('<p>')
                        .append('Введите верный ответ(то, что должна будет вывести программа пользователя):')
                )
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type', 'hidden')
                        .attr('name', 'questions[' + total + '][type]')
                        .attr('value', '3')
                )
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type', 'text')
                        .attr('name', 'questions[' + total + '][answers][0]')
                )/*.append('<br>')*/
                /*.append(
                    $('<input>')
                        .attr('type', 'text')
                        .attr('name', 'questions[' + total + '][answers][1]')
                )*/
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type', 'hidden')
                        .attr('name', 'questions[' + total + '][rightAnswers]')
                        .attr('value', '0')
                )
                .appendTo('#question_' + choseTypeFieldID);

            $('#answer_type_div' + choseTypeFieldID).remove();
        }

            function addQuestionField () {
            total++;
            var $questionBlock = $('<div>')
                .attr('id','question_'+total)
                .css({lineHeight:'20px'})
                .append('Введите вопрос')
                .append(
                    $('<input class="btn-defaul">')
                        .attr('type', 'button')
                        .attr('value', 'Удалить вопрос')
                        .attr('onclick', '$(\'#question_' + total + '\').remove();')
                )
                .append('</br>')
                .append(
                    $('<input class="input-lg text-center">')
                        .attr('type','text')
                        .attr('name','questions['+total+'][question]')
                );

                var $typeBlock = $('<div>')
                    .attr('id','answer_type_div'+total)
                    .append(
                        $('<p>')
                            .append('Выберите вид ответа:')
                    )
                    .append(
                        $('<input>')
                            .attr('type','radio')
                            .attr('name','answer_type'+total)
                            .attr('value','A')
                            .attr('id','answer_type'+total)
                            .attr('onclick','chooseAnswerTypeA(this)')
                    )
                    .append(
                        'A'
                    )
                    .append(
                        $('<input>')
                            .attr('type','radio')
                            .attr('name','answer_type'+total)
                            .attr('value','B')
                            .attr('id','answer_type'+total)
                            .attr('onclick','chooseAnswerTypeB(this)')
                    )
                    .append(
                        'B'
                    );

            $questionBlock
                .append(
                    $typeBlock
                );

                if (!cChoosen){
                $typeBlock
                    .append(
                        $('<input>')
                            .attr('type','radio')
                            .attr('name','answer_type'+total)
                            .attr('value','C')
                            .attr('id','answer_type'+total)
                            .attr('onclick','chooseAnswerTypeC(this)')
                    )
                    .append(
                        'C'
                    );
                }

            $questionBlock
            .appendTo('#test');
        }

    </script>
</head>
<body>

<header>
    <div><img class="pull-left" src="<c:url value="/images/logo.png" />" alt="Netcracker"></div>

    <div>
        <nav class="navbar" role="navigation">
            <ul class="nav navbar-nav">
                <li><a href="../home">О нас</a></li>
                <li class="active"><a href="/tests">Тесты</a></li>
                <li><a href="/partners/">Компании</a></li>
                <li><a href="/login">Вход/Регистрация</a></li>
                <li><a href="/login">Личный кабинет</a></li>
            </ul>
        </nav>
    </div>
    <p class="text-center">Создайте свой тест</p>
</header>

<div class="container">
    <div class="row">
        <div class="text-center">
        <form:form action="/tests/create" method="post" commandName="testCreateForm" modelAttribute="testCreateForm"
                   name="testCreateForm" id="testCreateForm">
            <div id="test">
                <p>Введите описание теста</p>
                <input type="text" name="OfTest" class="input-lg text-center">
            </div>
            <br/>
            <input class="btn-defaul" type="button" value="Add question" id="add" onclick="addQuestionField()">
            <input class="btn-defaul" type="submit" value="Create test" onclick="check()">
            <input class="btn-defaul" type="button" value="Check" onclick="check()">
        </form:form>
        </div>
    </div>
</div>
</body>
</html>
