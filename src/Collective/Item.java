package Collective;

import Player.Player;

import java.util.ArrayList;

public class Item {
    protected String name;
    protected String desc;
    protected int itemID;
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

