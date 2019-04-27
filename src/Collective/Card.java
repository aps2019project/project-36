package Collective;

import Player.Player;

public class Card {
    protected int x;
    protected int y;
    protected int price;
    protected int cardID;
    protected String cardid;
    protected String name;
    protected Player owner;

    public void isHero(Hero hero) {

    }

    public void isMinion(Minion minion) {

    }

    public void isSpell(Spell spell) {

    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type){}

}
