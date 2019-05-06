package Collective.Card.Minion;


import Collective.Card.Card;
import Collective.Card.Spell;

public class Minion extends Card {

    protected Spell specialPower;
    protected int neededManna;
    protected int typeOfActivation;
    protected int rangeOfAttack;
    protected String typeOfImpact;
    protected boolean canAttack;
    protected boolean canDefend;
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

    public void minionEffect(Card defender, Card selectedCard){

    }
}
