package Collective;

enum HeroTypes{
    DIVESEFID,SIMORGH,EZHDEHA,RAKHSH,ZAHAK,
    KAVEH,ARASH,AFSANE,EFANDIAR,ROSTAM;
}

public class Hero extends Card {
    private Spell specialPower;
    private String classType;
    private int RangeOfAttack;
    private String kindOfAttack;
    private int cooldown;

    public void removeCard(int AP){}

    public void setPrice(int price){}

    public void setTYpe(String type){}

    public String getType(){
        return classType;
    }

}
