document.getElementById("heading").innerHTML = localStorage["title"] || "Einfach mal was schreiben";
document.getElementById("content").innerHTML = localStorage["text"] || "Der Text wird alle zwei Sekunden gespeichert:) ";

setInterval(function() {
  localStorage["title"] = document.getElementById("heading").innerHTML;
  localStorage["text"] = document.getElementById("content").innerHTML;
}, 1000);

//Change text color
function colorBlack() { 
  document.getElementById("content").style.color = "black";
}
function colorRed() { 
  document.getElementById("content").style.color = "red";
}
function colorBlue() { 
  document.getElementById("content").style.color = "blue";
}
function colorGreen() { 
  document.getElementById("content").style.color = "green";
}

//Text herunterladen
function download(){
    var a = document.body.appendChild(
        document.createElement("a")
    );
    a.download = "Text.txt";
    a.href = "data:text/html," + document.getElementById("content").innerHTML;
    a.click();
}