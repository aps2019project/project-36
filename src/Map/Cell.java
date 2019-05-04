package Map;

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

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public ArrayList<Buff> getBuffs() {
        return Buffs;
    }

    public void setBuffs(ArrayList<Buff> buffs) {
        Buffs = buffs;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<CellEffect> getCellEffects() {
        return cellEffects;
    }

    public void setCellEffects(ArrayList<CellEffect> cellEffects) {
        this.cellEffects = cellEffects;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
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
