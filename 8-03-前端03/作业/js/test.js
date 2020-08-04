var i = 1;
var j = 0;
var time = 50;
var colors = ["yellow","black","red","blue","green","aqua","pink","darkcyan"];
var timeout;
function f() {
    var last = document.getElementById(i + "");
    last.style.backgroundColor = "white";
    if (i == 8) {
        i = 0;
        j = -1;
    }
    var td = document.getElementById(++i + "");
    td.style.backgroundColor = colors[++j];
    console.log(time);
    time += 10;
    if (time >= (400 + Math.floor(Math.random()*200))) {
        clearInterval(timeout);
        time = 50;
        // if (i == 1){
        //     window.alert("恭喜中奖了！");
        // }else {
        //     window.alert("非常遗憾！");
        // }
        return;
    }
    clearInterval(timeout);
    f1();
}

function f1() {
    timeout = setInterval(f, time);
}
