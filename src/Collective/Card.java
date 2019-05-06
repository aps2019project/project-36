package Collective;

import Map.Cell;
import Player.Player;

import java.util.ArrayList;

public abstract class Card {
    protected Cell cell;
    protected int price;
    protected int cardNumber;
    protected String cardID;//todo
    protected String name;
    protected Player owner;
    protected int HP;
    protected int changeHP;
    protected int AP;
    protected int MP;
    protected String id;
    protected int neededManna;
    protected String type;
    private String desc;
    protected static ArrayList<Card> cards=new ArrayList<>();
    public abstract String getType();
    protected static ArrayList<Card> card=new ArrayList<>();
    protected String targetArea;
    private String[] targetAreas = new String[]{ "two" ,"three"," enemy", "friend", "random", "minion", "eight_arounds"};

    public String getTargetArea() {
        return targetArea;
    }

    public void setTargetAreas(String nameOfTargetArea) {
        //todo
        this.targetArea=nameOfTargetArea;
    }


    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void addCards(Card card) {
        cards.add(card);
    }

    public void setChangeHP(){

    }

    public Card(String id, String name, int price, int manna) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.neededManna = manna;
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

    public Card(){}

    public static void removeFromCards(Card card){
        cards.remove(card);
    }
    public static Card getCardByID(String id){
        for (Card card:cards) {
            if (card.getCardID().equals(id)){
                return card;
            }
        }
        return null;
    }

}
