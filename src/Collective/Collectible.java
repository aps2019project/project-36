package Collective;

import Map.Cell;

public class Collectible extends Item{
    private Cell cell;
    private int HP;
    private String collectibleType;
    public Cell getCell() {
        return cell;
    }
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void collectibleEffect(String name,Card card) {
        switch (name) {
            case "MAJOONMANA":
                break;
            case "MAJOONROOINTAN":
                break;
            case "NEFRINMARG":
                break;
            case "RANDOMDAMAGE":
                break;
            case "BLADESOFAGILITY":
                card.setAP (card.getAP ()+ 6);
                break;
            case "CHINESESWORD":
                break;
            case "JOONBAW":
                card.setHP (card.getHP ()+ 6);
                break;
            case "TIRSESHAKH":
                if(card.getKindOfAttack().compareToIgnoreCase("ranged")== 0 || card.getKindOfAttack().compareToIgnoreCase("hybrid")== 0){
                    card.setAP (card.getAP ()+2);
                }
                break;
            case "EKSIR":
                if(card.getType().compareToIgnoreCase("hero")== 0){
                    card.setHP(card.getHP()+ 3);
                    card.setAP(card.getAP()+ 3);
                }
                break;
        }
    }

}
