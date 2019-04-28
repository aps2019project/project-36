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
    protected int HP;
    protected int AP;

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
