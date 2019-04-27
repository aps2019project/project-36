package Collective;

import Player.Player;

enum UsableTypes {
    SoulEater,TajDanayi,NamoosSepar,KamanDamool,ParSimorgh,TerrorHood,
    KingKiller,AssassinationDagger,PoisonousDagger,ShockHammer,GhoslTamid;
}

public class Usable extends Item {
    private int cost;
    private UsableTypes usabletype;
    private Player owner;

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void main(String[] args) {
        switch(usabletype){
            case  SoulEater:
                break;
            case TajDanayi:
                break;
            case NamoosSepar:
                break;
            case KamanDamool:
                break;
            case ParSimorgh:
                break;
            case TerrorHood:
                break;
            case KingKiller:
                break;
            case AssassinationDagger:
                break;
            case PoisonousDagger:
                break;
            case ShockHammer:
                break;
            case GhoslTamid:
                break;

        }
    }

}
