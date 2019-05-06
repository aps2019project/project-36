package Collective.Card;

public class Hero extends Card {

    private int RangeOfAttack;
    private String kindOfAttack;
    private int coolDown;

    public int getRangeOfAttack() {
        return RangeOfAttack;
    }

    public void setRangeOfAttack(int rangeOfAttack) {
        RangeOfAttack = rangeOfAttack;
    }

    public void removeCard(int AP) {
    }

    public String getType(){
        return "Hero";
    }

    public int getCooldown() {
        return coolDown;
    }

    public void setCooldown(int cooldown) {
        this.coolDown = cooldown;
    }

    public Hero(){

    }
}
