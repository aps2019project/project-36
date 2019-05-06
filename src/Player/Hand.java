package Player;

import Collective.Card.Card;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>(5);
    private Card nextCard;

    public void addNewCard(Card card) {
        cards.add(card);
    }

    public Card getNextCard() {
        return nextCard;
    }

    public void setNextCard(Card nextCard) {
        this.nextCard = nextCard;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }
}