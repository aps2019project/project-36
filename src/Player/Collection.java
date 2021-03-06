package Player;

import Collective.Card.Card;
import Collective.Item;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<> ();
    private ArrayList<String> searchedList = new ArrayList<>();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public ArrayList<String> getSearchedList() {
        return searchedList;
    }

    public String addToSearchedList (String id) {
        searchedList.add(id);
        return id;
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

    public void addToDecks(Deck deck){
        decks.add(deck);
    }

    public String search (String name) {
        for (int i = 0; i < cards.size(); i++){
            if (cards.get(i).getName().equals(name)){
                addToSearchedList(cards.get(i).getCardID());
                return cards.get(i).getCardID();
            }
        }
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getName().equals(name)){
                addToSearchedList(items.get(i).getItemID());
                return items.get(i).getItemID();
            }
        }
        return "";
    }
    public boolean validateDeck(Deck deck){
        if(deck.getCards().size() == 20 && deck.getHero() != null){
            return true;
        }
        return false;
    }
}