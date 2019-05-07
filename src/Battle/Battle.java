package Battle;

import Collective.Buff.Buff;
import Collective.Card.Card;
import Collective.Card.Hero;
import Collective.Card.Minion.Minion;
import Collective.Card.Spell;
import Collective.Item;
import Collective.Target;
import Map.Cell;
import Map.Map;
import Player.*;

import Player.Player;
import Player.GraveYard;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        for(Card card:player.getMainDeck ().getCards ()){
            for(Card cardInMap:Map.getCardsInMap ()){
                if(card.getCardID ().compareToIgnoreCase (cardInMap.getCardID ())== 0){
                    System.out.println ("Card ID: "+ card.getName ()+ "- Health: "+card.getHP ()+"- Location: "+
                            card.getCell ().getX ()+" "+card.getCell ().getY ()+ "- Power: "+card.getAP ());
                }
            }
        }
    }

    public void showOpponentMinions(Player player) {
       for(Card cardInMap:Map.getCardsInMap ()){
           if(!(cardInMap.getOwner ().equals (player))){
               System.out.println ("Card ID: "+ cardInMap.getName ()+ "- Health: "+cardInMap.getHP ()+"- Location: "+
                       cardInMap.getCell ().getX ()+" "+cardInMap.getCell ().getY ()+ "- Power: "+cardInMap.getAP ());
           }
       }
    }

    public void showCardInfo(Card card) {
        if(card.getType ().compareToIgnoreCase ("Hero")== 0){
            System.out.println ("Hero:" );
            System.out.println ("Name: " + card.getName ());
            System.out.println ("Cost: "+card.getPrice () );
            System.out.println ("Desc: "+card.getDesc () );
        }
        else if(card.getType ().compareToIgnoreCase ("Minion")== 0){
            System.out.println ("MInion:" );
            System.out.println ("Name: " + card.getName ());
            System.out.println ("HP: " + card.getHP ());
            System.out.println ("AP: " + card.getAP ());
            System.out.println ("MP: " + card.getMP ());
            System.out.println ("Range: "+card.getTargetArea () );
           //todo System.out.println ("ComboAbility: "+card.getComboAttack );
            System.out.println ("Cost: "+card.getPrice () );
            System.out.println ("Desc: "+card.getDesc () );
        }
        else if(card.getType ().compareToIgnoreCase ("Spell")== 0){
            System.out.println ("Spell:" );
            System.out.println ("Name: " + card.getName ());
            System.out.println ("MP: " + card.getMP ());
            System.out.println ("Cost: "+card.getPrice () );
            System.out.println ("Desc: "+card.getDesc () );
        }

    }

    public void chechTypeOfMinion(Card selectedCard, Card defender) {
        if (defender.getType().equals("Minion")) {

        }
    }

    public void moveTo(int x, int y) {
        Cell cell = new Cell();
        cell.setY(y);
        cell.setX(x);
        if (abs(cell.getX() - selectedCard.getCell().getX()) +
                abs(cell.getY() - selectedCard.getCell().getY()) > 2) {
            //age betune bishtar az 2 khune bere barresi she
            selectedCard.setCell(cell);
        } else
            System.out.println("invalid target");
    }

    public void attack(Card defender) {
        Scanner scanner = new Scanner(System.in);
        String order = scanner.nextLine();
        Buff b=new Buff() {
            @Override
            public void setBuff(Card card) {
                super.setBuff(card);
            }
        };
        Pattern dataPattern = Pattern.compile("(Attack).(\\w+)");
        Matcher m = dataPattern.matcher(dataPattern.pattern());
        if (m.matches()) {
            //todo for turn
            int x1, y1, x2 = 0, y2 = 0;
            boolean flag_for_soldier_validity = false;
            boolean flag_for_attack = false;
            boolean flag_for_minion_attack = false;
            if (selectedCard.getType().equals("Minion")) {
                Minion m1 = new Minion();
                m1 = (Minion) selectedCard;
                if (m1.getCanAttack()) {
                    m1.minionEffect(defender, selectedCard,selectedCard.getType());
                    chechTypeOfMinion(selectedCard, defender);
                }
            }
            if (selectedCard.getType().equals("Hero")) {
                Hero h1 = new Hero();
                h1 = (Hero) selectedCard;
                if (h1.getCanAttack()) {
                    h1.heroEffect(defender, selectedCard);
                }
            }
            if (selectedCard.getType().equals("Spell")) {
                Spell s1 = new Spell();
                s1 = (Spell) selectedCard;
                if (s1.getCanAttack()) {
                    s1.spellEffect(defender, selectedCard);
                }
            }
            if (flag_for_minion_attack) {
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

                if (flag_for_attack && flag_for_soldier_validity) {
                    for (int i = 0; i < Map.getCardsInMap().size(); i++) {
                        if (Map.getCardsInMap().contains(selectedCard)) {
                            Map.getCardsInMap().get(i).getCell().setX(x2);
                            Map.getCardsInMap().get(i).getCell().setY(y2);
                            defender.setEffect(defender, selectedCard);
                            if (defender.getType().equals("Minion")) {
                                Minion defender2 = new Minion();
                                defender2 = (Minion) defender;
                                defender2.setHP(-selectedCard.getAP());
                                defender2.setEffect(defender,selectedCard);
                                b.setBuff(selectedCard);
                            }
                        }
                    }
                }
                if (!flag_for_soldier_validity) {
                    System.out.println("Invalid card id");
                }
            }
        }
    }

    public void counterAttack() {
    }
    //todo


    public void comboAttack() {
        Scanner scanner = new Scanner(System.in);
        String order = scanner.nextLine();
        Card defender = null;
        Buff b=new Buff() {
            @Override
            public void setBuff(Card card) {
                super.setBuff(card);
            }
        };
        ArrayList<String> cardIDs = new ArrayList<>();
        if (order.substring(0, 12).equals("Attack combo")) {
            String[] arrOfStr = order.split(" ");
            for (String a : arrOfStr)
                cardIDs.add(a);
            String defenderID = cardIDs.get(2);
            cardIDs.remove(0);
            cardIDs.remove(1);
            cardIDs.remove(2);
            for (Card c : Card.getCards()) {
                if (c.getCardID().equals(defenderID)) {
                    defender = c;
                }
            }
            int x1, y1, x2 = 0, y2 = 0;
            boolean flag_for_soldier_validity = false;
            boolean flag_for_attack = false;
            boolean flag_for_minion_attack = false;
            if (selectedCard.getType().equals("Minion")) {
                Minion m1 = new Minion();
                m1 = (Minion) selectedCard;
                if (m1.getCanAttack()) {
                    m1.minionEffect(defender, selectedCard,selectedCard.getType());
                    chechTypeOfMinion(selectedCard, defender);
                }
            }
            if (selectedCard.getType().equals("Hero")) {
                Hero h1 = new Hero();
                h1 = (Hero) selectedCard;
                if (h1.getCanAttack()) {
                    h1.heroEffect(defender, selectedCard);
                }
            }
            if (selectedCard.getType().equals("Spell")) {
                Spell s1 = new Spell();
                s1 = (Spell) selectedCard;
                if (s1.getCanAttack()) {
                    s1.spellEffect(defender, selectedCard);
                }
            }
            if (flag_for_minion_attack) {
                for (int i = 0; i < Map.getCardsInMap().size(); i++) {
                    if (Map.getCardsInMap().contains(selectedCard)) {
                        flag_for_soldier_validity = true;
                        for (int j = 0; j < Map.getCardsInMap().size(); j++) {
                            if (Map.getCardsInMap().contains(defender)) {
                                flag_for_soldier_validity = true;
                                x1 = Map.getCardsInMap().get(i).getCell().getX();
                                y1 = Map.getCardsInMap().get(i).getCell().getY();
                                for (int k = 0; k < cardIDs.size(); i++) {
                                    for (Card c : Card.getCards()) {
                                        if (c.getCardID().equals(cardIDs.get(k))) {
                                            x2 = c.getCell().getX();
                                            y2 = c.getCell().getY();
                                            Target t = new Target();
                                            t.setTargetType(defender, selectedCard, x1, x2, y1, y2);
                                        }
                                    }
                                }
                            }
                            chechTypeOfMinion(selectedCard, defender);
                            if (flag_for_attack && flag_for_soldier_validity) {
                                for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                                    if (Map.getCardsInMap().contains(selectedCard)) {
                                        Map.getCardsInMap().get(k).getCell().setX(x2);
                                        Map.getCardsInMap().get(k).getCell().setY(y2);
                                        defender.setEffect(defender, selectedCard);
                                        if (defender.getType().equals("Minion")) {
                                            Minion defender2 = new Minion();
                                            defender2 = (Minion) defender;
                                            defender2.setHP(-selectedCard.getAP());
                                            b.setBuff(selectedCard);
                                        }
                                        if (defender.getType().equals("Hero")) {
                                            Hero defender2 = new Hero();
                                            defender2 = (Hero) defender;
                                            b.setBuff(selectedCard);
                                        }

                                        if(defender.getType().equals("Spell")){
                                            Spell defender2=new Spell();
                                            defender2=(Spell) defender;
                                            b.setBuff(selectedCard);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void useSpecialPower() {
        Scanner scanner = new Scanner(System.in);
        String order = scanner.nextLine();
        Card defender = null;

        if (order.contains("On Spawn")) {
            if (Map.getCardsInMap().contains(selectedCard)) {
                selectedCard.setSpecialPowerActivated(true);
            }
        }

        if (order.contains("Passive")) {
            selectedCard.setSpecialPowerActivated(true);
        }
        if (order.contains("On Death")) {
            if (selectedCard.getHP() == 0) {
                selectedCard.setSpecialPowerActivated(true);
            }
        }

        if (order.contains("On Attack")) {
            if (selectedCard.getCanAttack()) {
                defender.setSpecialPowerActivated(true);
            }
        }

        if (order.contains("On Defend")) {
            int x1=defender.getCell().getX();
            int y1=defender.getCell().getY();
            if (selectedCard.getType().equals("Spell")|| defender.getAttacked()){
                defender.setSpecialPowerActivated(true);
            }
        }
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
                if (currentPlayer.getMainDeck().getHand().getCards().get(i).getType().equals("Minion")){
                    selectedCard = new Minion();
                }
                else if (currentPlayer.getMainDeck().getHand().getCards().get(i).getType().equals("Hero")){
                    selectedCard = new Hero();
                }
                else
                    selectedCard = new Spell();
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
        graveYard.showInfo(card.getCardID ());
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void showNextCard() {
        System.out.println("cardID : " + currentPlayer.getMainDeck().getHand().getNextCard().getCardID() + " Type : " +
                currentPlayer.getMainDeck().getHand().getNextCard().getType() + " desc" +
                currentPlayer.getMainDeck().getHand().getNextCard().getDesc());
    }

    public void setSelectedItem(Item selectedItem) { this.selectedItem = selectedItem;
    }

    public void playRandomTurn() {
        Random random = new Random();
        int rand = random.nextInt(3);
        // 0 : insert 1 : move 2 : attack
        if (rand == 0) {
            rand = random.nextInt(5);
            insertCard(currentPlayer.getMainDeck().getHand().getCards().get(5).getName(), random.nextInt(8), random.nextInt(4));
        }
        if (rand == 1) {
            rand = getNumOfCardsInField(currentPlayer, random);
            int cnt = 0;
            for (int i = 0; i < Map.getCardsInMap().size(); i++) {
                if (Map.getCardsInMap().get(i).getOwner().equals(currentPlayer)) {
                    cnt++;
                    if (cnt - 1 == rand) {
                        setSelectedCard(Map.getCardsInMap().get(i).getCardID());
                        moveTo(random.nextInt(8), random.nextInt(4));
                    }
                }
            }
        }
        if (rand == 2) {
            Player opponent = new Player();
            int cnt = 0;
            if (game.getPlayer1().equals(currentPlayer)) {
                opponent = game.getPlayer2();
            }
            rand = getNumOfCardsInField(opponent, random);
            cnt = 0;
            for (int i = 0; i < Map.getCardsInMap().size(); i++) {
                if (Map.getCardsInMap().get(i).getOwner().equals(opponent)) {
                    cnt++;
                    if (cnt - 1 == rand) {
                        attack(Map.getCardsInMap().get(i));
                    }
                }
            }
        }
    }

    public void use(Item item, int x, int y) {
        for (Card card : Map.getCardsInMap()) {
            if (card.getCell().getX() == x && card.getCell().getY() == y) {
                card.setCollectibleItem(item);
            }
        }
    }

    public void showCollectibles(Player player) {
        for (Item x : player.getCollectibles()) {
            System.out.println("Name: " + x.getName() + " - Desc:" + x.getDesc());
        }
    }

    public void help(Player player) {
        boolean cardInMap= false;
        System.out.println ("Cards you haven't played:" );
        for(Card card:player.getMainDeck ().getCards ()){
            for (Card mapCard:Map.getCardsInMap ()){
                if(card.getCardID ().compareToIgnoreCase (mapCard.getCardID ())== 0){
                    cardInMap= true;
                }
            }
            if(!cardInMap){
                System.out.println (card.getName ());
            }
            cardInMap=false;
        }

        System.out.println ();
        System.out.println ("You can move these cards:" );
        for(Card card:player.getMainDeck ().getCards ()){
            for (Card mapCard:Map.getCardsInMap ()){
                if(card.getCardID ().compareToIgnoreCase (mapCard. getCardID ())== 0){
                    System.out.println (card.getName ());
                }
            }
        }

        System.out.println ();
        System.out.println ("You can attack this cards:" );
        for(Card mapCard: Map.getCardsInMap ()){
            if(!(mapCard.getOwner ().equals (player))){
                System.out.println (mapCard.getName () );
            }
        }
    }

    public int getNumOfCardsInField(Player player, Random random) {
        int cnt = 0;
        int rand;
        for (int i = 0; i < Map.getCardsInMap().size(); i++) {
            if (Map.getCardsInMap().get(i).getOwner().equals(player)) {
                cnt++;
            }
        }
        rand = random.nextInt(cnt);
        return rand;
    }

}