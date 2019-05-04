import Battle.Game;
import Collective.Flag;
import Player.Player;
import Player.Match;

import java.util.ArrayList;

import Battle.BattleMenu;
import Shop.ShopMenu;

import java.util.Collection;
import java.util.Scanner;

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
        boolean x = true;
        Scanner scanner = new Scanner(System.in);
        StringBuilder option = new StringBuilder();
        Main.help();
        while(x){
            option.setLength(0);
            option.append(scanner.next());
            switch (option.toString().toLowerCase()){
                case "enter help":
                    Main.help();
                    break;
                case "enter exit":
                    x= false;
                    return;
                case "enter collection":
                    Collection.getOptions();
                    break;
                case "enter shop":
                    ShopMenu.getOptions();
                    break;
                case "enter battle":
                    BattleMenu.getOptions();
                    break;
                    default:
                        System.out.println("Option not found");
            }
        }
    }
    public static void help(){
        System.out.println("Help");
        System.out.println("Exit");
        System.out.println("Collection");
        System.out.println("Shop");
        System.out.println("Battle");
    }

}