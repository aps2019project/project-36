package Battle;


import Consts.Consts;
import Map.Cell;
import Map.Map;
import Player.*;
import Menu.Menu;
import Player.ComputerPlayer;

public class BattleMenu {
    //mode 1 : kill competitor's hero 2: keep the only flag for six turns 3: collect half of flags
    //kind 1 : Story 2: Custom Game
    public void singlePlayerStory(Player player){
        Match match = new Match();
        Deck tempDeck;
        tempDeck = player.getMainDeck ();
        for(int i= 1; i< 4;i++){
            Player computerPlayer= new ComputerPlayer ();
            if(i == 1){
                player.setMainDeck(Consts.getInstance().getDeckStory1());
                multiPlayer (player,computerPlayer,i,0);
                match.getWinner().changeDaric(match.getWinner().getDaric() + 500);
            }
            else if(i == 2){
                player.setMainDeck(Consts.getInstance().getDeckStory2());
                multiPlayer (player,computerPlayer,i,1);
                match.getWinner().changeDaric(match.getWinner().getDaric() + 1000);
            }
            else{
                player.setMainDeck(Consts.getInstance().getDeckStory3());
                multiPlayer (player,computerPlayer,i,7);
                match.getWinner().changeDaric(match.getWinner().getDaric() + 1500);
            }
            Map.clearMap();
        }
        player.setMainDeck (tempDeck);
    }
    public void singlePlayerCustom(Player player, int mode, int numOfFlags){
        Match match = new Match();
        ComputerPlayer player2 = new ComputerPlayer();
        multiPlayer(player, player2, mode, numOfFlags);
        match.getWinner().changeDaric(match.getWinner().getDaric() + 1000);
        Map.clearMap();
    }
    public void multiPlayer(Player player1, Player player2, int mode, int numOfFlags){
        Match match = new Match();
        Battle battle = new Battle();
        GraveYard graveYard = new GraveYard();
        Game game = new Game();
        Cell cell = new Cell();
        cell.setX(0);
        cell.setY(3);
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setManaPlayer1(2);
        game.setManaPlayer2(3);
        game.setFlags(numOfFlags);
        player1.getMainDeck().getHero().setCell(cell);
        cell.setX(8);
        player2.getMainDeck().getHero().setCell(cell);
        game.setMode(mode);
        Player currentPlayer = player1;
        while(game.checkIsOver() == 0){
            battle.gameInfo();
            String input = Menu.getInput();
            if (input.compareToIgnoreCase("Show my minions") == 0){
                battle.showMyMinions(currentPlayer);
            }
            game.setMana(1);
            game.setMana(2);
            game.changeTurn();
            if(game.getTurn() % 2 == 1){
                currentPlayer = player1;
            }
            else currentPlayer = player2;
        }
        match.getWinner().changeDaric(match.getWinner().getDaric() + 1000);
        Map.clearMap();
    }
}