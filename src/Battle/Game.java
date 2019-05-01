package Battle;

import Player.Player;

public class Game {
    private Player player1 = new Player();
    private Player player2 = new Player();
    private int turn = 0;
    private int totalNumberOfFlags = -1;
    private int flagNumsOfPlayer1 = -1;
    private int flagNumsOfPlayer2 = -1;
    private int mode;

    public Player getPlayer1() {
        return player1;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setTotalNumberOfFlags(int totalNumberOfFlags) {
        this.totalNumberOfFlags = totalNumberOfFlags;
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

    public int getTurn() {
        return turn;
    }

    public void changeTurn() {
        turn++;
    }

    public int getFlagNumsOfPlayer1() {
        return flagNumsOfPlayer1;
    }

    public void setFlagNumsOfPlayer1(int flagNumsOfPlayer1) {
        this.flagNumsOfPlayer1 = flagNumsOfPlayer1;
    }

    public int getFlagNumsOfPlayer2() {
        return flagNumsOfPlayer2;
    }

    public void setFlagNumsOfPlayer2(int flagNumsOfPlayer2) {
        this.flagNumsOfPlayer2 = flagNumsOfPlayer2;
    }

    public void changeFlagNumsOfPlayer1(int change) {
        flagNumsOfPlayer1 += change;
    }
    public void changeFlagNumsOfPlayer2(int change) {
        flagNumsOfPlayer2 += change;
    }
    public void checkIsOver(){
        if(mode == 1){
            if(player2.)
        }
    }
}