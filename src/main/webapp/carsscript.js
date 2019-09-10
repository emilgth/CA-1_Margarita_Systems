const tableDiv = document.getElementById("table");
const url = "http://localhost:8080/ca1/api/car/all";
const filterByPriceInput = document.getElementById("filterByPriceInput");
const filterByPriceButton = document.getElementById("filterByPriceButton");

function createTable() {
    fetch(url)
        .then(res => res.json())
        .then(data => {

            let thead = data[0];
            let table = "<table class='table'><thead><tr>";
            for (let value in thead) {
                table += `<th>${value}</th>`;
            }
            table += '</tr></thead><tbody>';

            for (let element of data) {
                table += '<tr>';
                for (let value in element) {
                    table += `<td>${element[value]}</td>`;
                }
                table += '</tr>'
            }
            table += '</tbody></table>';
            tableDiv.innerHTML = table;
        });
}

createTable();