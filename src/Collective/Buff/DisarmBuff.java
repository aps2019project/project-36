package Collective.Buff;

import Collective.Card.Card;
import Collective.Card.Minion.Minion;

class DisarmBuff extends Buff {
    public int getDuration() {
        return duration;
    }

    private int duration;
    public void counterAttackOff() {
    }

    public void setHolyBuffEffect(Buff b, Card defender){
        if(b.getName().equals("Disarm")){
           // DisarmBuff p=new DisarmBuff();
            defender.setCounterAttack(false);
        }
    }



}
