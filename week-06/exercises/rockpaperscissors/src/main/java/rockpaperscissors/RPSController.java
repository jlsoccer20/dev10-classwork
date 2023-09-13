package rockpaperscissors;

import org.springframework.web.bind.annotation.*;

@RestController
public class RPSController {
    public RpsService service;

    // Start a game
    @PostMapping("/rps")
        public void newGame(){
            service = new RpsService();

        }

    // Make a move
    @PutMapping("/rps/{choice}")
    public String makeMove(@PathVariable String choice){
        RpsService.Move playerMove = RpsService.Move.valueOf(choice);
        service.makeWinner(playerMove);
        return service.moveMessage;

    }

    @GetMapping("/rps/result")
    public String getResult(){
        return service.resultMessage;
    }

}
