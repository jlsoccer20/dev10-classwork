package learn.boardgames;

import learn.boardgames.data.BoardGameFileRepository;
import learn.boardgames.data.BoardGameRepository;
import learn.boardgames.data.DataAccessException;
import learn.boardgames.domain.BoardGameService;
import learn.boardgames.models.BoardGame;
import learn.boardgames.ui.ConsoleIO;
import learn.boardgames.ui.Controller;
import learn.boardgames.ui.TextIO;
import learn.boardgames.ui.View;
import org.w3c.dom.Text;

public class App {
    public static void main(String[] args) {
        BoardGameRepository repository = new BoardGameFileRepository("./data/board-games.csv");
        BoardGameService service = new BoardGameService(repository);

        TextIO io = new ConsoleIO();
        // Pass directly into Constructor
        View view = new View(io);
        Controller controller = new Controller(view, service);
        controller.run();

        /*
        try {

            System.out.println("Board Games");
            System.out.println("===========");
            for(BoardGame game: service.findByTitle("Faiyum")) {
                System.out.println(game);
            }
        } catch (DataAccessException e) {
            System.out.println("I'm so, so sorry. :(");
        }
        */
    }
}
