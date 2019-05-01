package Collective;

import Player.Player;


public class Usable extends Item {

    enum UsableTypes {
        SOULEATER, TAJDANAYI, NAMOOSSEPAR, KAMANDAMOOL, PARSIMORGH, TERRORHOOD,
        KINGKILLER, ASSASSINATIONDAGGER, POISONOUSDAGGER, SHOCKHAMMER, GHOSLTAMID;
    }

    private int cost;
    private UsableTypes usabletype;
    private Player owner;

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

//    public void main(String[] args) {
//        switch (usabletype) {
//            case SOULEATER:
//                break;
//            case TAJDANAYI:
//                break;
//            case NAMOOSSEPAR:
//                break;
//            case KAMANDAMOOL:
//                break;
//            case PARSIMORGH:
//                break;
//            case TERRORHOOD:
//                break;
//            case KINGKILLER:
//                break;
//            case ASSASSINATIONDAGGER:
//                break;
//            case POISONOUSDAGGER:
//                break;
//            case SHOCKHAMMER:
//                break;
//            case GHOSLTAMID:
//                break;
//
//        }
//    }

}
