package Collective.Card.Minion;


import Collective.Card.Card;
import Collective.Target;

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

    public void rangedAttack(Card selected, Card defender) {
        if((abs(defender.getCell().getX()-selected.getCell().getX())<=1 &&
                abs(defender.getCell().getY()-selected.getCell().getY())<=1)
        ){
            selected.setCanAttack(true);}
        else{
            selected.setCanAttack(false);
        }
        Target t= new Target();
        t.setTargetType(defender,selected,defender.getCell().getX(),
                selected.getCell().getX(),defender.getCell().getY(),
                selected.getCell().getY());
    }
    }
