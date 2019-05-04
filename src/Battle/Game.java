package Battle;

import Map.Map;
import Player.Player;
import Player.Match;
import com.sun.tools.javac.Main;

public class Game {
    private Player player1 = new Player();
    private Player player2 = new Player();
    private int turn = 0;
    private int reachingFlag = 0;
    private int mode;

    public Player getPlayer1() {
        return player1;
    }

    public void setMode(int mode) {
        this.mode = mode;
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

    public void reachedFlag(){
        reachingFlag = turn;
    }

    public int checkIsOver(){
        if(mode == 1){
            if(player2.getMainDeck().getHero().getHP() == 0){
                return 1;
            }
            else if (player1.getMainDeck().getHero().getHP() == 0){
                return 2;
            }
        }
        if(mode == 2){
            if(reachingFlag != 0 && turn - reachingFlag >= 6){
                if(Map.getFlagsInMap().get(0).getOwner().equals(player1)){
                    return 1;
                }
                else if(Map.getFlagsInMap().get(0).getOwner().equals(player2)){
                    return 2;
                }
            }
        }
        if(mode == 3){
            int cnt1 = 0;
            int cnt2 = 0;
            for(int i = 0; i < Map.getFlagsInMap().size(); i++){
                if(Map.getFlagsInMap().get(0).getOwner().equals(player1)){
                    cnt1 ++;
                }
                else if(Map.getFlagsInMap().get(0).getOwner().equals(player2)){
                    cnt2 ++;
                }
            }
            if(cnt1 >= Map.getFlagsInMap().size()/2){
                return 1;
            }
            else if(cnt2 >= Map.getFlagsInMap().size() / 2){
                return 2;
            }
        }
        return 0;
    }
}