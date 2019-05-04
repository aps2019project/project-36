package Map;

import java.util.ArrayList;
import Collective.Buff;
import Collective.Card;
import Collective.CellEffect;
import Collective.Item;

public class Cell {
    private int x;
    private int y;
    private ArrayList<Buff> Buffs;
    private Card card;
    private Item item;
    private ArrayList<CellEffect> cellEffects;

    public int getY() {
        return y;
    }

    public ArrayList<Buff> getBuffs() {
        return Buffs;
    }

    public void setBuffs(ArrayList<Buff> buffs) {
        Buffs = buffs;
    }

    public ArrayList<CellEffect> getCellEffects() {
        return cellEffects;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setCellEffects(ArrayList<CellEffect> cellEffects) {
        this.cellEffects = cellEffects;
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
