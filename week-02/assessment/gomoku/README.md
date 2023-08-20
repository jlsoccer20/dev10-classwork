#Gomoku Plan

## Requirements

- Can set up two players. DONE
- For a human player, collect their name. (A random player's name is randomly generated.) DONE
- For each stone placement, use the player's name to ask questions. PARTIALLY DONE
- Since the random player doesn't require input, the UI should display stone placement and the results of placement. (Random player placement may fail since they don't know what they're doing.) PARTIALLY DONE
- Re-prompt on failed placement. The game must not proceed until a player has made a valid move. PARTIALLY DONE
- Display the final result of the game. DONE
- Give the option to play again.



- All rules are modeled inside the Gomoku class. You may not modify Gomoku, Player, HumanPlayer, RandomPlayer, Stone, or Result.
- Add your code to the project provided. Be sure to use sensible class names, method names, and packages.
- At least one class beyond the App class is required.
- Stones use 0-based rows and columns.
## Tasks

### PreCoding

[ ] Read the project code. Read the unit tests.

[ ] Run the unit tests. Use the debugger. Understand how the different parts of the game fit together.

### Part 1

[ ] Set up welcome menu. Consider setting up an additional package, like a "ui" (user interface) or "controllers" package
- GameController Class: provides a user interface for the user to play the game
  - Fields:
    - `Scanner console`;
    - Maybe a way to represent the board state?
    - 'Gomoku game'
- Methods:
  - `public void run()` // run and start the game
    - set up a new game: call a helper method `setUp()`
    - Optional: Explain the rules
    - play the game by calling our play() method
    - private void setup: 
      - Create the (two) players
      - instantiate the game
      - display confirmation messages
    - `private void play()`
    - Display the results method: `displayResults()`
      - Can pass the information (win, lose, tie)
    - Play again? `playAgain()`
    - Display current player
      - `getCurrent()` method returns who the current player is
    - Loop `while !isOver() = true;` (while isOver is false) 
      - Display current player
      - Display the board: `printBoard()`
      - Generate a stone from the player
        - If human player, prompt for row and column placement
      - place the stone and display the result
      - if result is unsuccessful, prompt again
      - `private void printBoard()`
        - take the list of stones
        - print them to the board
      - `private void displayResults()`
        - prints the end results of the game: the winner or tie
      - `private void playAgain()`
        - prompts the user to play again
      - 
      
- Utility Methods:
  - Ask human player:
    - `private String readRequiredString`
    - `private int readRequiredInt`