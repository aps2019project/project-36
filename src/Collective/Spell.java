package Collective;

import Consts.Consts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spell extends Card {
    enum SpellTypes {
        TOTALDIARM, AREADISPAL, EMPOWER, FIREBALL, GODSTRENGTH, HELLFIRE,
        LIGHTINGBOLT, POISONLAKE, MADNESS, ALLDISARM, ALLPOISON, DISPEL, HEALTHWITHPROFIT,
        GHAZABOKHORJOONBEGIRI, ALLPOWER, ALLATTACK, WEAKENING, SACRIFICE, KINGSGUARD, SHOCK
    }



    public enum SpellActivationType {
        ON_CARD_INSERTION,
        ON_BATTLE_START,
        ON_CAST,
        ON_ATTACK,
        ON_DEFEND,//todo looks it is handled despite of it isn't used
        ON_DEATH,
        ON_SPAWN,
        PASSIVE
    }

    private SpellTypes spellArr[] = SpellTypes.values();
    private CellEffect effect;
    private String desc;
    private Buff.BuffType buffType;
    private int neededManna;
    private int APChange;
    private int HPChange;
    private int coolDown;
    private Target target;
    private List<Spell> addedSpells = new ArrayList<>();
    private List<Buff> addedBuffs = new ArrayList<>();
    private SpellActivationType activationType;
    private String description;
    private boolean isDispeller;
    private int number_of_simultaneous_attacks;

    public int getNumber_of_simultaneous_attacks() {
        return number_of_simultaneous_attacks;
    }



    public Spell(String id, String name, int price, int HPneededManna,
                 int APChange, int HPChange, int coolDown,
                 Target target, Buff addedBuff,
                 SpellActivationType activationType,
                 String description, boolean isDispeller) {
        super(id, name, price, HPneededManna);
        this.APChange = APChange;
        this.HPChange = HPChange;
        this.coolDown = coolDown;
        this.target = target;
        this.activationType = activationType;
        this.description = description;
        this.isDispeller = isDispeller;
        this.addedBuffs.add(addedBuff);
    }


    public String getEffect() {
        return buffType.values().toString();
    }

    public void setEffect(String buffType) {
        this.buffType = Buff.BuffType.valueOf(buffType);
    }

    public void setNeededManna(int manna) {
        neededManna = manna;
    }

    public void removeCard(int AP) {
    }

    public void setPrice(int price) {
    }

    public void setType(String type) {
    }

    public String getType(){
        return "Spell";
    }


    public Spell(String id, String name, int price, int HPneededManna,
                 int APChange, int HPChange, int coolDown,
                 Target target, List<Buff> addedBuffs,
                 SpellActivationType activationType,
                 String description, boolean isDispeller) {
        super(id, name, price, HPneededManna);
        this.APChange = APChange;
        this.HPChange = HPChange;
        this.coolDown = coolDown;
        this.target = target;
        this.activationType = activationType;
        this.description = description;
        this.isDispeller = isDispeller;
        this.addedBuffs = addedBuffs;
    }


    public Spell() {
        for (SpellTypes spell : spellArr) {
            switch (spell) {
                case TOTALDIARM:
                    setPrice(1000);
                    setNeededManna(0);
                    setTargetAreas("ONE");
                    setEffect("DISARM");
                    break;
                case AREADISPAL:
                    setPrice(1500);
                    setNeededManna(2);
                    setTargetAreas("TWO");
                    setEffect("ANTI");
                    break;
                case EMPOWER:
                    setPrice(250);
                    setNeededManna(1);
                    setTargetAreas("SELF");
                    setEffect("APCHANGE");
                    break;
                case FIREBALL:
                    setPrice(400);
                    setNeededManna(1);
                    setTargetAreas("ENEMY");
                    setEffect("ATTACK");
                    break;
                case GODSTRENGTH:
                    setPrice(450);
                    setNeededManna(2);
                    setTargetAreas("SELF");
                    setEffect("CHAMPIONAP");
                    break;
                case HELLFIRE:
                    setPrice(600);
                    setNeededManna(3);
                    setTargetAreas("TWO");
                    setEffect("STUN");
                    break;
                case LIGHTINGBOLT:
                    setPrice(1250);
                    setNeededManna(2);
                    setTargetAreas("ENEMY");
                    setEffect("ATTACK");
                    break;
                case POISONLAKE:
                    setPrice(900);
                    setNeededManna(5);
                    setTargetAreas("THREE");
                    setEffect("POISON");
                    break;
                case MADNESS:
                    setPrice(650);
                    setNeededManna(0);
                    setTargetAreas("SELF");
                    setEffect("APCHANGE");
                    setEffect("DISARM");
                    break;
                case ALLDISARM:
                    setPrice(2000);
                    setNeededManna(9);
                    setTargetAreas("ENEMY");
                    setEffect("DISARM");
                    break;
                case ALLPOISON:
                    setPrice(1500);
                    setNeededManna(8);
                    setTargetAreas("ENEMY");
                    setEffect("POISON");
                    break;
                case DISPEL:
                    setPrice(2100);
                    setNeededManna(0);
                    setTargetAreas("RANDOM");
                    setEffect("ANTI");
                    break;
                case HEALTHWITHPROFIT:
                    setPrice(2250);
                    setNeededManna(0);
                    setTargetAreas("SELF");
                    setEffect("WEAKNESS");
                    setEffect("HOLY");
                    break;
                case GHAZABOKHORJOONBEGIRI:
                    setPrice(2500);
                    setNeededManna(2);
                    setTargetAreas("SELF");
                    setEffect("POWER");
                    break;
                case ALLPOWER:
                    setPrice(2000);
                    setNeededManna(4);
                    setTargetAreas("SELF");
                    setEffect("POWER");
                    break;
                case ALLATTACK:
                    setPrice(1500);
                    setNeededManna(4);
                    setTargetAreas("ALL_IN_COLUMN");
                    setEffect("ATTACK");
                    break;
                case WEAKENING:
                    setPrice(1000);
                    setNeededManna(1);
                    setTargetAreas("MINION");
                    setTargetAreas("ENEMY");
                    setEffect("WEAKNESS");
                    break;
                case SACRIFICE:
                    setPrice(1600);
                    setNeededManna(3);
                    setTargetAreas("MINION");
                    setTargetAreas("SELF");
                    setEffect("KILL");
                    break;
                case KINGSGUARD:
                    setPrice(1750);
                    setNeededManna(3);
                    setTargetAreas("EIGHT_AROUNDS");
                    setEffect("KILL");
                    break;
                case SHOCK:
                    setPrice(1200);
                    setNeededManna(1);
                    setTargetAreas("ENEMY");
                    setEffect("STUN");
                    break;
            }
        }
    }


    public void spellEffect() {

        Target totalDisarmTarget = new Target(Consts.HERO_MINION, 1, 1, Consts.ENEMY, false, false, 0, Consts.ALL);
        DisarmBuff totalDisarmBuff = new DisarmBuff(1000, true, false);
        Spell totalDisarm = new Spell("shop_totalDisarm_1", "totalDisarm", 1000, 0, 0, 0, 0, totalDisarmTarget, totalDisarmBuff, SpellActivationType.ON_CAST, "", false);


        Target areaDispelTarget = new Target(Consts.HERO_MINION, 2, 2, Consts.ALL, false, false, 0, Consts.ALL);
        Spell areaDispel = new Spell("shop_areaDispel_1", "areaDispel", 1500, 2, 0, 0, 0, areaDispelTarget, (Buff) null, SpellActivationType.ON_CAST, "", true);


        Target empowerTarget = new Target(Consts.HERO_MINION, 1, 1, Consts.FRIEND, false, false, 0, Consts.ALL);
        Spell empower = new Spell("shop_empower_1", "empower", 250, 1, 2, 0, 0, empowerTarget, (Buff) null, SpellActivationType.ON_CAST, "", false);


        Target fireBallTarget = new Target(Consts.HERO_MINION, 1, 1, Consts.ENEMY, false, false, 0, Consts.ALL);
        Spell fireBall = new Spell("shop_fireBall_1", "fireBall", 400, 1, 0, -4, 0, fireBallTarget, (Buff) null, SpellActivationType.ON_CAST, "", false);


        Target godStrengthTarget = new Target(Consts.HERO, Integer.MAX_VALUE, Integer.MAX_VALUE, Consts.FRIEND, false, false, 0, Consts.ALL);
        Spell godStrength = new Spell("shop_godStrength_1", "godStrength", 450, 2, 4, 0, 0, godStrengthTarget, (Buff) null, SpellActivationType.ON_CAST, "", false);


        Target hellFireTarget = new Target(Consts.CELL, 2, 2, Consts.NONE, false, false, 0, Consts.NONE);
     //   Buff hellFireBuff = new Buff(2, false, false, 1);
     //   Spell hellFire = new Spell("shop_hellFire_1", "hellFire", 600, 3, 0, 0, 0, hellFireTarget, hellFireBuff, SpellActivationType.ON_CAST, "", false);


        Target lightingBoltTarget = new Target(Consts.HERO, Integer.MAX_VALUE, Integer.MAX_VALUE, Consts.ENEMY, false, false, 0, Consts.ALL);
        Spell lightingBolt = new Spell("shop_lightingBolt_1", "lightingBolt", 1250, 2, 0, -8, 0, lightingBoltTarget, (Buff) null, SpellActivationType.ON_CAST, "", false);


        Target poisonLakeTarget = new Target(Consts.CELL, 3, 3, Consts.NONE, false, false, 0, Consts.NONE);
        PoisonBuff poisonLakeBuff = new PoisonBuff(1, false, false, 1);
        Spell poisonLake = new Spell("shop_poisonLake_1", "poisonLake", 900, 5, 0, 0, 0, poisonLakeTarget, poisonLakeBuff, SpellActivationType.ON_CAST, "", false);


        Target madnessTarget = new Target(Consts.HERO_MINION, 1, 1, Consts.FRIEND, false, false, 0, Consts.ALL);
        DisarmBuff madnessBuff1 = new DisarmBuff(3, true, false);
        PowerBuff madnessBuff2 = new PowerBuff(3, true, false, 0, 4);
        List<Buff> madnessBuffs = new ArrayList<>();
        madnessBuffs.add(madnessBuff1);
        madnessBuffs.add(madnessBuff2);
        Spell madness = new Spell("shop_madness_1", "madness", 650, 0, 0, 0, 0, madnessTarget, madnessBuffs, SpellActivationType.ON_CAST, "", false);


        Target allDisarmTarget = new Target(Consts.HERO_MINION, Integer.MAX_VALUE, Integer.MAX_VALUE, Consts.ENEMY, false, false, 0, Consts.ALL);
        DisarmBuff allDisarmBuff = new DisarmBuff(1, true, false);
        Spell allDisarm = new Spell("shop_allDisarm_1", "allDisarm", 2000, 9, 0, 0, 0, allDisarmTarget, allDisarmBuff, SpellActivationType.ON_CAST, "", false);


        Target allPoisonTarget = new Target(Consts.HERO_MINION, Integer.MAX_VALUE, Integer.MAX_VALUE, Consts.ENEMY, false, false, 0, Consts.ALL);
        PoisonBuff allPoisonBuff = new PoisonBuff(4, true, false, 1);
        Spell allPoison = new Spell("shop_allPoison_1", "allPoison", 1500, 8, 0, 0, 0, allPoisonTarget, allPoisonBuff, SpellActivationType.ON_CAST, "", false);


        Target dispelTarget = new Target(Consts.HERO_MINION, 1, 1, Consts.ALL, false, false, 0, Consts.ALL);
        Spell dispel = new Spell("shop_dispel_1", "dispel", 2100, 0, 0, 0, 0, dispelTarget, (Buff) null, SpellActivationType.ON_CAST, "", true);


        Target healthWithProfitTarget = new Target(Consts.ALL, 1, 1, Consts.FRIEND, false, false, 0, Consts.ALL);
        List<Buff> healthWithProfitAddedBuffs = new ArrayList<>();
        WeaknessBuff healthWithProfitBuff1 = new WeaknessBuff(Integer.MAX_VALUE, true, false, 6, 0);
        HolyBuff healthWithProfitBuff2 = new HolyBuff(3, true, false, 2);
        healthWithProfitAddedBuffs.add(healthWithProfitBuff1);
        healthWithProfitAddedBuffs.add(healthWithProfitBuff2);
        Spell healthWithProfit = new Spell("shop_healthWithProfit_1", "healthWithProfit", 2250, 0, 0, 0, 0, healthWithProfitTarget, healthWithProfitAddedBuffs, SpellActivationType.ON_CAST, "", false);


        Target powerUpTarget = new Target(Consts.HERO_MINION, 1, 1, Consts.FRIEND, false, false, 0, Consts.ALL);
        PowerBuff powerUpBuff = new PowerBuff(Integer.MAX_VALUE, true, false, 0, 6);
        Spell powerUp = new Spell("shop_powerUp_1", "powerUp", 2500, 2, 0, 0, 0, powerUpTarget, powerUpBuff, SpellActivationType.ON_CAST, "", false);


        Target allPowerTarget = new Target(Consts.HERO_MINION, Integer.MAX_VALUE, Integer.MAX_VALUE, Consts.FRIEND, false, false, 0, Consts.ALL);
        PowerBuff allPowerBuff = new PowerBuff(Integer.MAX_VALUE, true, false, 0, 2);
        Spell allPower = new Spell("shop_allPower_1", "allPower", 200, 4, 0, 0, 0, allPowerTarget, allPowerBuff, SpellActivationType.ON_CAST, "", false);


        Target allAttackTarget = new Target(Consts.HERO_MINION, Integer.MAX_VALUE, 1, Consts.ENEMY, false, false, 0, Consts.ALL);
        Spell allAttack = new Spell("shop_allAttack_1", "allAttack", 1500, 4, 0, -6, 0, allAttackTarget, (Buff) null, SpellActivationType.ON_CAST, "", false);


        Target weakeningTarget = new Target(Consts.MINION, 1, 1, Consts.ENEMY, false, false, 0, Consts.ALL);
        WeaknessBuff weakeningBuff = new WeaknessBuff(Integer.MAX_VALUE, true, false, 0, 4);
        Spell weakening = new Spell("shop_weakening_1", "weakening", 1000, 1, 0, 0, 0, weakeningTarget, weakeningBuff, SpellActivationType.ON_CAST, "", false);


        Target sacrificeTarget = new Target(Consts.MINION, 1, 1, Consts.FRIEND, false, false, 0, Consts.ALL);
        List<Buff> sacrificeBuffs = new ArrayList<>();
        WeaknessBuff sacrificeBuff1 = new WeaknessBuff(Integer.MAX_VALUE, true, false, 6, 0);
        PowerBuff sacrificeBuff2 = new PowerBuff(Integer.MAX_VALUE, true, false, 0, 8);
        sacrificeBuffs.add(sacrificeBuff1);
        sacrificeBuffs.add(sacrificeBuff2);
        Spell sacrifice = new Spell("shop_sacrifice_1", "sacrifice", 1600, 2, 0, 0, 0, sacrificeTarget, sacrificeBuffs, SpellActivationType.ON_CAST, "", false);



        Target shockTarget = new Target(Consts.HERO_MINION, 1, 1, Consts.ENEMY, false, false, 0, Consts.ALL);
        StunBuff shockBuff = new StunBuff(2, true, false);
        Spell shock = new Spell("shop_shock_1", "shock", 1200, 1, 0, 0, 0, shockTarget, shockBuff, SpellActivationType.ON_CAST, "", false);
    }


}

