package Player;

import java.util.ArrayList;

public class Player {
    protected String username;
    protected Deck mainDeck;
}

class Account extends Player {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Deck> decks;
    private ArrayList<Match> matchHistory;
    private String password;
    private int daric;
    private Collection collection;

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }
    public static void addToAccounts(Account account) {
        accounts.add(account);
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public ArrayList<Match> getMatchHistory() {
        return matchHistory;
    }

    public void addToMatchHistory(Match match) {
        matchHistory.add(match);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDaric() {
        return daric;
    }

    public void setDaric(int daric) {
        this.daric = daric;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public Collection getCollection() {
        return collection;
    }

}