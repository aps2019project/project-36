package Collective.Buff;

import Collective.Card.Card;

public class StunBuff extends Buff {

    public void stun(Card card){
        card.setCounterAttack(false);
        card.setCanAttack(false);
        card.setCanDefend(false);
    }
}
