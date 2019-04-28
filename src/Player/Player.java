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

    public int getDaric() {
        return daric;
    }

    public void setDaric() {
        daric = Consts.getInstance().getInitialDaricNum();
    }
    public void changeDaric(int change){
        daric -= change;
    }
}