package Collective;

public class StunBuff extends Buff {

        public void allOPerationsOff(Card card) {
        }

        public StunBuff(int durationTurn, boolean isDispellable, boolean isContinuous) {
            super(durationTurn, isDispellable, isContinuous);
            setPositiveOrNegative(Consts.Consts.NEGATIVE);
        }

}
