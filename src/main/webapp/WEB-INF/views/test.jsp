<%--
  Created by IntelliJ IDEA.
  User: Sid775
  Date: 01.05.2017
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        <%@include file="/WEB-INF/views/jquery.serializejson.js"%>
    </script>
    <script>
        var id;

        function checkInput() {

            if ($('div[name^=answer_]:not(:has(:radio:checked))').length) {
                alert("At least one group is blank");
            }
        }

        function getCPartAnswer() {
            var TOKEN = '047f8b1993984d03550a8acd891bd114';
            var finish = false;

            var data = {
                "language": 10,
                "sourceCode":$('#cPartCode').val()/*'\#include<iostream>\nusing namespace std;\nint main(){\n\tcout << \"Hello!\" << endl;\n\treturn 0;\n}\n'*/
            };

            var load = function(){
                var extra = '';
                if( finish ){
                    extra = '&withSource=1&withInput=1&withOutput=1&withStderr=1&withCmpinfo=1'
                }
                var url = 'http://dde71fd4.compilers.sphere-engine.com/api/3/submissions/' + sId + '/?access_token=' + TOKEN + extra;
                $.ajax({url: url,
                    type: 'get',
                    dataType: 'json',
                    success: function(data){

                        if(!finish){
                            if(data['status'] != 0){
                                setTimeout(load, 1000);
                            } else {
                                finish = true;
                                setTimeout(load, 1);
                            }
                        } else {
                            console.log(JSON.stringify(data));
                            $('#cPartResult')
                                .attr('value',data.output);
                            console.log()
                            passTest();
                        }
                    },
                    error: function(data){
                        console.log('connect error');
                    }
                });

            };

            var url = 'http://api.compilers.sphere-engine.com/api/3/submissions/?access_token=' + TOKEN;
            $.ajax({url: url,
                type: 'post',
                data: data,
                dataType: 'json',
                success: function(data){
                    sId = data['id'];
                    console.log(sId);
                    load();
                },
                error: function(data){
                    console.log("connect error");
                }
            });
        }

        function passTest() {

            var obj = $("#testForm").serializeJSON();
            console.log(obj);
            checkInput();
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
                success: function(response) {
                    console.log("test finished " + response.answers[0].id);
                    for (var i =0; i <response.answers.length; i++){
                        /*$('#answer_'+i)
                            .append(
                                $('<p>')
                                    .append(
                                        response.answers[i].id
                                    )
                            )*/
                        if (response.answers[i].id.length <= 3){
                            response.answers[i].id = response.answers[i].id.toString().match(/\d+/g);
                            if (response.answers[i].id[0] != response.answers[i].id[1]){
                                $('#aAnswer_'+ i +'_'+response.answers[i].id[0])
                                    /*.append(
                                        $('<p>')*/
                                            /*.append(
                                                "Выбранный ответ"
                                            )*/
                                    .after("Выбранный ответ");
//                                    );
                            }

                            $('#aAnswer_'+ i +'_'+response.answers[i].id[1])
                                /*.append(
                                    $('<p>')*/
                                        /*.append(
                                            "Верный ответ"
                                        )*/
                                .after("Верный ответ");
//                                );
                        }else {
                            $('#bAnswer_'+i)
                                .append(
                                    $('<p>')
                                        .append(
                                            response.answers[i].id
                                        )
                                );
                            $('#cAnswer_'+i+'_2')
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
                }});
        }
    </script>
</head>
<body>
    <form:form method="post" commandName="testForm" modelAttribute="testForm">
        <script>id = ${test.getId()};</script>
        <input type="hidden" name="id" value="${id}">
        <c:forEach var="i" items="${test.getQuestions()}" varStatus="iterator">
            <div id="answer_${iterator.index}" name="answer_${iterator.index}">
                <c:if test="${i.getType() eq '1' }">
                    <div>${i.getTitle()}</div>
                    <c:forEach items="${i.getAnswers()}" var="answer" varStatus="innerIterator">
                        <%--<div id="aAnswer_${iterator.index}_${innerIterator.index}">--%><label id="aAnswer_${iterator.index}_${innerIterator.index}"><input type="radio" name="answers[${iterator.index}]" id="answers[${iterator.index}]" <%--id="aAnswer_${iterator.index}_${innerIterator.index}"--%> value="${answer.getTitle()}"/>${answer.getTitle()}</label> <br><%--</div>--%>
                    </c:forEach>
                </c:if>

                <c:if test="${i.getType() eq '2' }">
                    <div>${i.getTitle()}</div>
                    <div id="bAnswer_${iterator.index}"><input type="text" name="answers[${iterator.index}]" /></div>
                </c:if>

                <c:if test="${i.getType() eq '3'}">
                    <div>${i.getTitle()}</div>
                    <div id="cAnswer_${iterator.index}_1"><input type="text" name="cPartResult" id="cPartCode" <%--value="${i.getAnswers().get(0).getTitle()}"--%>/></div>
                    <%--<script>
                        $('#cAnswer_${iterator.index}_1')
                            .attr('value',${i.getAnswers().get(0).getTitle()})
                    </script>--%>
                    <div id="cAnswer_${iterator.index}_2"><input type="text" name="answers[${iterator.index}]" id="cPartResult"/></div>
                </c:if>
            </div>
            </c:forEach>
        <button class="btn center" type="submit" onclick="passTest()">End test</button>
        <button type="button" onclick="getCPartAnswer()" >Pass test</button>
    </form:form>
</body>
</html>
