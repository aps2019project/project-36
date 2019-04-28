package Collective;

enum HeroTypes{
    DiveSefid,Simorgh,Ezhdeha,Rakhsh,ZAhak,
    Kaveh,Arash,Afsane,Efandiar,Rostam;
}

public class Hero extends Card {

    private int MP;
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
