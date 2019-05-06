package Battle;


import Map.Cell;
import Player.*;
import Menu.Menu;
import Player.ComputerPlayer;

public class BattleMenu {
    //mode 1 : kill competitor's hero 2: keep the only flag for six turns 3: collect half of flags
    //kind 1 : Story 2: Custom Game
    public void singlePlayerStory(Player player){
        Deck tempDeck = new Deck();
        tempDeck = player.getMainDeck ();
        for(int i= 1; i< 4;i++){
            Player computerPlayer= new ComputerPlayer ();
            if(i== 1){
                //todo
                //player.getMainDeck ().setHero ();
                multiPlayer (player,computerPlayer,i,0);
            }
            else if(i== 2){
                multiPlayer (player,computerPlayer,i,1);
            }
            else{
                multiPlayer (player,computerPlayer,i,7);
            }

        }
        player.setMainDeck (tempDeck);

    }
    public void singlePlayerCustom(Player player, int mode, int numOfFlags){
        Match match = new Match();



        match.getWinner().changeDaric(match.getWinner().getDaric() + 1000);
    }

    public void multiPlayer(Player player1, Player player2, int mode, int numOfFlags){
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
        player1.getMainDeck().getHero().setCell(cell);
        cell.setX(8);
        player2.getMainDeck().getHero().setCell(cell);
        game.setMode(mode);
        while(game.checkIsOver() == 0){
            battle.gameInfo();
            //todo
            String input = Menu.getInput();
            if (input.compareToIgnoreCase("") == 0){

            }
            game.setMana(1);
            game.setMana(2);
            game.changeTurn();
        }
    }
}