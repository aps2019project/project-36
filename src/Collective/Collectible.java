package Collective;

import Cell.Cell;

import java.util.ArrayList;

enum CollectibleTypes{
    MajoonMana, MajoonRoointan, NefrinMarg, RandomDamage,
    BladesofAgility, ChineseSword, JoonBaw, TirSeShakh,
    Eksir;
}

public class Collectible extends Item{
    private Cell cell;
    private ArrayList <Card> targetArea = new ArrayList<>();
    private int HP;
    private CollectibleTypes collectibletype;
    private Card owner;
    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void main(String[] args) {
        switch(collectibletype){
            case MajoonMana:
                this.owner.MP+=3;
                break;
            case MajoonRoointan:
                break;
            case NefrinMarg:
                break;
            case RandomDamage:
                break;
            case BladesofAgility:
                this.owner.AP+=6;
                break;
            case ChineseSword:
                break;
            case JoonBaw:
                this.owner.HP+=6;
                break;
            case TirSeShakh:
                break;
            case Eksir:
                break;

        }
    }



}
