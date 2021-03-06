package Collective.Card;

import Collective.Buff.Buff;
import Collective.CellEffect;
import Collective.Target;

import java.util.ArrayList;
import java.util.List;

public class Spell extends Card {

    private CellEffect effect;
    private int APChange;
    private int HPChange;
    private int coolDown;
    private Target target;
    private List<Spell> addedSpells = new ArrayList<>();
    private List<Buff> addedBuffs = new ArrayList<>();
    private String description;
    private boolean isDispeller;
    private int number_of_simultaneous_attacks;
    private String type;
    private String spellBuffNames;

    public void setSpellBuffNames(String spellBuffNames) {
        this.spellBuffNames = spellBuffNames;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public void setAddedBuffs(List<Buff> addedBuffs) {
        this.addedBuffs = addedBuffs;
    }

    public int getNumber_of_simultaneous_attacks() {
        return number_of_simultaneous_attacks;
    }

    public void setNeededManna(int manna) {
        neededManna = manna;
    }

    public void removeCard(int AP) {
    }

    public void setPrice(int price) {
    }

    public void setType(String type) {
        this.classType= "Spell";
    }

    public String getType(){
        return "Spell";
    }


  public void spellEffect(Card defender,Card selected){
      if(selected.getType().equals("Spell")){
          selected.setEffect(defender,selected);
          selected.setTargetAreas(selected.targetArea);
      }
  }

}

