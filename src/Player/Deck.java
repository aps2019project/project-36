package Player;

import Collective.Card.Card;
import Collective.Card.Hero;
import Collective.Item;
import java.util.ArrayList;

public class Deck {

    private static ArrayList<Deck> decks = new ArrayList<Deck>();
    private String name;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Item> items = new ArrayList<Item>();
    private Hero hero;
    private Hand hand = new Hand();

    public Hero getHero() {
        return hero;
    }

    public void setHero(Card hero) {
        this.hero = (Hero)hero;
    }

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

    public void addToCards(Card card){
        cards.add(card);
    }

    public void addToItems(Item item){
        items.add(item);
    }

    public void removeFromCards(Card card){
        cards.remove(card);
    }

    public void removeFromItems(Item item){
        items.remove(item);
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

    public void removeItem(Item item){
        items.remove(item);
    }

    public boolean validateDeck(){
        if(this.getCards().size() == 20 && this.getHero() != null && this.getItems().size() <= 1){
            return true;
        }
        return false;
    }

    public boolean contains(Card card){
        for (Card card1:cards
        ) {
            if (card1.equals(card)){
                return true;
            }

        }
        return false;
    }

    public boolean contains(Item item){
        for (Item item1:items
             ) {
            if (item1.equals(item)){
                return true;
            }

        }
        return false;
    }
}
