package Battle;

import Collective.Card.Card;
import Collective.Item;
import Collective.Card.Minion.Minion;
import Map.Cell;
import Map.Map;
import Player.GraveYard;
import Player.Player;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class Battle {
    Game game = new Game();
    Player currentPlayer = new Player();
    Card selectedCard;
    Item selectedItem = new Item();

    public void gameInfo() {
        System.out.println("Player 1 ManaPoint : " + game.getManaPlayer1());
        System.out.println("Player 2 ManaPoint : " + game.getManaPlayer2());
        if (game.getMode() == 1) {
            System.out.println("Player 1 HealthPoint : " + game.getPlayer1().getMainDeck().getHero().getHP());
            System.out.println("Player 2 HealthPoint : " + game.getPlayer2().getMainDeck().getHero().getHP());
        }
        if (game.getMode() == 2) {
            System.out.println("flag's position" + Map.getFlagsInMap().get(0).getCell().getX() + 1 + " "
                    + Map.getFlagsInMap().get(0).getCell().getY() + 1);
            if (Map.getFlagsInMap().get(0).getOwner().equals(game.getPlayer1())) {
                System.out.println("flag's owner is player 1");
            } else
                System.out.println("flag's owner is player 2");
        }
        if (game.getMode() == 3) {
            for (int i = 0; i < Map.getFlagsInMap().size(); i++) {
                System.out.println("flag owner's card id is : " + Map.getFlagsInMap().get(i).getOwner().getCardID());
                System.out.println("from team : " + Map.getFlagsInMap().get(i).getOwner().getOwner().getUsername());
            }
        }
    }

    public void showMyMinions(Player player) {
        for (int i = 0; i < player.getMainDeck().getCards().size(); i++) {
            //todo
        }
    }

    public void showOpponentMinions(Player player) {
        //todo
    }

    public void showCardInfo(Card card) {
        //todo
    }

    public void chechTypeOfMinion(Card selectedCard,Card defender){
        if(defender.getType().equals("Minion")){

        }
    }

    public void moveTo(int x, int y) {
        Cell cell = new Cell();
        cell.setY(y);
        cell.setX(x);
        if (abs(cell.getX() - selectedCard.getCell().getX()) +
                abs(cell.getY() - selectedCard.getCell().getY()) > 2) {
            //todo age betune bishtar az 2 khune bere barresi she
            selectedCard.setCell(cell);
        } else
            System.out.println("invalid target");
    }


    public void attack(Card defender) {
        //todo for turn
        int x1, y1, x2=0, y2=0;
        boolean flag_for_soldier_validity = false;
        boolean flag_for_attack = false;
        boolean flag_for_minion_attack=false;
        if(selectedCard.getType().equals("Minion") ){
            Minion m=new Minion();
            m=(Minion) selectedCard;
            if(m.getCanAttack()){
                flag_for_minion_attack=true;
            }
        }
        if(!selectedCard.getType().equals("Minion") || flag_for_minion_attack){

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
                            }
                        }
                        if (Card.getCards().get(i).getTargetArea().equals("three")) {
                            if (abs(x1 - x2) <= 2 && abs(y1 - y2) <= 2) {
                                flag_for_attack = true;
                            }
                        }

                        if (Card.getCards().get(i).getTargetArea().equals("all_in_one_column")) {
                            ArrayList<Integer> Ys_In_Same_Column = new ArrayList();
                            for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                                if (Map.getCardsInMap().get(k).getCell().getY() == y1
                                        && Map.getCardsInMap().get(k).getOwner() != selectedCard.getOwner()) {
                                    Ys_In_Same_Column.add(Map.getCardsInMap().get(k).getCell().getY());
                                }
                            }
                            if (Ys_In_Same_Column.contains(y2)) {
                                flag_for_attack = true;
                            }
                        }

                        if (Card.getCards().get(i).getTargetArea().equals("enemy")) {
                            ArrayList<Integer> enemies = new ArrayList();
                            for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                                if (Map.getCardsInMap().get(k).getOwner() != selectedCard.getOwner()) {
                                    enemies.add(Map.getCardsInMap().get(k).getCell().getY());
                                }
                            }
                            if (enemies.contains(y2)) {
                                flag_for_attack = true;
                            }
                        }

                        if (Card.getCards().get(i).getTargetArea().equals("friend")) {
                            ArrayList<Integer> friends = new ArrayList();
                            for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                                if (Map.getCardsInMap().get(k).getOwner() == selectedCard.getOwner()) {
                                   friends.add(Map.getCardsInMap().get(k).getCell().getY());
                                }
                            }
                            if (friends.contains(y2)) {
                                flag_for_attack = true;
                            }
                        }

                        if (Card.getCards().get(i).getTargetArea().equals("eight_arounds")) {
                            ArrayList<Cell> around_cells = new ArrayList();
                            for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                                if (Map.getCardsInMap().get(k).getCell().getX() - x1 <= 2
                                        && Map.getCardsInMap().get(k).getCell().getY() - y1 <= 2) {
                                    around_cells.add(Map.getCardsInMap().get(k).getCell());
                                }
                            }
                            if (around_cells.contains(defender)) {
                                flag_for_attack = true;

                            }
                        }
                    }
                }
            }

            }
        }

        chechTypeOfMinion(selectedCard,defender);

        if (flag_for_attack &&  flag_for_soldier_validity ) {
            for (int i = 0; i < Map.getCardsInMap().size(); i++) {
                if (Map.getCardsInMap().contains(selectedCard)) {
                    Map.getCardsInMap().get(i).getCell().setX(x2);
                    Map.getCardsInMap().get(i).getCell().setY(y2);
                    defender.setEffect(defender,selectedCard);
                    if (defender.getType().equals("Minion")) {
                        Minion defender2= new Minion();
                        defender2=(Minion) defender;
                        defender2.setHP(-selectedCard.getAP());
                    }
                }
            }
        }
        if (!flag_for_soldier_validity) {
            System.out.println("Invalid card id");
        }
    }

    public void counterAttack(){

    }

    public void comboAttack() {
        //todo
    }

    public void useSpecialPower() {
        //todo
    }

    public void showHand() {
        currentPlayer.getMainDeck().getHand().getCards().forEach(i -> System.out.println(i.getCardID()));
    }

    public void insertCard(String cardName, int x, int y) {
        boolean flag = false;
        for (int i = 0; i < currentPlayer.getMainDeck().getHand().getCards().size(); i++) {
            if (cardName.equals(currentPlayer.getMainDeck().getHand().getCards().get(i).getName())) {
                for (Card card : Map.getCardsInMap()) {
                    if (abs(card.getCell().getX() - x) + abs(card.getCell().getY() - y) <= 1) {
                        if (game.getPlayer1() == currentPlayer) {
                            if (currentPlayer.getMainDeck().getHand().getCards().get(i).getMP() <= game.getManaPlayer1()) {
                                flag = true;
                            }
                        }
                        if (game.getPlayer2() == currentPlayer) {
                            if (currentPlayer.getMainDeck().getHand().getCards().get(i).getMP() <= game.getManaPlayer2()) {
                                flag = true;
                            }
                        }
                        if (flag) {
                            Cell cell = new Cell();
                            cell.setX(x);
                            cell.setY(y);
                            currentPlayer.getMainDeck().getHand().getCards().get(i).setCell(cell);
                            Map.addToCardsInMap(currentPlayer.getMainDeck().getHand().getCards().get(i));
                            currentPlayer.getMainDeck().getHand().removeCard(card);
                            currentPlayer.getMainDeck().removeFromCards(card);
                            currentPlayer.getMainDeck().getHand().addNewCard(currentPlayer.getMainDeck().getHand().getNextCard());
                            Random random = new Random();
                            int rand = random.nextInt(currentPlayer.getMainDeck().getCards().size());
                            currentPlayer.getMainDeck().getHand().setNextCard(currentPlayer.getMainDeck().getCards().get(rand));
                            return;
                        }
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
        for (int i = 0; i < currentPlayer.getMainDeck().getHand().getCards().size(); i++) {
            if (currentPlayer.getMainDeck().getHand().getCards().get(i).getCardID().equals(cardID)) {
                selectedCard = currentPlayer.getMainDeck().getHand().getCards().get(i);
                return;
            }
        }
        for (int i = 0; i < currentPlayer.getMainDeck().getItems().size(); i++) {
            if (currentPlayer.getMainDeck().getItems().get(i).getItemID().equals(cardID)) {
                selectedItem = currentPlayer.getMainDeck().getItems().get(i);
                return;
            }
        }
        System.out.println("Invalid card/item id");
    }

    public void enterGraveyardShowCards(GraveYard graveYard) {
        graveYard.getCards().forEach(i -> System.out.println(i.getName()));
    }

    public void enterGraveyardShowInfo(GraveYard graveYard, Card card) {
        //todo
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void showNextCard() {
        //todo hand.getNextCard
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void playRandomTurn() {
        Random random = new Random();
        int rand = random.nextInt(3);
        // 0 : insert 1 : move 2 : attack
        if(rand == 0){
            rand = random.nextInt(5);
            insertCard(currentPlayer.getMainDeck().getHand().getCards().get(5).getName(), random.nextInt(8), random.nextInt(4));
        }
        if(rand == 1){
            rand = getNumOfCardsInField(currentPlayer, random);
            int cnt = 0;
            for(int i = 0; i < Map.getCardsInMap().size(); i++){
                if (Map.getCardsInMap().get(i).getOwner().equals(currentPlayer)){
                    cnt ++;
                    if(cnt - 1 == rand){
                        setSelectedCard(Map.getCardsInMap().get(i).getCardID());
                        moveTo(random.nextInt(8), random.nextInt(4));
                    }
                }
            }
        }
        if(rand == 2){
            Player opponent = new Player();
            int cnt = 0;
            if(game.getPlayer1().equals(currentPlayer)){
                opponent = game.getPlayer2();
            }
            rand = getNumOfCardsInField(opponent, random);
            cnt = 0;
            for(int i = 0; i < Map.getCardsInMap().size(); i++){
                if (Map.getCardsInMap().get(i).getOwner().equals(opponent)){
                    cnt ++;
                    if(cnt - 1 == rand){
                        attack(Map.getCardsInMap().get(i));
                    }
                }
            }
        }
    }

    public void use(int x, int y) {
        //todo
    }

    public void showCollectables() {
        //todo
    }

    public void help() {
        //todo
    }

    public int getNumOfCardsInField(Player player, Random random){
        int cnt = 0;
        int rand;
        for(int i = 0; i < Map.getCardsInMap().size(); i++){
            if (Map.getCardsInMap().get(i).getOwner().equals(player)){
                cnt ++;
            }
        }
        rand = random.nextInt(cnt);
        return rand;
    }
}