const tableDiv = document.getElementById("table");
const url = "https://buehub.com/rest-jpa-devops-starter/api/jokes/all";
const url2 = "https://buehub.com/rest-jpa-devops-starter/api/jokes/";
const url3 = "https://buehub.com/rest-jpa-devops-starter/api/jokes/random";
const table = "<table class='table table-hover rounded' style='background-color: white'><thead class='rounded'><tr>";
const ths = "<th>All the jokes<th/><tr/><thead/><tbody>";
const ths2 = "<th>A random joke<th/><tr/><thead/><tbody>";
const ths3 = "<th>A specific joke<th/><tr/><thead/><tbody>";
const JokeIdInput = document.getElementById("jokeIdInput");
const JokeButton = document.getElementById("getJokeById");


function allJokes() {
    fetch(url)
        .then(res => res.json())
        .then(data => tableDiv.innerHTML = table + ths + data.map(el => '<tr>' +
            '<td>' + el.theJoke + '<td/>').join('') +
            '<body/><table/>');

}

function randomJoke() {
    fetch(url3)
        .then(res => res.json())
        .then(data => tableDiv.innerHTML = table + ths2 + '<tr>' +
            '<td>' + data.theJoke + '<td/>' +
            '<body/><table/>'  );


}
//todo: WHAT IS GOING ON!! Onclick does not work in the html file, has to be rewritten to addeventlistner to work for some reason

// function getJokeById() {
//     fetch (url2 + JokeIdInput.value)
//         .then(res => res.json())
//         .then(data => tableDiv.innerHTML = table + ths3 + '<tr>' +
//             '<td>' + data.theJoke + '<td/>' +
//             '<body/><table/>'  );
// }
 JokeButton.addEventListener("click", function getJokeById() {
     fetch (url2 + JokeIdInput.value)
         .then(res => res.json())
         .then(data => tableDiv.innerHTML = table + ths3 + '<tr>' +
             '<td>' + data.theJoke + '<td/>' +
             '<body/><table/>'  );
 });


