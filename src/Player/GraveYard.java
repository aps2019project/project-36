package Player;

import Collective.Card;
import java.util.ArrayList;

public class GraveYard {

    private ArrayList<Card> cards = new ArrayList<Card>();

    public void addNewCard(Card card) {
        cards.add(card);
    }
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void showInfo(String ID){
        //todo
    }
}
