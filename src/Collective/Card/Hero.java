package Collective.Card;

public class Hero extends Card {

    private int RangeOfAttack;
    private String kindOfAttack;
    private int coolDown;
    private String specialPower;

    public String getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    public void setKindOfAttack(String kindOfAttack) {
        this.kindOfAttack = kindOfAttack;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

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

    public void heroEffect(Card defender,Card selectedCard){

    }
}
