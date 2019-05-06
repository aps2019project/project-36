package Collective;

public abstract class Buff {
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

    private String positiveOrNegative;
    private int startTurn;
    private int durationTurn;
    private boolean isDispellable;
    private boolean isContinuous;
    private boolean isActive;
    private int damagePerTurn;
    private int initialTurn;

    public Buff(int durationTurn, boolean isDispellable, boolean isContinuous) {
        this.durationTurn = durationTurn;
        this.isDispellable = isDispellable;
        this.isContinuous = isContinuous;
    }

    public Buff(int durationTurn, boolean isDispellable, boolean isContinuous, int damagePerTurn) {
        this.durationTurn = durationTurn;
        this.isDispellable = isDispellable;
        this.isContinuous = isContinuous;
        this.damagePerTurn = damagePerTurn;
    }

    public void setPositiveOrNegative(String positiveOrNegative) {
        this.positiveOrNegative = positiveOrNegative;
    }

}
