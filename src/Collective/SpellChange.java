package Collective;

public class SpellChange {
        private int turnsToApplyChange;
        private boolean positiveChange;
        private boolean applyChangeUntilEndOfTheGame;
        private boolean removeOpponentPositiveBuffs;
        private boolean removeOwnNegativeBuffs;
        private int changeAP;
        private int changeHP;
        private int changeMP;
        private boolean stunOpponent;
        private boolean disarmOpponent;
        private boolean activateHolyBuff;
        private int numOfHolyBuffs;
        private boolean activateReverseHolyBuff;
        private boolean madeCellToxic;
        private boolean madeCellHoly;
        private boolean madeCellFiery;
        private boolean deleteAllPositiveBuff;
        private boolean killing;
        private boolean dispel;
        private boolean continuous;
        private boolean currentTurn;

        public SpellChange(int turnsToApplyChange, boolean positiveChange,
                           boolean applyChangeUntilEndOfTheGame/*TimeToActivateSpecialPower timeToActivateSpecialPower*/,
                           int changeAP, int changeHP, int changeMP, boolean stunOpponent, boolean disarmOpponent,
                           boolean activateHolyBuff , boolean activateReverseHolyBuff, boolean madeCellToxic,
                           boolean madeCellHoly, boolean madeCellFiery , boolean deleteAllPositiveBuff,
                           boolean combo,boolean currentTurn)
        {
            this.turnsToApplyChange = turnsToApplyChange;
            this.positiveChange = positiveChange;
            this.applyChangeUntilEndOfTheGame = applyChangeUntilEndOfTheGame;
           // this.timeToActivateSpecialPower = timeToActivateSpecialPower;
            this.changeAP = changeAP;
            this.changeHP = changeHP;
            this.changeMP = changeMP;
            this.stunOpponent = stunOpponent;
            this.disarmOpponent = disarmOpponent;
            this.activateHolyBuff = activateHolyBuff;
            this.activateReverseHolyBuff = activateReverseHolyBuff;
            this.madeCellToxic = madeCellToxic;
            this.madeCellHoly = madeCellHoly;
            this.madeCellFiery = madeCellFiery;
            this.deleteAllPositiveBuff = deleteAllPositiveBuff;
            this.currentTurn = currentTurn;
        }

        public SpellChange(int turnsToApplyChange, boolean positiveChange, boolean applyChangeUntilEndOfTheGame,
                           int changeAP, int changeHP, int changeMP, boolean stunOpponent, boolean disarmOpponent,
                           boolean activateHolyBuff, int numOfHollyBuffs, boolean activateReverseHolyBuff,
                           boolean madeCellToxic, boolean madeCellHoly, boolean madeCellFiery,
                           boolean deleteAllPositiveBuff, boolean killing, boolean dispel, boolean continuous)
        {
            this.turnsToApplyChange = turnsToApplyChange;
            this.positiveChange = positiveChange;
            this.applyChangeUntilEndOfTheGame = applyChangeUntilEndOfTheGame;
            this.changeAP = changeAP;
            this.changeHP = changeHP;
            this.changeMP = changeMP;
            this.stunOpponent = stunOpponent;
            this.disarmOpponent = disarmOpponent;
            this.activateHolyBuff = activateHolyBuff;
            this.numOfHolyBuffs = numOfHollyBuffs;
            this.activateReverseHolyBuff = activateReverseHolyBuff;
            this.madeCellToxic = madeCellToxic;
            this.madeCellHoly = madeCellHoly;
            this.madeCellFiery = madeCellFiery;
            this.deleteAllPositiveBuff = deleteAllPositiveBuff;
            this.killing = killing;
            this.dispel = dispel;
            this.continuous = continuous;
        }

        public int getTurnsToApplyChange() {
            return turnsToApplyChange;
        }

        public void setTurnsToApplyChange(int turnsToApplyChange) {
            this.turnsToApplyChange = turnsToApplyChange;
        }

        public boolean isPositiveChange() {
            return positiveChange;
        }

        public void setPositiveChange(boolean positiveChange) {
            this.positiveChange = positiveChange;
        }

        public boolean isRemoveOpponentPositiveBuffs() {
            return removeOpponentPositiveBuffs;
        }

