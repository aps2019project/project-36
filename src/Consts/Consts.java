package Consts;

import Collective.Card;
import Collective.Item;

public class Consts {
    private static Consts consts = null;
    private String[] usernames = {"Attacker", "Street Fighter", "King Arthas"};
    private Card[] cards;
    private Item item;

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

    public Item getItem() {
        return item;
    }
}
