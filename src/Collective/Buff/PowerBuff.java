package Collective.Buff;

import Collective.Card.Card;
import Collective.Card.Minion.Minion;

class PowerBuff extends Buff {


    public void setPowerBuffEffect(Buff b, Card defender){
        if(b.getName().equals("Power")){
            PowerBuff p=new PowerBuff();
            if (defender.getType().equals("Minion")) {
                Minion defender2= new Minion();
                defender2=(Minion) defender;
                defender2.setHP(p.getHPChange());
                defender2.setAP(p.getAPChange());
            }
        }
    }




}