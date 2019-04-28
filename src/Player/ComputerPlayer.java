package Player;

import Consts.Consts;

import java.util.Random;

public class ComputerPlayer extends Player {

    public void setRandomDeck() {

    }

    public void setRandomUsername() {
        Random rand = new Random();
        username = Consts.getInstance().getUsernames()[rand.nextInt(3)];
    }
}