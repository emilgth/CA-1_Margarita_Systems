const tableDiv = document.getElementById("table");
const url = "http://localhost:8080/ca1/api/jokes/all";
const url2 = "http://localhost:8080/ca1/api/jokes/id";
const url3 = "http://localhost:8080/ca1/api/jokes/random";

function allJokes() {
    fetch(url)
        .then(res => res.json())
        .then(data => {
            console.log("hi")
        });

}

allJokes();



