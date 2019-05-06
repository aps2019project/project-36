package Consts;

import Collective.Card;
import Collective.Item;
import Player.*;

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

    public static Deck getDeckStory1() {
        return deckStory1;
    }

    public static Deck getDeckStory2() {
        return deckStory2;
    }

    public static Deck getDeckStory3() {
        return deckStory3;
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
