package Collective;

import Map.Cell;
import Player.Player;

import java.util.ArrayList;

public abstract class Card {
    public enum AttackType {
        ON_SPAWN,
        PASSIVE,
        ON_DEATH,
        ON_ATTACK,
        ON_DEFEND,
        ON_TURN,
        COMBO,
        NONE
    }

    protected Cell cell;
    protected int price;
    protected int cardNumber;
    protected String cardID;
    protected String name;
    protected Player owner;
    protected int HP;
    protected int AP;
    protected int MP;
    protected String id;
    protected int neededMAnna;
    protected static ArrayList<Card> cards=new ArrayList<>();
    private String type;

    public abstract String getType();

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void addCards(Card card) {
        cards.add(card);
    }


    public Card(String id, String name, int price, int manna) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.neededMAnna = manna;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getCardNumber() {
        return cardNumber;
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

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public void isHero(Hero hero) {
    }

    public void isMinion(Minion minion) {
    }

    public void isSpell(Spell spell) {
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOwner(Player player) {

    }

    public Player getOwner(Player player) {
        return player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
    }

    public Card(){}


}
