package Collective.Buff;

import Collective.Card.Card;
import Collective.Card.Minion.Minion;

public class HolyBuff extends Buff {
    private int time;

    public int gettime() {
        return time;
    }

    public void settime(int time) {
        this.time = time;
    }
    public void setHolyBuffEffect(Buff b, Card defender){
            if (defender.getType().equals("Minion")) {
                Minion defender2= new Minion();
                defender2=(Minion) defender;
                defender2.setHP(b.getHPChange());
            }
    }
}