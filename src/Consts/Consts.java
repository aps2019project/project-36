package Consts;

import Collective.Card;
import Collective.Items;

public class Consts {
    private static Consts consts = null;
    private String[] usernames = {"Attacker", "Street Fighter", "King Arthas"};
    private Card[] cards;
    private Items item;

    public static Consts getInstance() {
        if(consts == null)
            consts = new Consts();
        return consts;
    }

    public String[] getUsernames() {
        return usernames;
    }

    public Card[] getCards() {
        return cards;
    }

    public Items getItem() {
        return item;
    }
}
