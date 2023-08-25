package learn.boardgames.ui;

import learn.boardgames.data.DataAccessException;
import learn.boardgames.domain.BoardGameResult;
import learn.boardgames.domain.BoardGameService;
import learn.boardgames.models.BoardGame;

import javax.xml.crypto.Data;
import java.util.List;


public class Controller {
    private View view;
    private BoardGameService service;

    public Controller(View view, BoardGameService service) {
        this.view = view;
        this.service = service;
    }

    public void run(){
        view.displayHeader("Welcome to Board Game Management HQ!");
        // TODO: Run a menu
        try {
            runMenu();
        } catch (DataAccessException ex) {
            view.displayMessage("A critical error occurred. " + ex.getMessage());
        }


    }

    // call a view method that allows us to print menu options and get user input
    // this should continue to run while user has not selected exit
    private void runMenu() throws DataAccessException {
        boolean exit = false;
        do {
            // do not want to directly interact with console
            int choice = view.getMenuOption();
            switch(choice){

                // display board games
                case 1:
                    displayAllBoardGames();
                    break;

                // add board game
                case 2:
                    createBoardGame();
                    break;

               // update board game
                case 3:

                    break;

                // delete board game
                case 4:

                    break;

                // exit
                case 5:
                    exit = true;
                    view.displayMessage("Goodbye!");
            }
        }while (!exit);

    }

    private void createBoardGame() throws DataAccessException {
        // display a header to the user
        view.displayHeader("Add Board Game to Collection");
        // get fields from user view the view
        BoardGame newGame = view.makeBoardGame();
        // use service to create the board game (let the domain validate no duplicates)
        BoardGameResult result = service.add(newGame);
        // display results from the add operation
        if (result.isSuccess()){
            view.displayMessage("Board game " + newGame.getTitle() + " was successfully added to the collection.");

        } else {
            view.displayErrors(result.getMessages());
        }
    }

    private void displayAllBoardGames() throws DataAccessException {

        view.displayHeader("Board Games in Collection");
        // Call findAll from service
        List<BoardGame> all = service.findAll();
        // Give the data to the view to print
        if (all.isEmpty()){
            view.displayMessage("There are no board games in this collection...yet.");

        } else {
            view.displayBoardGames(all);
        }
    }
}