        public void setRemoveOpponentPositiveBuffs(boolean removeOpponentPositiveBuffs) {
            this.removeOpponentPositiveBuffs = removeOpponentPositiveBuffs;
        }

        public boolean isRemoveOwnNegativeBuffs() {
            return removeOwnNegativeBuffs;
        }

        public void setRemoveOwnNegativeBuffs(boolean removeOwnNegativeBuffs) {
            this.removeOwnNegativeBuffs = removeOwnNegativeBuffs;
        }

        public boolean isApplyChangeUntilEndOfTheGame() {
            return applyChangeUntilEndOfTheGame;
        }

        public void setApplyChangeUntilEndOfTheGame(boolean applyChangeUntilEndOfTheGame) {
            this.applyChangeUntilEndOfTheGame = applyChangeUntilEndOfTheGame;
        }

//        public TimeToActivateSpecialPower getTimeToActivateSpecialPower() {
//            return timeToActivateSpecialPower;
//        }
//
//        public void setTimeToActivateSpecialPower(TimeToActivateSpecialPower timeToActivateSpecialPower) {
//            this.timeToActivateSpecialPower = timeToActivateSpecialPower;
//        }

        public int getChangeAP() {
            return changeAP;
        }

        public void setChangeAP(int changeAP) {
            this.changeAP = changeAP;
        }

        public int getChangeHP() {
            return changeHP;
        }

        public void setChangeHP(int changeHP) {
            this.changeHP = changeHP;
        }

        public int getChangeMP() {
            return changeMP;
        }

        public void setChangeMP(int changeMP) {
            this.changeMP = changeMP;
        }

        public boolean isStunOpponent() {
            return stunOpponent;
        }

        public void setStunOpponent(boolean stunOpponent) {
            this.stunOpponent = stunOpponent;
        }

        public boolean isDisarmOpponent() {
            return disarmOpponent;
        }

        public void setDisarmOpponent(boolean disarmOpponent) {
            this.disarmOpponent = disarmOpponent;
        }

        public boolean isActivateHolyBuff() {
            return activateHolyBuff;
        }

        public void setActivateHolyBuff(boolean activateHolyBuff) {
            this.activateHolyBuff = activateHolyBuff;
        }

        public boolean isMadeCellToxic() {
            return madeCellToxic;
        }

        public void setMadeCellToxic(boolean madeCellToxic) {
            this.madeCellToxic = madeCellToxic;
        }

        public boolean isMadeCellHoly() {
            return madeCellHoly;
        }

        public void setMadeCellHoly(boolean madeCellHoly) {
            this.madeCellHoly = madeCellHoly;
        }

        public boolean isMadeCellFiery() {
            return madeCellFiery;
        }

        public void setMadeCellFiery(boolean madeCellFiery) {
            this.madeCellFiery = madeCellFiery;
        }

        public boolean isActivateReverseHolyBuff() {
            return activateReverseHolyBuff;
        }

        public void setActivateReverseHolyBuff(boolean activateReverseHolyBuff) {
            this.activateReverseHolyBuff = activateReverseHolyBuff;
        }

        public boolean isDeleteAllPositiveBuff() {
            return deleteAllPositiveBuff;
        }

        public void setDeleteAllPositiveBuff(boolean deleteAllPositiveBuff) {
            this.deleteAllPositiveBuff = deleteAllPositiveBuff;
        }

        public boolean isKilling() {
            return killing;
        }

        public void setKilling(boolean killing) {
            this.killing = killing;
        }

        public boolean isDispel() {
            return dispel;
        }

        public void setDispel(boolean dispel) {
            this.dispel = dispel;
        }

        public boolean isContinuous() {
            return continuous;
        }

        public void setContinuous(boolean continuous) {
            this.continuous = continuous;
        }

        public int getNumOfHolyBuffs() {
            return numOfHolyBuffs;
        }

        public void setNumOfHolyBuffs(int numOfHolyBuffs) {
            this.numOfHolyBuffs = numOfHolyBuffs;
        }

        public boolean isCurrentTurn() {
            return currentTurn;
        }

        public void setCurrentTurn(boolean currentTurn) {
            this.currentTurn = currentTurn;
        }
    }

