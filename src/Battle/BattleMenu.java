package Battle;


import Collective.Flag;
import Player.Player;

public class BattleMenu {
    //mode 1 : kill competitor's hero 2: keep the only flag for six turns 3: collect half of flags
    //kind 1 : Story 2: Custom Game
    public void singlePlayerMode(Player player,int kind , int mode){
        Game game = new Game();
        game.setPlayer1(player);
        game.setMode(mode);
        if(mode == 2){
            Flag flag = new Flag();
        }
    }
}
