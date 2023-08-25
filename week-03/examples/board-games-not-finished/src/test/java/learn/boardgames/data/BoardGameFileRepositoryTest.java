package learn.boardgames.data;

import learn.boardgames.models.Availability;
import learn.boardgames.models.BoardGame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameFileRepositoryTest {

    BoardGameFileRepository repository = new BoardGameFileRepository("data\board-games-test.csv");


    @Test
    void shouldFindAllBoardGames() {
        List<BoardGame> boardGames = List.of(
                new BoardGame(1,"Lunar Rush",1,4,
                        "2023-10-20",8.5,true, Availability.UPCOMING),
                new BoardGame(2,"Ascension",1,4,
                        "2010-01-01",7.0,false,Availability.AVAILABLE_IN_RETAIL),
                new BoardGame(3,"Carcassonne",2,5,
                        "2000-01-01",7.4,true,Availability.OUT_OF_PRINT)

        );
    }

    @Test shouldAddBoardGame(){
        BoardGame boardGame = new BoardGame(0, "Munchkin", 3, 6,
                "2001-01-01", 5.9, true,Availability.AVAILABLE_IN_RETAIL);
        BoardGame expected = new BoardGame(4,"Munchkin", 3, 6,
                "2001-01-01", 5.9, true,Availability.AVAILABLE_IN_RETAIL);
        BoardGame actual = repository.add(BoardGame);

        assertEquals(expected, actual);
    }
}