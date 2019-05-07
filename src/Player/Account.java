package Player;

import java.util.ArrayList;

public class Account extends Player {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private ArrayList<Match> matchHistory = new ArrayList<>();
    private String password;
    private Collection collection = new Collection();
    private GraveYard graveYard = new GraveYard();
    private int numberOfItemsOwned;

    public int getNumberOfItemsOwned() {
        return numberOfItemsOwned;
    }

    public void changeNumberOfItemsOwned(int numberOfCardsOwned) {
        this.numberOfItemsOwned = numberOfCardsOwned;
    }

    public void setNumberOfItemsOwned(){numberOfItemsOwned= 0;}

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

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public Collection getCollection() {
        return collection;
    }

    public GraveYard getGraveYard() {
        return graveYard;
    }
}