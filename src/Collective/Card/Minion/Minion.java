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

    public Minion(){
        this.canAttack=true;
    }

    public boolean canAttack() {
        return canAttack;
    }

    public int getNeededManna() {
        return neededManna;
    }

    public void setNeededManna(int neededManna) {
        this.neededManna = neededManna;
    }

    public void attack() {
    }

    public void move() {
    }

    public void setPrice(int price) {
    }

    public String getType() {
        return "Minion";
    }

    public void setHP(int number){
        this.HP-=number;
    }

    public int getRangeOfAttack(){
        return this.rangeOfAttack;
    }
}
