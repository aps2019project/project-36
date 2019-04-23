package Player;

import Collective.Card;
import Collective.Item;
import java.util.ArrayList;

public class Deck {

    private static ArrayList<Deck> decks = new ArrayList<Deck>();
    private String name;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Item> items = new ArrayList<Item>();

    private Hand hand = new Hand();

    public static ArrayList<Deck> getDecks() {
        return decks;
    }

    public static void addToDecks(Deck deck) {
        decks.add(deck);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
