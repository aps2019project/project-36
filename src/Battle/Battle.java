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
            for(int i = 0; i < Map.getFlagsInMap().size(); i++) {
                System.out.println("flag owner's card id is : " + Map.getFlagsInMap().get(i).getOwner().getCardID());
                System.out.println("from team : " + Map.getFlagsInMap().get(i).getOwner().getOwner().getUsername());
            }
        }
    }
    public void showMyMinions(Player player){
        for(int i = 0; i < player.getMainDeck().getCards().size(); i++){
            //todo
        }
    }

    public void showOpponentMinions(Player player){
        //todo
    }

    public void ShowCardInfo(int cartID){
        //todo
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(int cardID) {

    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void playTurn(){

    }
}
