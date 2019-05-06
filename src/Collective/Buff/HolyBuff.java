package Collective.Buff;

import Consts.Consts;

public class HolyBuff extends Buff {
    private int armor;

    public HolyBuff(int durationTurn, boolean isDispellable
            , boolean isContinuous, int armor) {
        super(durationTurn, isDispellable, isContinuous);
        this.armor = armor;
    }
}