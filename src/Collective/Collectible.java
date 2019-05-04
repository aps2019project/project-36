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
    public Cell getCell() {
        return cell;
    }
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void collectibleEffect(String name,Card card) {
        switch(name){
            case "MAJOONMANA":
                break;
            case "MAJOswONROOINTAN":
                break;
            case "NEFRINMARG":
                break;
            case "RANDOMDAMAGE":
                break;
            case "BLADESOFAGILITY":
                break;
            case "CHINESESWORD":
                break;
            case "JOONBAW":
                break;
            case "TIRSESHAKH":
                break;
            case "EKSIR":
                if(card.getType ().compareToIgnoreCase ("hero")== 0){
                    card.setHP (card.getHP ()+3);
                    card.setAP (card.getAP ()+3);
                }
                break;
        }
    }



}
