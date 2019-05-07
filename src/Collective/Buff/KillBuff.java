package Collective.Buff;

import Collective.Card.Card;

public class KillBuff extends Buff{
    //remove that buff
    public void kill(Card card, Buff buff) {
        buff.getBuffs().remove(buff);
    }
}
