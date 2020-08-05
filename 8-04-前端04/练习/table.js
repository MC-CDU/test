var i = 1;
function addStu() {
    var htmlTableRowElement = document.createElement("tr");
    var attr = document.createAttribute("id");
    attr.value = i+"tr";
    htmlTableRowElement.setAttributeNode(attr);
    htmlTableRowElement.innerHTML = "<td class="+i+"><input type='text'></td>" +
        "<td class="+i+"><input type='text'></td>" +
        "<td class="+i+"><input type='text'></td>" +
        "<td class="+i+"><button class='confirm' onclick='conf()'>确认</button>&nbsp;<button class='delete' id="+i+">删除</button></td>";
    var elementsByTagNameElement = document.getElementById("tbody");
    elementsByTagNameElement.appendChild(htmlTableRowElement);
}
function conf() {
    console.log(i);
    var td = document.getElementsByClassName(i+++"");
    for (var j = 0;j < td.length - 1;j++) {
        var value = td[j].childNodes[0].value;
        td[j].removeChild(td[j].childNodes[0]);
        var text = document.createTextNode(value);
        td[j].append(text);
    }
    td[td.length - 1].removeChild(td[td.length - 1].childNodes[0]);
}


document.onclick =e=>{
    var e = window.event||e
    // if(e.target.className == "delete") {
    //     e.target.parentElement.parentElement.remove()
    // }
    if(e.target.className == "delete"){
        var elementsByTagName = document.getElementById(e.target.id + "tr");
        console.log(elementsByTagName);
        var elementsByTagName1 = document.getElementsByTagName("tbody");
        elementsByTagName1[0].removeChild(elementsByTagName);
    }
}
