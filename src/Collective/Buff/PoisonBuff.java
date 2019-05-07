package Collective.Buff;

import Collective.Card.Card;
import Collective.Card.Minion.Minion;

class PoisonBuff extends Buff {
    private int numberOfTurns;
    private int damagePerTurn;

    public PoisonBuff() {
        this.numberOfTurns = 3;
    }

    public void decreaseHP(Card card) {
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns() {
       numberOfTurns--;
    }

    public void setNumberOfTurns(int number) {
        numberOfTurns=number;
    }

    public void setPoisonBuffEffect(Buff b, Card defender) {
        if (b.getName().equals("Poison") && numberOfTurns>=0) {
            PoisonBuff p = new PoisonBuff();
            if (defender.getType().equals("Minion")) {
                Minion defender2 = new Minion();
                defender2 = (Minion) defender;
                defender2.setHP(p.getHPChange());
                numberOfTurns--;
            }
        }
    }

}