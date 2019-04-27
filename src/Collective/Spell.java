package Collective;

import java.util.ArrayList;
enum SpellTypes{
    TotalDiarm,AreaDispal,Empower,FireBall,GodStrength,HellFire,
    LightingBolt,PoisonLake,MAdness,AllDisarm,AllPoison,Dispel,HealthWithProfit,
    GhazaBokhorJoonBegiri,AllPower,AllAttack,Weakening,Sacrifice;
}
public class Spell extends Card {
    private ArrayList<Card> targetArea = new ArrayList<>();
    private CellEffect effect;
    private int MP;
    private String desc;
    private int neededManna;
    private String classType;

    public void removeCard(int AP){}
    public void setPrice(int price){}
    public void setType(String type){}
    public String getType(){
        return classType;
    }
}
