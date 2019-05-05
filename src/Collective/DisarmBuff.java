package Collective;

class DisarmBuff extends Buff {
    public void counterAttackOff() {
    }

    public DisarmBuff(int durationTurn, boolean isDispellable, boolean isContinuous) {
        super(durationTurn, isDispellable, isContinuous);
        setPositiveOrNegative(Consts.Consts.NEGATIVE);
    }


}
