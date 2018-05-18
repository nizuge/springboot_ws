$(document).ready(function() {
    connect();
});

var stompClient = null;
function connect() {
    var socket = new SockJS('/registry1');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greet123', function(greeting){
            //console.log(JSON.parse(greeting.body).content);
        });
    },function(message) {
        console.log(message);
        setTimeout("connect()", 2000);
    });
}
function send() {
    stompClient.send("/app/123/registry0", {testH:"testMess"}, JSON.stringify({ 'name': "jklsdafjklasdfjl" }));
    stompClient.send("/app/123456/hello/registry1",{},"hello world!");
}
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}
