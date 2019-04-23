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
    private ArrayList<Deck> searchedList;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void search (String name) {
        search(cards);
        search(items);
        for (int i = 0; i < cards.size(); i++){
            if (cards.get(i).getName().equals(name)){
                return cards.get(i).getId();
                addToSearchedList(cards.get(i));
            }
        }
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getName().equals(name)){
                return items.get(i).getId();
                addToSearchedList(items.get(i));
            }
        }
        return 0;
    }
    public int search(ArrayList<Colective>)
}
