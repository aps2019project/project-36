package Collective.Buff;

import Collective.Card.Card;

class DisarmBuff extends Buff {
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDisarmBuffEffect(Card defender) {
        defender.setCounterAttack(false);

    }
}



