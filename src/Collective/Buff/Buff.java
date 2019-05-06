package Collective.Buff;

public abstract class Buff {
    private String name;
    private boolean haveAffect;
    private String positiveOrNegative;
    private int startTurn;
    private int durationTurn;
    private boolean isDispellable;
    private boolean isContinuous;
    private boolean isActive;
    private int damagePerTurn;
    private int initialTurn;
    private int APChange;
    private int HPChange;

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

    public String getName() {
        return name;
    }

    public boolean haveAffect() {
        return haveAffect;
    }

    public String getPositiveOrNegative() {
        return positiveOrNegative;
    }



}
