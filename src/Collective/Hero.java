package Collective;

public class Hero extends Card {

    enum HeroTypes {
        DIVESEFID, SIMORGH, EZHDEHA, RAKHSH, ZAHAK,
        KAVEH, ARASH, AFSANE, EFANDIAR, ROSTAM;
    }

    private Spell specialPower;
    private HeroTypes heroArr[] = HeroTypes.values();
    private int RangeOfAttack;
    private String kindOfAttack;
    private int cooldown;

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

    public HeroTypes[] getHeroType() {
        return heroArr;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public Hero(){

    }
}
