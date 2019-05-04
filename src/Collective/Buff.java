package Collective;

public class Buff {
    public enum BuffType {
        HOLY,
        DE_HOLY,
        WEAKNESS,
        STUN,
        DISARM,
        APCHANGE,
        CHAMPION_AP,
        CLEAR,
        FIRE_CELL,
        POISON_CELL,
        HOLY_CELL,
        POISON,
        ANTI,
        ANTI_ALL_POSITIVE,
        CHANGE_MANA,
        ADD_BUFF,
        DIE,
        ATTACK,
        PUTT_IN_GROUND
    }

    class PoisonBuff extends Buff {
        public void decreaseHP(Card card) {
        }
    }

    class WeaknessBuff extends Buff {
        public void decreaseHP(Card card) {
        }

        public void decreaseAP(Card card) {
        }
    }

    class StunBuff extends Buff {
        public void allOPerationsOff(Card card) {
        }
    }

    class DisarmBuff extends Buff {
        public void counterAttackOff() {
        }
    }
}
