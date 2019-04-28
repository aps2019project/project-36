package Player;

import Collective.Card;

import java.util.ArrayList;

public class Match {

    private static ArrayList<Match> matches = new ArrayList<Match>();
    private ArrayList<Card> cards = new ArrayList<Card>();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player winner = new Player();
    private int elapsedTime;

    public static ArrayList<Match> getMatches() {
        return matches;
    }

    public static void addToMatches(Match match) {
        matches.add(match);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addToCards(Card card) {
        cards.add(card);
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void changeElapsedTime() {
            elapsedTime++;
    }
}