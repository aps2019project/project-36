package Collective;


public class Minion extends Card {

    protected Spell specialPower;
    protected int neededManna;
    protected int typeOfActivation;
    protected int rangeOfAttack;
    protected String typeOfImpact;


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

}
