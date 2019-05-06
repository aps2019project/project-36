package Battle;

import Collective.*;
import Collective.Flag;
import Collective.Item;
import Map.*;
import Player.*;
import com.sun.tools.javac.Main;

import java.util.Random;

public class Battle {
    Game game = new Game();
    Player currentPlayer = new Player();
    Card selectedCard;
    Item selectedItem = new Item();
    public void gameInfo(){
        System.out.println("Player 1 ManaPoint : " + game.getManaPlayer1());
        System.out.println("Player 2 ManaPoint : " + game.getManaPlayer2());
        if(game.getMode() == 1){
            System.out.println("Player 1 HealthPoint : " + game.getPlayer1().getMainDeck().getHero().getHP());
            System.out.println("Player 2 HealthPoint : " + game.getPlayer2().getMainDeck().getHero().getHP());
        }
        if(game.getMode() == 2){
            System.out.println("flag's position" + Map.getFlagsInMap().get(0).getCell().getX() + 1 + " "
                    + Map.getFlagsInMap().get(0).getCell().getY() + 1);
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

    public void showCardInfo(Card card){
        //todo
    }

    public void moveTo(int x, int y){
        Cell cell = new Cell();
        cell.setY(y);
        cell.setX(x);
        if(Math.abs(cell.getX() - selectedCard.getCell().getX()) +
                Math.abs(cell.getY() - selectedCard.getCell().getY()) > 2) {
            //todo age betune bishtar az 2 khune bere barresi she
            selectedCard.setCell(cell);
        }
        else
            System.out.println("invalid target");
    }

    public void attack(){
        //todo
    }
    public void comboAttack(){
        //todo
    }

    public void useSpecialPower(){
        //todo
    }

    public void showHand(){
        currentPlayer.getMainDeck().getHand().getCards().forEach(i -> System.out.println(i.getCardID()));
    }
    public void insertCard(String cardName, int x, int y){
        for(int i = 0; i < currentPlayer.getMainDeck().getHand().getCards().size(); i++){
            if(cardName.equals(currentPlayer.getMainDeck().getHand().getCards().get(i).getName())){
                for (Card card:
                     Map.getCardsInMap()) {
                    if(Math.abs(card.getCell().getX() - x) + Math.abs(card.getCell().getY() - y) <= 1){
                        Cell cell = new Cell();
                        cell.setX(x);
                        cell.setY(y);
                        currentPlayer.getMainDeck().getHand().getCards().get(i).setCell(cell);
                        Map.addToCardsInMap(currentPlayer.getMainDeck().getHand().getCards().get(i));
                        return;
                    }
                }
                System.out.println("invalid target");
            }
        }
        System.out.println("Invalid card name");
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

    public void setSelectedCard(String cardID) {
        for(int i = 0; i < currentPlayer.getMainDeck().getHand().getCards().size(); i++){
            if(currentPlayer.getMainDeck().getHand().getCards().get(i).getCardID().equals(cardID)){
                selectedCard = currentPlayer.getMainDeck().getHand().getCards().get(i);
                return;
            }
        }
        System.out.println("Invalid card id");
    }

    public void enterGraveyardShowCards(GraveYard graveYard){
        graveYard.getCards().forEach(i -> System.out.println(i.getName()));
    }
    public void enterGraveyardShowInfo(GraveYard graveYard, Card card){
        //todo
    }
    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void playRandomTurn(){
        Random random = new Random();
        int rand = random.nextInt(3);
    }
    public void help(){
        //todo
    }
}