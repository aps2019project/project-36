package Collective.Buff;

import Collective.Card.Card;
import Collective.Card.Minion.Minion;
import Consts.Consts;

public class HolyBuff extends Buff {

    public void setHolyBuffEffect(Buff b, Card defender){
        if(b.getName().equals("Holy")){
            HolyBuff p=new HolyBuff();
            if (defender.getType().equals("Minion")) {
                Minion defender2= new Minion();
                defender2=(Minion) defender;
                defender2.setHP(b.getHPChange());
            }
        }
    }
}