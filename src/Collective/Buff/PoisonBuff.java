package Collective.Buff;


import Collective.Card.Card;
import Collective.Card.Minion.Minion;

class PoisonBuff extends Buff {
    public void decreaseHP(Card card) {
    }

    private int damagePerTurn;
    public void setHolyBuffEffect(Buff b, Card defender){
        if(b.getName().equals("Poison")){
            PoisonBuff p=new PoisonBuff();
            if (defender.getType().equals("Minion")) {
                Minion defender2= new Minion();
                defender2=(Minion) defender;
                defender2.setHP(p.getHPChange());
            }
        }
    }
}