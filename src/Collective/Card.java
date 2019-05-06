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
    private String specialPower;

    public String getSpecialPower() {
        return specialPower;
    }

    public abstract String getType();

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void addToCards(Card card) {
        cards.add(card);
    }

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
