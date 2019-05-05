package Collective;
import Battle.Game;

import java.util.ArrayList;



public class Collectible extends Item{
    enum CollectibleTypes {
        MAJOONMANA, MAJOswONROOINTAN, NEFRINMARG, RANDOMDAMAGE,
        BLADESOFAGILITY, CHINESESWORD, JOONBAW, TIRSESHAKH, EKSIR;
    }
    private CellEffect cell;
    private ArrayList <Card> targetArea = new ArrayList<>();
    private int HP;
    private CollectibleTypes collectibletype;
    private Card owner;
    public CellEffect getCell() {
        return cell;
    }

    public void setCell(CellEffect cell) {
        this.cell = cell;
    }
    /*public void collectibleEffect(String name, Card card, Game game) {
        switch (name) {
            case "MAJOONMANA":
                if(card.getOwner ().equals (game.getPlayer1 ())){
                    game.setManaPlayer1 (game.getManaPlayer1 ()+ 3);
                }
                else if(card.getOwner ().equals (game.getPlayer2 ())){
                    game.setManaPlayer2 (game.getManaPlayer2 ()+ 3);
                }
                break;
            case "MAJOONROOINTAN":
                activeHolyBuff(card,10);
                break;
            case "NEFRINMARG":
                break;
            case "RANDOMDAMAGE":
                break;
            case "BLADESOFAGILITY":
                card.setAP (card.getAP ()+ 6);
                break;
            case "CHINESESWORD":
                if(card.getHitNumber ()< 5){
                    card.setAP (card.getAP ()+ 5);
                }
                else{
                    card.setAP (card.getAP ()- 5);
                }
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
    }*/



}
