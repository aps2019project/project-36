package Battle;


import Map.Cell;
import Player.Player;
import Menu.Menu;

public class BattleMenu {
    //mode 1 : kill competitor's hero 2: keep the only flag for six turns 3: collect half of flags
    //kind 1 : Story 2: Custom Game
    public void singlePlayerStory(Player player){

    }
    public void singlePlayerCustom(Player player, int mode, int numOfFlags){

    }

    public void multiPlayer(Player player1, Player player2, int mode, int numOfFlags){
        Battle battle = new Battle();
        Game game = new Game();
        Cell cell = new Cell();
        cell.setX(0);
        cell.setY(3);
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setManaPlayer1(2);
        game.setManaPlayer2(3);
        player1.getMainDeck().getHero().setCell(cell);
        cell.setX(8);
        player2.getMainDeck().getHero().setCell(cell);
        game.setMode(mode);
        while(game.checkIsOver() == 0){
            battle.gameInfo();
            String input = Menu.getInput();
            if (input.compareToIgnoreCase("") == 0){

            }
            battle.playTurn();
            game.setMana(1);
            game.setMana(2);
            game.changeTurn();
        }
    }
}