package Player;

import Consts.Consts;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    protected String username;
    protected Deck mainDeck;
    protected int daric;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public void setDaric(int daric) {
        this.daric = daric;
    }

    public int getDaric() {
        return daric;
    }

    public void setDaricPrimitive() {
        daric = Consts.getInstance().getInitialDaricNum();
    }
    public void changeDaric(int change){
        daric -= change;
    }
    public static boolean takenUsernames(String username){
        for(int i = 0; i < Account.getAccounts().size(); i++){
            if(Account.getAccounts().get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public static Player findPlayerByUsername(String username){
        for(int i = 0; i < Account.getAccounts().size(); i++){
            if(Account.getAccounts().get(i).getUsername().equals(username)){
                Account.getAccounts().get(i);
            }
        }
        return null;
    }
}