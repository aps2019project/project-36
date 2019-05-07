package Collective;

import Collective.Card.Card;

public class Item {
    private String name;
    private String desc;
    private String type;
    private String itemID;
    private Card owner;
    private int price;
    private int changeHP;
    private int changeAP;
    private int changeMP;
    private int numberOfTurns;
    private boolean continuous; //if continious = true else false
    private int beginningTurn; //if in anonymous turn = 0;
    private int target; // enemy=1 & khodi=0
    private boolean activateBuff; // aya buff faal mikonad
    private int numberOfHolyfBuff;
    private int changeRange;
    private int multipleHP;
    private boolean heroTarget;
    private int numberOfEnemies;
    private int numberOfHits;
    private int numberOfWeaknessBuff;
    private int numberOfPoisonBuff;
    public int getChangeRange() {
        return changeRange;
    }

    public boolean isActivateBuff() {
        return activateBuff;
    }

    public int getNumberOfActiveBuff() {
        return numberOfHolyfBuff;
    }

    public int getChangeHP() {
        return changeHP;
    }

    public int getChangeAP() {
        return changeAP;
    }

    public int getChangeMP() {
        return changeMP;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public boolean isContinuous() {
        return continuous;
    }

    public int getBeginningTurn() {
        return beginningTurn;
    }

    public int getTarget() {
        return target;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Card getOwner() {
        return owner;
    }

    public void setOwner(Card owner) {
        this.owner = owner;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}