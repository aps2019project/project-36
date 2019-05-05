package Collective;


class PoisonBuff extends Buff {
    public void decreaseHP(Card card) {
    }

    private int damagePerTurn;

    public PoisonBuff(int durationTurn, boolean isDispellable
            , boolean isContinuous, int damagePerTurn) {
        super(durationTurn, isDispellable, isContinuous);
        setPositiveOrNegative(Consts.Consts.NEGATIVE);
        this.damagePerTurn = damagePerTurn;
    }
}