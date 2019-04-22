package Player;

import Consts.Consts;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    protected String username;
    protected Deck mainDeck;
    protected int daric;
}

class Account extends Player {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Deck> decks;
    private ArrayList<Match> matchHistory;
    private String password;
    private Collection collection;
    private GraveYard graveYard;

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
    public GraveYard getGraveYard() {
        return graveYard;
    }
}

class ComputerPlayer extends Player {

    public void setRandomDeck() {

    }

    public void setRandomUsername() {
        Random rand = new Random();
        username = Consts.getInstance().getUsernames()[rand.nextInt(3)];
    }

    public void changeDaricNum(int num) {
        daric -= num;
    }

    public int getDaric() {
        return daric;
    }

    public void setDaric(int daric) {
        this.daric = daric;
    }
}