package Consts;

import Collective.Card.Card;
import Collective.Item;
import Player.Deck;
import Shop.Shop;

public class Consts {

    private static Consts consts = null;
    private String[] usernames = {"Attacker", "Street Fighter", "King Arthas"};
    private Card[] cards;
    private Item item;
    private final int initialDaricNum = 15000;
    public static final int MONEY = 1000000;
    public static final String NONE = "none";
    public static final String ALL = "all";
    public static final String PASSIVE = "passive";
    public static final String CASTABLE = "castable";
    public static final String FRIEND = "friend";
    public static final String ENEMY = "enemy";
    public static final String HERO = "hero";
    public static final String MINION = "minion";
    public static final String HERO_MINION = "hero and minions";
    public static final String WHOLE_UNITS = "whole units";
    public static final String WHOLE_HEROES = "whole heroes";
    public static final String WHOLE_MINIONS = "whole minions";
    public static final String CELL = "cell";
    public static final String MELEE = "melee";
    public static final String RANGED = "ranged";
    public static final String HYBRID = "hybrid";
    public static final String MELEE_RANGED = "melee and ranged";
    public static final String RANGED_HYBRID = "ranged and hybrid";
    public static final String MELEE_HYBRID = "melee and hybrid";
    public static final String POSITIVE = "positive";
    public static final String NEGATIVE = "negative";
    public static final String DISARM = "disarm";
    public static final String POISON = "poison";
    public static final String ENEMY_CARD_SPELL = "enemy card spell";
    public static final String WEAKER_AP = "weaker ap";
    public static final String HOLY_BUFF = "holy buff";
    public static final Deck deckStory1 = null;
    public static final Deck deckStory2 = null;
    public static final Deck deckStory3 = null;
    public static final int height = 700, width = 1200;
    public static final int distance = 100;
    public static final int buyButtonWidth=150;
    public static final int buyButtonHeight=30;


    public static Deck getDeckStory1() {
        return deckStory1;
    }

    public static Deck getDeckStory2() {
        return deckStory2;
    }

    public static Deck getDeckStory3() {
        return deckStory3;
    }


    public static void setBattleDeck(Deck deck) {
        deck.addToCards (Shop.buyCardForStoryDeck ("WhiteDemon"));
        deck.setHero(deck.getCards().get(deck.getCards().size() - 1));
        deck.addToCards (Shop.buyCardForStoryDeck ("NaneSarma"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PersianArcher"));
        deck.addToItems (Shop.buyItemForStoryDeck ("ShahGhoul"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Eagle"));
        deck.addToCards (Shop.buyCardForStoryDeck ("TuranSpy"));
        deck.addToCards (Shop.buyCardForStoryDeck ("BlackDemon"));
        deck.addToCards (Shop.buyCardForStoryDeck ("OneEyeGiant"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PoisonedSnake"));
        deck.addToCards (Shop.buyCardForStoryDeck ("GiantCatapult"));
        deck.addToCards (Shop.buyCardForStoryDeck ("TuranPrince"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Ashkboos"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Siavash"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PersianSwordsman"));
        deck.addToCards (Shop.buyCardForStoryDeck ("LightningBolt"));
        deck.addToCards (Shop.buyCardForStoryDeck ("AllDisarm"));
        deck.addToCards (Shop.buyCardForStoryDeck ("AllPoison"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Dispel"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Sacrifice"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Shock"));
    }


    public static void setDeck1(Deck deck){
        deck.addToItems (Shop.buyItemForStoryDeck ("TajDanaei"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PersianArcher"));
        deck.addToCards (Shop.buyCardForStoryDeck ("TuranLancer"));
        deck.addToCards (Shop.buyCardForStoryDeck ("TuranWand"));
        deck.addToCards (Shop.buyCardForStoryDeck ("BlackDemon"));
        deck.addToCards (Shop.buyCardForStoryDeck ("OneEyeGiant"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PoisonedSnake"));
        deck.addToCards (Shop.buyCardForStoryDeck ("GiantCatapult"));
        deck.addToCards (Shop.buyCardForStoryDeck ("WhiteWolf"));
        deck.addToCards (Shop.buyCardForStoryDeck ("GreatMagician"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Siavash"));
        deck.addToCards (Shop.buyCardForStoryDeck ("NaneSarma"));
        deck.addToCards (Shop.buyCardForStoryDeck ("ArzhangDemon"));
        deck.addToCards (Shop.buyCardForStoryDeck ("WhiteDemon"));
        deck.addToCards (Shop.buyCardForStoryDeck ("TotalDisarm"));
        deck.addToCards (Shop.buyCardForStoryDeck ("LightningBolt"));
        deck.addToCards (Shop.buyCardForStoryDeck ("AllDisarm"));
        deck.addToCards (Shop.buyCardForStoryDeck ("AllPoison"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Dispel"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Sacrifice"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Shock"));
    }


    public static void setDeck2(Deck deck){
        deck.addToItems (Shop.buyItemForStoryDeck ("SoulEater"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PersianSwordsman"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PersianLancer"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PersianChampion"));
        deck.addToCards (Shop.buyCardForStoryDeck ("TuranSling"));
        deck.addToCards (Shop.buyCardForStoryDeck ("TuranPrince"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Eagle"));
        deck.addToCards (Shop.buyCardForStoryDeck ("FireDragon"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Tiger"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Jinn"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Giv"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Iraj"));
        deck.addToCards (Shop.buyCardForStoryDeck ("ShahGhool"));
        deck.addToCards (Shop.buyCardForStoryDeck ("AreaDispel"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Empower"));
        deck.addToCards (Shop.buyCardForStoryDeck ("GodStrength"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PoisonLake"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Madness"));
        deck.addToCards (Shop.buyCardForStoryDeck ("HealthWithProfit"));
        deck.addToCards (Shop.buyCardForStoryDeck ("KingsGuard"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Zahahk"));

    }
    public static void setDeck3(Deck deck){
        deck.addToItems (Shop.buyItemForStoryDeck ("TerrorHood"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PersianGeneral"));
        deck.addToCards (Shop.buyCardForStoryDeck ("TuranArcher"));
        deck.addToCards (Shop.buyCardForStoryDeck ("TuranSpy"));
        deck.addToCards (Shop.buyCardForStoryDeck ("GiantCatapult"));
        deck.addToCards (Shop.buyCardForStoryDeck ("HogHeadDemon"));
        deck.addToCards (Shop.buyCardForStoryDeck ("PredatorLion"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Wolf"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Magician"));
        deck.addToCards (Shop.buyCardForStoryDeck ("WildHog"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Piran"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Bahman"));
        deck.addToCards (Shop.buyCardForStoryDeck ("GiantDemon"));
        deck.addToCards (Shop.buyCardForStoryDeck ("HellFire"));
        deck.addToCards (Shop.buyCardForStoryDeck ("AllDisarm"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Dispel"));
        deck.addToCards (Shop.buyCardForStoryDeck ("GhazaBokhorJoonBegiri"));
        deck.addToCards (Shop.buyCardForStoryDeck ("AllPower"));
        deck.addToCards (Shop.buyCardForStoryDeck ("AllAttack"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Weakening"));
        deck.addToCards (Shop.buyCardForStoryDeck ("Arash"));
    }

    public static Consts getInstance() {
        if(consts == null)
            consts = new Consts();
        return consts;
    }

    public int getInitialDaricNum() {
        return initialDaricNum;
    }

    public String[] getUsernames() {
        return usernames;
    }

    public Card[] getCards() {
        return cards;
    }

    public Item getItem() {
        return item;
    }
}
