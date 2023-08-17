package learn.rps.game;

import learn.rps.players.Player;

import static learn.rps.RockPaperScissors.*;

public class RpsEvaluator {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
}

public int evaluate(){

    int p1Choice = playerOne.go();
    int p2Choice = playerTwo.go();

    String outcome = "";
    if (p1Choice == p2Choice){
        outcome = "Players tied.";
    }

}
