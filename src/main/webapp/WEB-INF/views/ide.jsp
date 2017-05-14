<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:p="http://primefaces.org/ui">
<head>
    <title>repl.it</title>
</head>
<body>
<script src="https://repl.it/lib/api.js" type="text/javascript"></script>
<script type="text/javascript">

    TOKEN   = { time_created: 1493666998000,
        msg_mac: 'ZnRDMT0HMR5Tpk1orwN2jQOr0mFJ1i92eEPKc6dBS5E=' };

    var repl = new ReplitClient('api.repl.it', '80', 'java', TOKEN);

    repl.connect().then(
        function() {
            document.querySelector('.status').innerHTML = 'connected';
            start();
        },
        function() {
            document.querySelector('.status').innerHTML = 'failed';
        }
    );

    function start() {
        document.querySelector('button').onclick = function() {
            repl.evaluate(
                document.querySelector('input').value,
                {
                    stdout: function(str) {
                        document.querySelector('.out').innerHTML += str + '\n';
                    }
                }
            ).then(
                function(result) {
                    document.querySelector('.result').innerHTML += (result.error || result.data) + '\n';
                },
                function(err) {
                    console.error(err);
                }
            );
        };
    }


//    class Main {
//        public static void main(String[] args) {
//        System.out.println("hello world");
//    }
//    }
</script>
<div class="status">connecting..</div>
<input />
<button>run</button>
<pre class="result">results: </pre>
<pre class="out">output: </pre>

</body>
</html>