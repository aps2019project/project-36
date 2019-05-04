package Collective;

public class Spell extends Card {
    enum SpellTypes {
        TOTALDIARM, AREADISPAL, EMPOWER, FIREBALL, GODSTRENGTH, HELLFIRE,
        LIGHTINGBOLT, POISONLAKE, MADNESS, ALLDISARM, ALLPOISON, DISPEL, HEALTHWITHPROFIT,
        GHAZABOKHORJOONBEGIRI, ALLPOWER, ALLATTACK, WEAKENING, SACRIFICE, KINGSGUARD, SHOCK;
    }

    public enum TargetArea {
        ONE,
        TWO,
        THREE,
        ALL_IN_COLUMN,
        SELF,
        ENEMY,
        RANDOM,//SELF OR ENEMY
        MINION,
        EIGHT_AROUNDS
    }

    private SpellTypes spellArr[] = SpellTypes.values();
    private CellEffect effect;
    private String desc;
    private String classType;
    private TargetArea targetArea;
    private Buff.BuffType buffType;

    public String getTargetArea() {
        return targetArea.values().toString();
    }

    public void setTargetArea(String targetArea) {
        this.targetArea = TargetArea.valueOf(targetArea);
    }

    public String getEffect() {
        return buffType.values().toString();
    }

    public void setEffect(String buffType) {
        this.buffType= Buff.BuffType.valueOf(buffType);
    }

    public void setNeededManna(int manna) {
        neededManna = manna;
    }

    public void removeCard(int AP) {
    }

    public void setPrice(int price) {
    }

    public void setType(String type) {
    }

    public String getType() {
        return classType;
    }

    public Spell() {
        for (SpellTypes spell : spellArr) {
            switch (spell) {
                case TOTALDIARM:
                    setPrice(1000);
                    setNeededManna(0);
                    setTargetArea("ONE");
                    setEffect("DISARM");
                    break;
                case AREADISPAL:
                    setPrice(1500);
                    setNeededManna(2);
                    setTargetArea("TWO");
                    setEffect("ANTI");
                    break;
                case EMPOWER:
                    setPrice(250);
                    setNeededManna(1);
                    setTargetArea("SELF");
                    setEffect("APCHANGE");
                    break;
                case FIREBALL:
                    setPrice(400);
                    setNeededManna(1);
                    setTargetArea("ENEMY");
                    setEffect("ATTACK");
                    break;
                case GODSTRENGTH:
                    setPrice(450);
                    setNeededManna(2);
                    setTargetArea("SELF");
                    setEffect("CHAMPIONAP");
                    break;
                case HELLFIRE:
                    setPrice(600);
                    setNeededManna(3);
                    setTargetArea("TWO");
                    setEffect("STUN");
                    break;
                case LIGHTINGBOLT:
                    setPrice(1250);
                    setNeededManna(2);
                    setTargetArea("ENEMY");
                    setEffect("ATTACK");
                    break;
                case POISONLAKE:
                    setPrice(900);
                    setNeededManna(5);
                    setTargetArea("THREE");
                    setEffect("POISON");
                    break;
                case MADNESS:
                    setPrice(650);
                    setNeededManna(0);
                    setTargetArea("SELF");
                    setEffect("APCHANGE");
                    setEffect("DISARM");
                    break;
                case ALLDISARM:
                    setPrice(2000);
                    setNeededManna(9);
                    setTargetArea("ENEMY");
                    setEffect("DISARM");
                    break;
                case ALLPOISON:
                    setPrice(1500);
                    setNeededManna(8);
                    setTargetArea("ENEMY");
                    setEffect("POISON");
                    break;
                case DISPEL:
                    setPrice(2100);
                    setNeededManna(0);
                    setTargetArea("RANDOM");
                    setEffect("ANTI");
                    break;
                case HEALTHWITHPROFIT:
                    setPrice(2250);
                    setNeededManna(0);
                    setTargetArea("SELF");
                    setEffect("WEAKNESS");
                    setEffect("HOLY");
                    break;
                case GHAZABOKHORJOONBEGIRI:
                    setPrice(2500);
                    setNeededManna(2);
                    setTargetArea("SELF");
                    setEffect("POWER");
                    break;
                case ALLPOWER:
                    setPrice(2000);
                    setNeededManna(4);
                    setTargetArea("SELF");
                    setEffect("POWER");
                    break;
                case ALLATTACK:
                    setPrice(1500);
                    setNeededManna(4);
                    setTargetArea("ALL_IN_COLUMN");
                    setEffect("ATTACK");
                    break;
                case WEAKENING:
                    setPrice(1000);
                    setNeededManna(1);
                    setTargetArea("MINION");
                    setTargetArea("ENEMY");
                    setEffect("WEAKNESS");
                    break;
                case SACRIFICE:
                    setPrice(1600);
                    setNeededManna(3);
                    setTargetArea("MINION");
                    setTargetArea("SELF");
                    setEffect("KILL");
                    break;
                case KINGSGUARD:
                    setPrice(1750);
                    setNeededManna(3);
                    setTargetArea("EIGHT_AROUNDS");
                    setEffect("KILL");
                    break;
                case SHOCK:
                    setPrice(1200);
                    setNeededManna(1);
                    setTargetArea("ENEMY");
                    setEffect("STUN");
                    break;
            }
        }
    }


}
