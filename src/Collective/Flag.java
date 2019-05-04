package Collective;

import java.util.ArrayList;
import Map.Cell;

public class Flag extends Item {
    private ArrayList<Flag> flags=new ArrayList<>();
    private Cell cell;

    public void addFlag(Flag flag){}

    public ArrayList<Flag> getFlags(){
        return flags;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

}
