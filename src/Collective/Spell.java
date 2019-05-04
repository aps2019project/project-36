package Collective;

import java.util.ArrayList;

public class Spell extends Card {
    enum SpellTypes {
        TOTALDIARM, AREADISPAL, EMPOWER, FIREBALL, GODSTRENGTH, HELLFIRE,
        LIGHTINGBOLT, POISONLAKE, MADNESS, ALLDISARM, ALLPOISON, DISPEL, HEALTHWITHPROFIT,
        GHAZABOKHORJOONBEGIRI, ALLPOWER, ALLATTACK, WEAKENING, SACRIFICE;
    }
    private ArrayList<Card> targetArea = new ArrayList<>();
    private CellEffect effect;
    private String desc;
    private String classType;

    public void removeCard(int AP){}
    public void setPrice(int price){}
    public void setType(String type){}
    public String getType(){
        return classType;
    }
}
