package Player;

import Collective.Card;
import Collective.Item;
import Collective.Item;
import Consts.Consts;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Card> cards;
    private ArrayList<Item> items;
    private ArrayList<Deck> decks;
    private ArrayList<Integer> searchedList;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public ArrayList<Integer> getSearchedList() {
        return searchedList;
    }
    public int addToSearchedList (int id) {
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
                addToSearchedList(cards.get(i).getCardNumber());
                return cards.get(i).getCardID();
            }
        }
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getName().equals(name)){
                addToSearchedList(items.get(i).getItemNumber());
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