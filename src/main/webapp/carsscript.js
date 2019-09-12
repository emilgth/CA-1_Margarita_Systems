const tableDiv = document.getElementById("table");
const url = "https://buehub.com/rest-jpa-devops-starter/api/car/all";
const filterByPriceInput = document.getElementById("filterByPriceInput");
const filterByPriceButton = document.getElementById("filterByPriceButton");
const sortByPriceButton = document.getElementById("sortByPriceButton");

function createTableOnLoad() {
    fetch(url)
        .then(res => res.json())
        .then(data => {
            generateTable(data);
        });
}

function createFilteredTable() {
    fetch(url)
        .then(res => res.json())
        .then(data => {
            let carArray = Array.from(data);
            let filteredArray = carArray.filter(function (car) {
                if (car.price < filterByPriceInput.value) {
                    return car;
                }
            });
            if (filteredArray.length !== 0) {
                generateTable(filteredArray);
            } else {
                tableDiv.innerHTML = "<p>There is no cars at the desired price point</p>"
            }
        });
}

function sortByPrice() {
    fetch(url)
        .then(res => res.json())
        .then(data => {
            let carArray = Array.from(data);
            let sortedArray = carArray.sort(function (a, b) {
                return a.price - b.price;
            });
            generateTable(sortedArray);
        });
}

function generateTable(data) {

        let thead = data[0];
        let table = "<table class='table table-hover rounded' style='background-color: white'><thead class='rounded'><tr>";
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

}

createTableOnLoad();
filterByPriceButton.addEventListener("click", createFilteredTable);
sortByPriceButton.addEventListener("click", sortByPrice);