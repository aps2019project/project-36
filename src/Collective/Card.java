package Collective;
import Player.Player;

public class Card {

    private int x;
    private int y;
    private int price;
    private int cardNumber;
    private String cardID;
    protected String name;
    private Player owner;
    private int HP;
    private int AP;
    private int MP;
    private int hitNumber= 0;//tedad zarbehayi ke khorde
    private boolean attacker= false; //age card hamle kone true mishe vagarna false
    private Card enemy;//cardi ke behesh hamle mikone
    private String kindOfAttack;
    private String type;

    public String getKindOfAttack() {
        return kindOfAttack;
    }

    public void setKindOfAttack(String name) {
            switch (name) {
                case "DIVESEFID":
                    kindOfAttack = "melee";
                    break;
                case "SIMORGH":
                    kindOfAttack = "melee";
                    break;
                case "EZHDEHA":
                    kindOfAttack = "melee";
                    break;
                case "RAKHSH":
                    kindOfAttack = "melee";
                    break;
                case "ZAHAK":
                    kindOfAttack = "melee";
                    break;
                case "KAVEH":
                    kindOfAttack = "melee";
                    break;
                case "ARASH":
                    kindOfAttack = "ranged";
                    break;
                case "AFSANE":
                    kindOfAttack = "ranged";
                    break;
                case "ESFANDIAR":
                    kindOfAttack = "hybrid";
                    break;
                case "ROSTAM":
                    kindOfAttack = "hybrid";
                    break; }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Card getEnemy() {
        return enemy;
    }

    public void setEnemy(Card enemy) {
        this.enemy = enemy;
    }

    public boolean isAttacker() {
        return attacker;
    }

    public void setAttacker(boolean attacker) {
        this.attacker = attacker;
    }

    public int getHitNumber() {
        return hitNumber;
    }

    public void setHitNumber(int hitNumber) {
        this.hitNumber = hitNumber;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

}
