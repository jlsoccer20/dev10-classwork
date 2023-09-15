const errorPanel = document.getElementById("errorPanel");

let game;
let firstCard;
let canInteract = true;

function displayError(message) {
    errorPanel.innerText = message;
    errorPanel.style.display = "block";
}

function hideError() {
    errorPanel.style.display = "none";
}

function revealCard(row, col) {

    if (!canInteract) {
        return;
    }

    canInteract = false;
    hideError();

    const init = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            gameId: game.gameId,
            row,
            column: col
        })
    };

    fetch("/move", init)
        .then(response => {
            if (response.status === 200
                || response.status === 412
                || response.status === 422) {
                return response.json();
            }
            return Promise.reject("Bad move request.")
        })
        .then(json => {
            let card = document.getElementById(`td${row}_${col}`)

            switch (json.status) {
                case "GAME_NOT_FOUND":
                case "ERROR":
                    displayError(json.message);
                    canInteract = true;
                    break;
                case "GAME_OVER":
                    card.innerText = json.value;
                    displayError("Game over.");
                    canInteract = true;
                    break;
                case "NEXT":
                    firstCard = card;
                    card.innerText = json.value;
                    canInteract = true;
                    break;
                case "MATCH":
                    card.innerText = json.value;
                    canInteract = true;
                    break;
                case "NO_MATCH":
                    card.innerText = json.value;
                    setTimeout(() => {
                        firstCard.innerText = "?";
                        card.innerText = "?";
                        canInteract = true;
                    }, 1500);
                    break;
            }
        }).catch(console.error);
}

function buildGrid() {

    // set h2
    const gameIdH2 = document.getElementById("gameId");
    gameIdH2.innerHTML = `<strong>Game</strong> #${game.gameId}`;
    gameIdH2.style.visibility = "visible";

    // build the table
    let tableHtml = '<table><tbody>';
    for (let row = 0; row < game.rows; row++) {
        tableHtml += "<tr>";
        for (let col = 0; col < game.columns; col++) {
            tableHtml += `<td id="td${row}_${col}" onclick="revealCard(${row}, ${col});">?</td>`;
        }
        tableHtml += "</tr>"
    }
    tableHtml += "</tbody></table>"
    document.getElementById("grid").innerHTML = tableHtml;
}

document.getElementById("btnStart").addEventListener("click", () => {
    hideError();
    fetch("/start", { method: "POST" })
        .then(response => {
            if (response.status === 201) {
                return response.json();
            }
            return Promise.reject("Could not create game.");
        })
        .then(g => {
            game = g;
            buildGrid();
        })
        .catch(console.error);
});