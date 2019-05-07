package Battle;


import Collective.Card.Card;
import Consts.Consts;
import Map.Cell;
import Map.Map;
import Player.*;
import Menu.Menu;
import Player.ComputerPlayer;

public class BattleMenu {
    private static boolean check = false;
    //mode 1 : kill competitor's hero 2: keep the only flag for six turns 3: collect half of flags
    //kind 1 : Story 2: Custom Game
    public void singlePlayerStory(Player player){
        Match match = new Match();
        Deck tempDeck;
        tempDeck = player.getMainDeck ();
        for(int i= 1; i< 4;i++){
            Player computerPlayer= new ComputerPlayer ();
            computerPlayer.setUsername("comp");
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
        player2.setUsername("comp");
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
        while(game.checkIsOver() == 0) {
            battle.gameInfo ( );
            String input;
            String[] str;
            if (currentPlayer.getUsername ( ).equals ("comp")) {
                battle.playRandomTurn ( );
                input = "end turn";
                continue;
            } else {
                input = Menu.getInput ( );
                str = input.split (" ");
            }
            if (input.compareToIgnoreCase ("Show my minions") == 0) {
                battle.showMyMinions (currentPlayer);
            } else if (input.compareToIgnoreCase ("Show hand") == 0) {
                battle.showHand ( );
            } else if (input.length ( ) >= 5 && input.substring (0, 4).compareToIgnoreCase ("Insert") == 0) {
                String[] str1 = input.split (" ");
                battle.insertCard (str1[1], Integer.parseInt (str1[3]), Integer.parseInt (str1[4]));
            } else if (input.equals ("Show collectibles")) {
                battle.showCollectibles (player1);
            }
            //else if(input.length() >= 3 && input.substring(0,2).compareToIgnoreCase("use") == 0){
            else if (input.length ( ) >= 3 && input.substring (0, 2).compareToIgnoreCase ("use") == 0) {
                //battle.use(Integer.parseInt(str[1]), Integer.parseInt(str[2]));//todo
            } else if (input.compareToIgnoreCase ("Show Next Card") == 0) {
                battle.showNextCard ( );
            } else if (input.compareToIgnoreCase ("Enter graveyard") == 0) {
                input = Menu.getInput ( );
                String[] str1 = input.split (" ");
                //if(input.length() >= 9 && input.substring(0, 8).equals("Show info")){
//                if(str1[0].compareToIgnoreCase("show") == 0 && str1[1].compareToIgnoreCase("info") == 0){
//                    battle.enterGraveyardShowInfo(graveYard, Card.getCardByID(str1[2]));
//                }
//                else if (input.compareToIgnoreCase("Show cards") == 0){
//                    battle.enterGraveyardShowCards(graveYard);
//                }
            } else if (input.compareToIgnoreCase ("Help") == 0) {
                //battle.help();
            } else if (input.compareToIgnoreCase ("end game") == 0) {
                if (game.getPlayer1 ( ).equals (currentPlayer)) {
                    match.setWinner (game.getPlayer2 ( ));
                    check = true;
                    break;
                }
            } else if (input.compareToIgnoreCase ("end turn") == 0) {

                game.setMana (1);
                game.setMana (2);
                game.changeTurn ( );
                if (game.getTurn ( ) % 2 == 1) {
                    currentPlayer = player1;
                } else currentPlayer = player2;
            } else if (input.compareToIgnoreCase ("Show opponent minions") == 0) {
                battle.showOpponentMinions (currentPlayer);
            }
            //else if (input.length() >= 14 && input.substring(0,13).compareToIgnoreCase("Show card info") == 0){
            else if (str[0].compareToIgnoreCase ("show") == 0 && str[1].compareToIgnoreCase ("card") == 0 && str[2].compareToIgnoreCase ("info") == 0) {
                battle.showCardInfo (Card.getCardByID (str[3]));
            } else if (str[0].compareToIgnoreCase ("Select") == 0) {
                battle.setSelectedCard (str[1]);
            } else if (str[0].compareToIgnoreCase ("Move") == 0 && str[1].compareToIgnoreCase ("to") == 0) {
                battle.moveTo (Integer.parseInt (str[1]), Integer.parseInt (str[1]));
            } else if (str[0].substring (0, 5).compareToIgnoreCase ("Attack") == 0) {
                battle.attack (Card.getCardByID (str[1]));
            }
            // todo attack combo
            else if (str[0].compareToIgnoreCase ("Use") == 0 && str[1].compareToIgnoreCase ("special") == 0 && str[2].compareToIgnoreCase ("power") == 0) {
                //battle.useSpecialPower(Integer.parseInt(str[3]), Integer.parseInt(str[4]));
            }
            if (!check && game.checkIsOver ( ) == 1) {
                match.setWinner (player1);
            } else if (!check && game.checkIsOver ( ) == 2)
                match.setWinner (player2);
            Match.addToMatches (match);
            System.out.println ("winner is : " + match.getWinner ( ).getUsername ( ));
            match.getWinner ( ).changeDaric (match.getWinner ( ).getDaric ( ) + 1000);
            Map.clearMap ( );
        }
    }
}
