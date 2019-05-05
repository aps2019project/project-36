package Battle;

import Collective.Card;
import Collective.Flag;
import Collective.Item;
import Map.Map;
import Player.Player;
import com.sun.tools.javac.Main;

public class Battle {
    Game game = new Game();
    Player currentPlayer = new Player();
    Card selectedCard = new Card();
    Item selectedItem = new Item();
    public void gameInfo(){
        System.out.println("Player 1 ManaPoint : " + game.getManaPlayer1());
        System.out.println("Player 2 ManaPoint : " + game.getManaPlayer2());
        if(game.getMode() == 1){
            System.out.println("Player 1 HealthPoint : " + game.getPlayer1().getMainDeck().getHero().getHP());
            System.out.println("Player 2 HealthPoint : " + game.getPlayer2().getMainDeck().getHero().getHP());
        }
        if(game.getMode() == 2){
            System.out.println("flag's position" + Map.getFlagsInMap().get(0).getCell().getX() + 1 + " " + Map.getFlagsInMap().get(0).getCell().getY() + 1);
            if (Map.getFlagsInMap().get(0).getOwner().equals(game.getPlayer1())){
                System.out.println("flag's owner is player 1");
            }
            else
                System.out.println("flag's owner is player 2");
        }
        if (game.getMode() == 3){
            Map.getFlagsInMap().forEach(i -> System.out.println(i.getOwner().getCardID()));
        }
    }
    public void playTurn(){

    }
}
