package Collective.Buff;

import Collective.Card.Card;

public class StunBuff extends Buff {
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void stun(Card card){
        card.setCounterAttack(false);
        card.setCanAttack(false);
        card.setCanDefend(false);
    }
}
