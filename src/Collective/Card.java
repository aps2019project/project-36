package Collective;

import Player.Player;

public class Card {
    protected int x;
    protected int y;
    protected int price;
    protected int cardNumber;
    protected String cardID;
    protected String name;
    protected Player owner;
    protected int HP;
    protected int AP;
    protected int MP;

    public int getCardNumber() {
        return cardNumber;
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

    public Player getOwner(Player player){
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


}
