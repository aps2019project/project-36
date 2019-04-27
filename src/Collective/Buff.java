package Collective;

public class Buff {
}

class PoisonBuff extends Buff {
    public void decreaseHP(Card card){}
}

class WeaknessBuff extends Buff {
    public void decreaseHP(Card card){}
    public void decreaseAP(Card card){}
}

class StunBuff extends Buff {
    public void allOPerationsOff(Card card){}
}

class DisarmBuff extends Buff {
    public void counterAttackOff(){}
}
