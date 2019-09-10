const tableDiv = document.getElementById("table");
const url = "http://localhost:8080/ca1/api/car/all";

function createTable() {
    fetch(url)
        .then(res => res.json())
        .then(data => {
            let thead = data[0];
            let table = "<table class='table'><tr>";
            for (let value in thead) {
                table += `<td>${value}</td>`;
            }
            table += '</tr></table>';
            tableDiv.innerHTML = table;
        });
}

createTable();