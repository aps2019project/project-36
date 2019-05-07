package Collective.Card.Minion;


import Collective.Card.Card;

import static java.lang.Math.abs;

public class Ranged extends Minion {

    public void rangedDefend(Card selected, Card defender) {
            if(abs(defender.getCell().getX()-selected.getCell().getX())>1 &&
                    abs(defender.getCell().getY()-selected.getCell().getY())>1){
                defender.setCanDefend(true);}
            else{
                defender.setCanDefend(false);
            }
        }

    public void rangedattack(Card selected, Card defender) {
        if((abs(defender.getCell().getX()-selected.getCell().getX())<=1 &&
                abs(defender.getCell().getY()-selected.getCell().getY())<=1)
        ){//todo(if in the range of attack)
            selected.setCanAttack(true);}
        else{
            selected.setCanAttack(false);
        }
    }
    }
