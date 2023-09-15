package corbos.memorygame.controllers;

import corbos.memorygame.models.GameStartResponse;
import corbos.memorygame.models.MoveRequest;
import corbos.memorygame.models.MoveResponse;
import corbos.memorygame.models.MoveStatus;
import corbos.memorygame.service.GameCache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    private final GameCache cache = new GameCache();

    @PostMapping("/start")
    public ResponseEntity<GameStartResponse> start() {
        return new ResponseEntity(cache.create(), HttpStatus.CREATED);
    }

    @PostMapping("/start/{rows}/{columns}")
    public ResponseEntity<GameStartResponse> start(@PathVariable int rows, @PathVariable int columns) {
        try {
            return new ResponseEntity(cache.create(rows, columns), HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity(
                    new GameStartResponse(ex.getMessage()),
                    HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/move")
    public ResponseEntity<MoveResponse> move(@RequestBody MoveRequest request) {

        MoveResponse moveResponse = cache.move(request);

        HttpStatus status = HttpStatus.OK;
        if (moveResponse.getStatus() == MoveStatus.GAME_NOT_FOUND) {
            status = HttpStatus.PRECONDITION_FAILED; // 412       
        } else if (moveResponse.getStatus() == MoveStatus.ERROR) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;// 422
        }

        return new ResponseEntity(moveResponse, status);
    }
}
