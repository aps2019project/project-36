package Collective.Card.Minion;


import Collective.Card.Card;

import static java.lang.Math.abs;

public class Hybrid extends Minion {

    public void hybridDefend(Card selected, Card defender) {
            defender.setCanDefend(true);
    }

    public void hybridattack(Card selected, Card defender) {
        defender.setCanDefend(true);
    }


}

