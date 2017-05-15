<%--
  Created by IntelliJ IDEA.
  User: Sid775
  Date: 15.05.2017
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IDETry2</title>
    <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
</head>
<body>
<script>

    var TOKEN = '047f8b1993984d03550a8acd891bd114';
    var finish = false;

    var data = {
        "language": 1,
        "sourceCode":'\#include<iostream>\nusing namespace std;\nint main(){\n\tcout << \"Hello!\" << endl;\n\treturn 0;\n}\n'
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
</script>

</body>
</html>
