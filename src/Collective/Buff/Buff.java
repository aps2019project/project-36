package Collective.Buff;

public abstract class Buff {
    private String name;
    private boolean haveAffect;
    private String positiveOrNegative;
    private int startTurn;
    private int duration;
    private boolean isDispellable;
    private boolean isContinuous;
    private boolean isActive;
    private int damagePerTurn;
    private int initialTurn;
    private int APChange;
    private int HPChange;

    public int getAPChange() {
        return APChange;
    }

    public int getHPChange() {
        return HPChange;
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
