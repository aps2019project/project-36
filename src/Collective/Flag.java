package Collective;

import Player.Player;

import java.util.ArrayList;
import Cell.Cell;

public class Flag extends Item {
    private ArrayList<Flag> flags=new ArrayList<>();
    private Cell cell;
    private Card owner;


    public void addFlag(Flag flag){}

    public ArrayList<Flag> getFlags(){
        return flags;
    }

    public Card getOwner() {
        return owner;
    }

    public void setOwner(Card owner) {
        this.owner = owner;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

}
