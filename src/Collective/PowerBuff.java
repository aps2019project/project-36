package Collective;

class PowerBuff extends Buff {
    private int APPlus;
    private int HPPlus;

    public void counterAttackOff() {
    }

    public PowerBuff(int durationTurn, boolean isDispellable
            , boolean isContinuous, int hpPlus, int apPlus) {
        super(durationTurn, isDispellable, isContinuous);
        setPositiveOrNegative(Consts.Consts.POSITIVE);
        this.HPPlus = hpPlus;
        this.APPlus = apPlus;
    }
}