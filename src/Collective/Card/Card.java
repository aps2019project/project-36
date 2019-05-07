package Collective.Card;

import Collective.Card.Minion.Minion;
import Collective.Item;
import Map.Cell;
import Player.Player;

import java.util.ArrayList;

public abstract class Card {
    protected Cell cell;
    protected int price;
    protected String cardID;
    protected String name;
    protected Player owner;
    protected int HP;
    protected int changeHP;
    protected int AP;
    protected int MP;
    protected int neededManna;
    protected String type;
    private String buff2;
    private String buff;
    private String desc;
    private boolean counterAttack;
    private boolean canDefend;
    private boolean canAttack;
    protected static ArrayList<Card> cards = new ArrayList<>();
    protected static ArrayList<Card> card = new ArrayList<>();
    protected String targetArea;
    private String[] targetAreas = new String[]{"two", "three", " enemy", "friend", "random", "minion", "eight_arounds"};
    private Item collectibleItem;

    public Item getCollectibleItem() {
        return collectibleItem;
    }

    public void setCollectibleItem(Item collectibleItem) {
        this.collectibleItem = collectibleItem;
    }

    public String getDesc() {
        return desc;
    }

    public boolean getCanDefend() {
        return canDefend;
    }

    public void setCanDefend(boolean canDefend) {
        this.canDefend = canDefend;
    }

    public boolean getCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    public boolean getCounterAttack() {
        return counterAttack;
    }

    public void setCounterAttack(boolean counterAttack) {
        this.counterAttack = counterAttack;
    }

    public String getBuff() {
        return buff;
    }

    public String getBuff2() {
        return buff2;
    }



    public String getTargetArea() {
        return targetArea;
    }

    public abstract String getType();

    public void setTargetAreas(String nameOfTargetArea) {
        //todo
        this.targetArea = nameOfTargetArea;
    }

    public void setEffect(Card defender, Card selectedCard) {
        if (defender.getType().equals("Minion")) {
            Minion m=new Minion();
            m = (Minion) defender;
            m.minionEffect(defender, selectedCard);
        }

        if (defender.getType().equals("Spell")) {
            Spell s = new Spell();
            s = (Spell) defender;
            s.spellEffect(defender, selectedCard);
        }

        if (defender.getType().equals("Hero")) {
            Hero h = new Hero();
            h = (Hero) defender;
            h.heroEffect(defender, selectedCard);
        }
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void addToCards(Card card) {
        cards.add(card);
    }


    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getPrice() {
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public int getHP() {
        return HP;
    }


    public int getAP() {
        return AP;
    }

    public int getMP() {
        return MP;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void removeFromCards(Card card) {
        cards.remove(card);
    }

    public static Card getCardByID(String id) {
        for (Card card : cards) {
            if (card.getCardID().equals(id)) {
                return card;
            }
        }
        return null;
    }


}
