const arrayPlayer = ["123498749919148199499","albansan","530","simplePlayer.py","840","simplePlayer.py"];
const tableRows = [];
for (let i = 0; i < 20; i++) {
    tableRows.push(arrayPlayer);
}
// Au dessus ça simule le fait que je récup un array du endpoint

var table = document.getElementById("tableBody");
for (let i = 0; i<tableRows.length;i++){
    var row = table.insertRow(i);
    for (let y = 0; y < tableRows[i].length; y++) {
        var cell = row.insertCell(y);
        cell.innerHTML = tableRows[i][y];
    }
}

