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

        function passTest() {
            var obj = $("#testForm").serializeJSON();
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
                                    .append(
                                        $('<p>')
                                            .append(
                                                "Выбранный ответ"
                                            )
                                    );
                            }

                            $('#aAnswer_'+ i +'_'+response.answers[i].id[1])
                                .append(
                                    $('<p>')
                                        .append(
                                            "Верный ответ"
                                        )
                                );
                        }else {
                            $('#bAnswer_'+i)
                                .append(
                                    $('<p>')
                                        .append(
                                            response.answers[i].id
                                        )
                                )
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
            <div id="answer_${iterator.index}">
                <c:if test="${i.getType() eq '1' }">
                    <div>${i.getTitle()}</div>
                    <c:forEach items="${i.getAnswers()}" var="answer" varStatus="innerIterator">
                        <div id="aAnswer_${iterator.index}_${innerIterator.index}"><input type="radio" name="answers[${iterator.index}]" id="answers[${iterator.index}]" value="${answer.getTitle()}"/>${answer.getTitle()}</div>
                    </c:forEach>
                </c:if>

                <c:if test="${i.getType() eq '2' }">
                    <div>${i.getTitle()}</div>
                    <div id="bAnswer_${iterator.index}"><input type="text" name="answers[${iterator.index}]" /></div>
                </c:if>
            </div>
            </c:forEach>
        <button class="btn center" type="submit" onclick="passTest()">End test</button>
        <button type="button" onclick="passTest()" >Pass test</button>
    </form:form>
</body>
</html>