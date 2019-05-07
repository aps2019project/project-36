package Collective.Buff;

import Collective.Card.Card;

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
    private int numberOfActivations;
    private ArrayList<Buff> buffs = new ArrayList<>();

    void setName(ArrayList<Buff> buffs) {
        for (Buff b : buffs) {
            b.name = b.getName();
        }
    }

    public void setBuff(Card card) {
        for (Buff b : buffs) {
            if (b.getName().equals("Disarm")) {
                DisarmBuff d = new DisarmBuff();
                d.setDisarmBuffEffect(card);
                d.setDuration(card.getextraIntByTypeOfBuffNeeded());
            }
            if (b.getName().equals("Kill")) {
                KillBuff k = new KillBuff();
                k.kill(card, b);
            }
            if (b.getName().equals("Holy")) {
                HolyBuff h = new HolyBuff();
                h.setHolyBuffEffect(h, card);
                h.settime(card.getextraIntByTypeOfBuffNeeded());

            }
            if (b.getName().equals("Poison")) {
                PoisonBuff p = new PoisonBuff();
                p.setPoisonBuffEffect(p, card);
                p.setNumberOfTurns(card.getextraIntByTypeOfBuffNeeded());
            }
            if (b.getName().equals("Power")) {
                PowerBuff pw = new PowerBuff();
                pw.setPowerBuffEffect(pw, card);
                pw.setDuration(card.getextraIntByTypeOfBuffNeeded());
            }
            if (b.getName().equals("Stun")) {
                StunBuff s = new StunBuff();
                s.stun(card);
                s.setDuration(card.getextraIntByTypeOfBuffNeeded());
            }
            if (b.getName().equals("Weakness")) {
                WeaknessBuff w = new WeaknessBuff();
                w.setWeaknessBuffEffect(w, card);
                w.setDuration(card.getextraIntByTypeOfBuffNeeded());
            }

        }
    }

    public int getNumberOfActivations() {
        return numberOfActivations;
    }

    public void setNumberOfActivations(int numberOfActivations) {
        this.numberOfActivations = numberOfActivations;
    }

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
