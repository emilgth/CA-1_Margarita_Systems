const tableDiv = document.getElementById("tableDiv");

function createTable() {

    const url = "http://localhost:8080/ca1/api/groupmembers/all";
    const table = "<table class='table table-hover rounded' style='background-color: white'><thead class='rounded'><tr>";
    const ths = "<th>Name</th><th>Student ID</th><th>Color (green, yellow, red)</th></tr></thead><tbody>";

    fetch(url)
        .then(response => response.json())
        .then(data => tableDiv.innerHTML = table + ths + data.map(el=> '<tr>' +
                '<td>' + el.firstName + " " + el.lastName + '</td>' +
                '<td>' + el.studentID + '</td>' +
                '<td>' + el.color + '</td>' + '</tr>').join('') +
                '</tbody></table>');
}