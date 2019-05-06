package Battle;

import Collective.*;
import Collective.Flag;
import Collective.Item;
import Map.*;
import Player.*;
import com.sun.tools.javac.Main;

import java.util.ArrayList;

import static java.lang.Math.abs;

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
        if(abs(cell.getX() - selectedCard.getCell().getX()) +
                abs(cell.getY() - selectedCard.getCell().getY()) > 2) {
            //todo age betune bishtar az 2 khune bere barresi she
            selectedCard.setCell(cell);
        }
        else
            System.out.println("invalid target");
    }

        public void attack(Card defender) {
            int x1, y1, x2, y2;
            boolean flag_for_soldier_validity = false;
            boolean flag_for_attack = false;
            for (int i = 0; i < Map.getCardsInMap().size(); i++) {
                if (Map.getCardsInMap().contains(selectedCard)) {
                    flag_for_soldier_validity = true;
                    for (int j = 0; j < Map.getCardsInMap().size(); j++) {
                        if (Map.getCardsInMap().contains(defender)) {
                            flag_for_soldier_validity = true;
                            x1 = Map.getCardsInMap().get(i).getCell().getX();
                            y1 = Map.getCardsInMap().get(i).getCell().getY();
                            x2 = Map.getCardsInMap().get(j).getCell().getX();
                            y2 = Map.getCardsInMap().get(j).getCell().getX();
                            if (Card.getCards().get(i).getTargetArea().equals("two")) {
                                if (abs(x1 - x2) <= 1 && abs(y1 - y2) <= 1) {
                                    flag_for_attack = true;
                                    Map.getCardsInMap().get(i).getCell().setX(x2);
                                    Map.getCardsInMap().get(i).getCell().setY(y2);
                                }
                            }
                            if (Card.getCards().get(i).getTargetArea().equals("three")) {
                                if (abs(x1 - x2) <= 2 && abs(y1 - y2) <= 2) {
                                    flag_for_attack = true;
                                    Map.getCardsInMap().get(i).getCell().setX(x2);
                                    Map.getCardsInMap().get(i).getCell().setY(y2);
                                }
                            }

                            if (Card.getCards().get(i).getTargetArea().equals("enemy")) {
                                ArrayList<Integer> Ys_In_Same_Column = new ArrayList();
                                for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                                    if (Map.getCardsInMap().get(k).getCell().getY() == y1
                                            && Map.getCardsInMap().get(k).getOwner() != selectedCard.getOwner()) {
                                        Ys_In_Same_Column.add(Map.getCardsInMap().get(k).getCell().getY());
                                    }
                                }
                                if (Ys_In_Same_Column.contains(y2)) {
                                    flag_for_attack = true;
                                    Map.getCardsInMap().get(i).getCell().setX(x2);
                                    Map.getCardsInMap().get(i).getCell().setY(y2);
                                }
                            }

                            if (Card.getCards().get(i).getTargetArea().equals("friend")) {
                                ArrayList<Integer> Ys_In_Same_Column = new ArrayList();
                                for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                                    if (Map.getCardsInMap().get(k).getCell().getY() == y1
                                            && Map.getCardsInMap().get(k).getOwner() == selectedCard.getOwner()) {
                                        Ys_In_Same_Column.add(Map.getCardsInMap().get(k).getCell().getY());
                                    }
                                }
                                if (Ys_In_Same_Column.contains(y2)) {
                                    flag_for_attack = true;
                                    Map.getCardsInMap().get(i).getCell().setX(x2);
                                    Map.getCardsInMap().get(i).getCell().setY(y2);
                                }
                            }

                            if (Card.getCards().get(i).getTargetArea().equals("eight_arounds")) {
                                ArrayList<Cell> around_cells = new ArrayList();
                                for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                                    if (Map.getCardsInMap().get(k).getCell().getX()-x1<=2
                                            && Map.getCardsInMap().get(k).getCell().getY()-y1<=2) {
                                        around_cells.add(Map.getCardsInMap().get(k).getCell());
                                    }
                                }
                                if (around_cells.contains(defender)) {
                                    flag_for_attack = true;
                                    Map.getCardsInMap().get(i).getCell().setX(x2);
                                    Map.getCardsInMap().get(i).getCell().setY(y2);
                                }
                            }





                        }
                    }

                }
            }
            if (!flag_for_soldier_validity) {
                System.out.println("Invalid card id");
            }
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
                    if(abs(card.getCell().getX() - x) + abs(card.getCell().getY() - y) <= 1){
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
        for(int i = 0; i < currentPlayer.getMainDeck().getItems().size(); i++){
            if(currentPlayer.getMainDeck().getItems().get(i).getItemID().equals(cardID)){
                selectedItem = currentPlayer.getMainDeck().getItems().get(i);
                return;
            }
        }
        System.out.println("Invalid card/item id");
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

    public void showNextCard(){
        //todo hand.getNextCard
    }
    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void playRandomTurn(){
        Random random = new Random();
        int rand = random.nextInt(3);
        //todo
    }

    public void use(int x, int y){
        //todo
    }
    public void showCollectables(){
        //todo
    }
    public void help(){
        //todo
    }
}