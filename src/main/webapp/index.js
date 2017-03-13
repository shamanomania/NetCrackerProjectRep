TOKEN   = { time_created: 1488744924000,
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
