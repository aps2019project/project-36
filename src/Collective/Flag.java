package Collective;

import Player.Player;

import java.util.ArrayList;
import Cell.Cell;

public class Flag extends Item {
    private ArrayList<Flag> flags=new ArrayList<>();
    private Cell cell;

    public void addFlag(Flag flag){}

    public ArrayList<Flag> getFlags(){
        return flags;
    }

    public void setOwner(Player player){

    }

    public Player getOwner(){
        return super.getOwner();
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

}
