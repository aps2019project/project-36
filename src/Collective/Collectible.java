package Collective;

import Map.Cell;

import java.util.ArrayList;



public class Collectible extends Item{
    enum CollectibleTypes {
        MAJOONMANA, MAJOswONROOINTAN, NEFRINMARG, RANDOMDAMAGE,
        BLADESOFAGILITY, CHINESESWORD, JOONBAW, TIRSESHAKH, EKSIR;
    }
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

//    public void main(String[] args) {
//        switch(collectibletype){
//            case MAJOONMANA:
//                this.owner.MP+=3;
//                break;
//            case MAJOswONROOINTAN:
//                break;
//            case NEFRINMARG:
//                break;
//            case RANDOMDAMAGE:
//                break;
//            case BLADESOFAGILITY:
//                this.owner.AP+=6;
//                break;
//            case CHINESESWORD:
//                break;
//            case JOONBAW:
//                this.owner.HP+=6;
//                break;
//            case TIRSESHAKH:
//                break;
//            case EKSIR:
//                this.owner.owner.getMainDeck().getHero().AP+=3;
//                this.owner.owner.getMainDeck().getHero().HP+=3;
//                break;
//
//        }
//    }
//


}
