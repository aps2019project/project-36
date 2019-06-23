package Battle;

import Collective.Collectible;
import Collective.Flag;
import Map.*;
import Player.Player;
import Player.Match;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player player1 = new Player();
    private Player player2 = new Player();
    private int turn = 1;
    private int reachingFlag = 0;
    private int mode;
    private int manaPlayer1;
    private int manaPlayer2;

    public int getManaPlayer1() {
        return manaPlayer1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setManaPlayer1(int manaPlayer1) {
        this.manaPlayer1 = manaPlayer1;
    }

    public int getManaPlayer2() {
        return manaPlayer2;
    }

    public void setManaPlayer2(int manaPlayer2) {
        this.manaPlayer2 = manaPlayer2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public int getTurn() {
        return turn;
    }

    public void changeTurn() {
        turn++;
    }

    public void setMana(int a){
        if (turn >= 14){
            if(a == 1){
                manaPlayer1 = 9;
            }
            else
                manaPlayer2 = 9;
        }
        if(a == 1){
            manaPlayer1 = turn / 2 + 2;
        }
        else
            manaPlayer2 = turn / 2 + 2;
    }
    public void reachedFlag(){
        reachingFlag = turn;
    }

    public int getMode() {
        return mode;
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
                if(Map.getFlagsInMap().get(0).getOwner().getOwner().equals(player1)){
                    cnt1 ++;
                }
                else if(Map.getFlagsInMap().get(0).getOwner().getOwner().equals(player2)){
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

    public void setFlags(int numOfFlags){
        if(numOfFlags == 1){
            Cell cell = new Cell();
            cell.setX(5);
            cell.setY(3);
            Map.addToFlagsInMap(cell);
        }
        if(numOfFlags > 1){
            Random random = new Random();
            if(numOfFlags % 2 == 1){
                setFlags(1);
            }
            for (int i = 0; i < numOfFlags/2; i++){
                Cell cell = new Cell();
                cell.setX(random.nextInt(4));
                cell.setY(random.nextInt(3));
                Map.addToFlagsInMap(cell);
                cell.setX(random.nextInt(4));
                cell.setY(8 - random.nextInt(3));
            }
        }
    }
}