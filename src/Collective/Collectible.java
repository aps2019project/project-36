package Collective;

import java.util.ArrayList;
import Cell.Cell;

enum CollectableTypes{
    MajoonMana, MajoonRoointan, NefrinMarg, RandomDamage,
    BladesofAgility, ChineseSword, JoonBaw, TirSeShakh,
    Eksir;
}

public class Collectable extends Item{
    private int MP ;
    private ArrayList <Card> targetArea =new ArrayList<Card>();
    private Cell cell;
    private CollectableTypes collectabletype;
    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void main(String[] args) {
        switch(collectabletype){
            case  MajoonMana:
                break;
            case MajoonRoointan:
                break;
            case NefrinMarg:
                break;
            case RandomDamage:
                break;
            case BladesofAgility:
                break;
            case ChineseSword:
                break;
            case JoonBaw:
                break;
            case TirSeShakh:
                break;
            case Eksir:
                break;
        }
    }


}
