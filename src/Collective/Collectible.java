package Collective;

import Battle.Game;
import Map.Cell;

public class Collectible extends Item{
    private Cell cell;
    public Cell getCell() {
        return cell;
    }
    public void setCell(Cell cell) {
        this.cell = cell;
    }
}

