package Collective.Buff;

import java.util.ArrayList;

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

    private ArrayList<Buff> buffs = new ArrayList<>();

    public ArrayList<Buff> getBuffs() {
        return buffs;
    }

    public void addNewBuff(Buff b) {
        buffs.add(b);
    }

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
