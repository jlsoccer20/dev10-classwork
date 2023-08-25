package learn.boardgames.ui;

import learn.boardgames.models.Availability;
import learn.boardgames.models.BoardGame;

import java.util.List;

public class View {

    private TextIO io; // = new ConsoleIO();
    public View(TextIO io){
        this.io = io;
    }
    public void displayHeader(String msg){

        io.println(msg);
        io.println("=".repeat(msg.length()));
    }

    public void displayMessage(String msg){
        io.println("");
        io.println(msg);
    }
    public void displayErrors(List<String> errors){
        for (String error : errors){
            io.println(error);
        }
    }
    public int getMenuOption(){
        displayHeader("Menu");
        io.println("1. Display all Board Games");
        io.println("2. Add a Board Games");
        io.println("3. Update Board Games");
        io.println("4. Delete a Board Game");
        io.println("5. Exit");
        return io.readInt("Choose [1-5]", 1,5);

    }
    public void displayBoardGames(List<BoardGame> all){
        String[] headers = {"Id", "Title", "MinPlayers", "MaxPlayers", "Release", "Rating", "Owned", "Availability"};
        for (String header : headers) {
            io.printf("%-15s", header);
        }
        io.println("");
        for (BoardGame bg : all) {
            io.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n", bg.getId(), bg.getTitle(), bg.getMinimumPlayers(),
                    bg.getMaximumPlayers(),
                    bg.getRetailReleaseDate(), bg.getRating(), bg.isInCollection() ? "Yes" : "No", bg.getAvailability());
        }
    }

    public BoardGame makeBoardGame() {
        BoardGame newBoardGame = new BoardGame();
        newBoardGame.setTitle(io.readRequiredString("Title: "));
        newBoardGame.setMinimumPlayers(io.readInt("Minimum players: "));
        newBoardGame.setMaximumPlayers(io.readInt("Maximum players: "));
        newBoardGame.setRetailReleaseDate(io.readString("Retail release date: "));
        newBoardGame.setRating(io.readDouble("Board Game Geek rating: ", 0, 10));
        newBoardGame.setInCollection(io.readBoolean("In collection? [y/n]: "));
        newBoardGame.setAvailability(readAvailability());
        return newBoardGame;
    }

    private Availability readAvailability(){
        displayMessage("Choose Availability: ");
        int index = 1;

        // iterate over Availability values (reading enum values)
        for (Availability avail : Availability.values()){
            // printing each enum to console
            io.printf("%s. %s%n", index, avail);
            index ++;
        }

        index--; // index 5 --> 4

        // ask user what number
        int choice = io.readInt(String.format("Choose [1-%s]", index, 1, index -1));
        // assigning enum value
        return Availability.values()[choice - 1];
    }
}
