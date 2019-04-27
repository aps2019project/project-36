package Cell;

import java.util.ArrayList;
import Collective.Buff;
import Collective.Card;
import Collective.CellEffect;

public class Cell {
    private int x;
    private int y;
    private ArrayList<Cell> cells= new ArrayList<Cell>();
    private ArrayList<Buff> Buffs= new ArrayList<Buff>();
    private ArrayList<Card> cards= new ArrayList<Card>();
    private ArrayList<CellEffect> cellEffects= new ArrayList<CellEffect>();

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
