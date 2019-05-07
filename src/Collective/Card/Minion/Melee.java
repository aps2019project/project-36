package Collective.Card.Minion;


import Collective.Card.Card;

import static java.lang.Math.abs;

public class Melee extends Minion {
    public void meleeDefend(Card selected, Card defender) {
        if (abs(defender.getCell().getX() - selected.getCell().getX()) <= 1 &&
                abs(defender.getCell().getY() - selected.getCell().getY()) <= 1) {
            defender.setCanDefend(true);
        } else {
            defender.setCanDefend(false);
        }
    }

    public void meleeAttack(Card selected, Card defender) {
        if (abs(defender.getCell().getX() - selected.getCell().getX()) <= 1 &&
                abs(defender.getCell().getY() - selected.getCell().getY()) <= 1) {
            selected.setCanAttack(true);
        } else {
            selected.setCanAttack(false);
        }
    }
}

