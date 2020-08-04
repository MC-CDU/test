document.write("<table>");
for (var i = 1;i < 10;i++){
    document.write("<tr>");
    for (var j = 1;j <= i;j++){
        document.write("<td style='border: 1px solid black;'>");
        document.write(j + "*" + i + "=" + (i*j));
        document.write("</td>");
    }
    document.write("</tr>");
}
document.write("</table>");