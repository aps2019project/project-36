package Collective.Buff;

import Collective.Card.Card;
import Collective.Card.Minion.Minion;

class WeaknessBuff extends Buff {
    public void setHolyBuffEffect(Buff b, Card defender){
        if(b.getName().equals("Weakness")){
            WeaknessBuff p=new WeaknessBuff();
            int random = (int)(Math. random() * 2 + 1);
            if (defender.getType().equals("Minion")) {
                Minion defender2= new Minion();
                defender2=(Minion) defender;
                if(random==1) {
                    defender2.setAP(b.getAPChange());
                }
                if(random==2){
                    defender2.setHP(b.getHPChange());
                }
            }
        }
    }

}

