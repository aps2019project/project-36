package Player;

import Collective.Card;
import Collective.Items;
import java.util.ArrayList;

public class Deck {

    private static ArrayList<Deck> decks = new ArrayList<Deck>();
    private String name;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Items> items = new ArrayList<Items>();

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

    public ArrayList<Items> getItems() {
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
