package Collective.Buff;


import Collective.Card.Card;

class PoisonBuff extends Buff {
    public void decreaseHP(Card card) {
    }

    private int damagePerTurn;

    public PoisonBuff(int durationTurn, boolean isDispellable
            , boolean isContinuous, int damagePerTurn) {
        super(durationTurn, isDispellable, isContinuous);
        this.damagePerTurn = damagePerTurn;
    }
}