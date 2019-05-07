package Collective.Card.Minion;


import Collective.Card.Card;
import Collective.Card.Spell;

public class Minion extends Card {

    protected String specialPower;
    protected int typeOfActivation;
    protected int rangeOfAttack;
    protected String typeOfImpact;
    protected String classtype;

    public Minion() {
        this.canAttack = true;
    }

    public String getClasstype() {
        return classtype;
    }

    public boolean getCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    public int getNeededManna() {
        return neededManna;
    }


    public void move() {
    }

    public String getType() {
        return "Minion";
    }

    public void setHP(int number) {
        this.HP += number;
    }

    public void setAP(int number) {
        this.AP += number;
    }

    public int getRangeOfAttack() {
        return this.rangeOfAttack;
    }

    public void minionEffect(Card defender, Card selectedCard, String classtype) {
        if (classtype.equals("Ranged")) {
            Ranged r = new Ranged();
            r = (Ranged) selectedCard;
            r.rangedAttack(selectedCard, defender);
        }
        if (classtype.equals("Hybrid")) {
            Hybrid h = new Hybrid();
            h = (Hybrid) selectedCard;
            h.hybridattack(selectedCard, defender);
        }
        if (classtype.equals("Melee")) {
            Melee m= new Melee();
            m=(Melee) selectedCard;
            m.meleeAttack(selectedCard,defender);
        }
    }
}
