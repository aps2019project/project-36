package Collective;

import Player.Player;

import java.util.ArrayList;

public class Flag extends Items {
    private ArrayList<Flag> flags=new ArrayList<>();
    private CellEffect cell;

    public void addFlag(Flag flag){}

    public ArrayList<Flag> getFlags(){
        return flags;
    }

    public void setOwner(Player player){

    }

    public Player getOwner(){
        return super.getOwner();
    }

    public CellEffect getCell() {
        return cell;
    }

    public void setCell(CellEffect cell) {
        this.cell = cell;
    }

}
