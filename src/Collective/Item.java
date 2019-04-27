package Collective;

import Player.Player;

import java.util.ArrayList;

public class Item {
    private String name;
    private String desc;
    private int itemID;
    private Player owner;


    public void setOwner(Player Player ) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.itemID = id;
    }

    public int getId() {
        return itemID;
    }

}

