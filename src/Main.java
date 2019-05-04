import Battle.Game;
import Collective.Flag;
import Player.Player;
import Player.Match;

import java.util.ArrayList;

public class Main
{
    static Player loggedInPlayer = new Player();
    public static void main( String[] args )
    {
        while (true) {
            // in case of playing a game:
            // mode 2
            Game game = new Game();
            game.setPlayer1(player);
            game.setMode(mode);
            Match match = new Match();
            match.changeElapsedTime();
            match.setPlayer1(loggedInPlayer);
            match.setPlayer2(game.player2);
            if(Game.gameOver()){
                match.setWinner();
            }
        }
    }
}