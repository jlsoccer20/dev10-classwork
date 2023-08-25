package learn.boardgames.data;

import learn.boardgames.models.BoardGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardGameFileRepository implements BoardGameRepository{
    private final String filePath;
    public BoardGameFileRepository(String filePath){
        this.filePath = filePath;
    }
    @Override
    public List<BoardGame> findAll(){
        ArrayList<BoardGame> result = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

        } catch (FileNotFoundException e){
            // Oh well, nothing there yet

        } catch (IOException e){

        }
        return result;
    }

    @Override
    public BoardGame findById(int id) throws DataAccessException {
        List<BoardGame> boardGames = findAll();

        for (BoardGame boardGame : boardGames){

        }
        return null;
    }

    @Override
    public List<BoardGame> findByTitle(String title) {
        return null;
    }

    @Override
    public BoardGame add(BoardGame boardGame) {

        return null;
    }

    @Override
    public boolean update(BoardGame boardGame) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    private BoardGame deserialize(String line){
        BoardGame boardGame = null;
        String[] values = line.split(",");
        if (values.length == 8){
            boardGame = new BoardGame();
            boardGame.setId(Integer.parseInt(values[0]));

        }
    }
}
