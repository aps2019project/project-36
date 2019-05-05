package Collective;

    class WeaknessBuff extends Buff {
        private int apMinus;
        private int hpMinus;
        private int HP;
        private int AP;
        public void decreaseHP(Card card) {
        }

        public void decreaseAP(Card card) {
        }

        public WeaknessBuff(int durationTurn, boolean isDispellable
                , boolean isContinuous, int hpMinus, int apMinus) {
            super(durationTurn, isDispellable, isContinuous);
            this.HP= hpMinus;
            this.AP = apMinus;
        }

        {
            setPositiveOrNegative(Consts.Consts.NEGATIVE);
        }
    }

