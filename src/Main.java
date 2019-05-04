import Battle.AccountMenu;
import Battle.Game;
import Collective.Flag;
import Player.*;
import Player.Match;
import java.util.ArrayList;
import Battle.BattleMenu;
import Shop.ShopMenu;
import java.util.Collection;
import java.util.Scanner;

public class Main
{
    static boolean EXIT = false;
    static Scanner scanner = new Scanner(System.in);
    static String input = new String();
    static Account loggedInPlayer = new Account();
    public static void main( String[] args )
    {
        /*
        while (true) {
            // in case of playing a game:
            // mode 2
            Game game = new Game();
            game.setPlayer1(player);
            game.setMode(mode);
            Match match = new Match();
            match.changeElapsedTime();
            match.setPlayer1(loggedInPlayer);
            match.setPlayer2(game.player2);
            if(Game.gameOver()){
                match.setWinner();
            }
        }
        */
        while(true){
            firstMenu();
            if (EXIT){
                return;
            }
            secondMenu();
        }
    }
    public static void firstMenu(){
        AccountMenu menu = new AccountMenu();
        menu.help();
        input = scanner.nextLine();
        if(input.compareToIgnoreCase("exit") == 0){
            EXIT = true;
        }
        if (input.length() > 15 && input.substring(0, 13).compareToIgnoreCase("create account") == 0){
            if(!Player.takenUsernames(input.substring((14)))) {
                String username = input.substring((14));
                input = scanner.nextLine();
                menu.createAccount(username, input);
            }
            else
                System.out.println("This username is already taken!");
        }
        else if(input.length() > 6 && input.substring(0, 4).compareToIgnoreCase("login") == 0){
            if(loggedInPlayer != null){
                System.out.println("Another account is logged in! Please first logout!");
            }
            if(Player.takenUsernames(input.substring((5)))) {
                String username = input.substring((5));
                input = scanner.nextLine();
                loggedInPlayer = menu.login(username, input);
            }
            else
                System.out.println("This username does not exist!");
        }
        else if(input.compareToIgnoreCase("show leaderboard") == 0){
            menu.showLeaderboard();
        }
        else if(input.compareToIgnoreCase("save") == 0){
            menu.save();
        }
        else if(input.compareToIgnoreCase("logout") == 0){
            loggedInPlayer = null;
        }
        else if(input.compareToIgnoreCase("help") == 0){
            menu.help();
        }
        if (loggedInPlayer == null){
            firstMenu();
        }
    }
    public static void secondMenu(){
        help();
        input = scanner.nextLine();
        if(input.compareToIgnoreCase("exit") == 0){
            firstMenu();
        }
        else if(input.compareToIgnoreCase("collection") == 0){
            collectionMenu();
        }
        else if(input.compareToIgnoreCase("shop") == 0){

        }
        else if(input.compareToIgnoreCase("battle") == 0){
            BattleMenu menu = new BattleMenu();
        }
        else if(input.compareToIgnoreCase("help") == 0){
            help();
        }
        secondMenu();
    }
    public static void collectionMenu(){
        collecionHelp();
        input = scanner.nextLine();
        if(input.compareToIgnoreCase("exit") == 0){
            secondMenu();
        }
        else if(input.compareToIgnoreCase("show") == 0){

        }
        else if (input.length() > 7 && input.substring(0,5).compareToIgnoreCase("search") == 0){
            int temp = loggedInPlayer.getCollection().search(input.substring(6));
            if(temp != 0){
                System.out.println(temp);
            }
            else
                System.out.println("entered card/item does not exist in this collection");
        }
        else if(input.compareToIgnoreCase("save") == 0){

        }
        else if (input.length() > 12 && input.substring(0,10).compareToIgnoreCase("create deck") == 0){
            boolean check = false;
            Deck deck = new Deck();
            deck.setName(input.substring(11));
            for(int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++){
                if(loggedInPlayer.getCollection().getDecks().get(i).getName().equals(input.substring(11))){
                    System.out.println("Deck already exists!");
                    check = true;
                }
            }
            if(!check){
                loggedInPlayer.getCollection().addToDecks(deck);
            }
        }
        else if (input.length() > 12 && input.substring(0,10).compareToIgnoreCase("delete deck") == 0){
            boolean check = false;
            for(int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++){
                if(loggedInPlayer.getCollection().getDecks().get(i).getName().equals(input.substring(11))){
                    loggedInPlayer.getCollection().getDecks().remove(i);
                    check = true;
                }
            }
            if(!check){
                System.out.println("Deck doesnt exist!");
            }
        }
        // ba regex remove & add ro bzan
        else if(input.length() > 14 && input.substring(0, 12).compareToIgnoreCase("validate deck") == 0){
            for(int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++){
                if(loggedInPlayer.getCollection().getDecks().get(i).getName().equals(input.substring(13))){
                    if(loggedInPlayer.getCollection().validateDeck(loggedInPlayer.getCollection().getDecks().get(i))){
                        System.out.println("valid");
                    }
                    else
                        System.out.println("invalid");
                    break;
                }
            }
        }
        else if(input.length() > 12 && input.substring(0, 10).compareToIgnoreCase("select deck") == 0){
            boolean check = false;
            for(int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++){
                if(loggedInPlayer.getCollection().getDecks().get(i).getName().equals(input.substring(11))){
                    loggedInPlayer.setMainDeck(loggedInPlayer.getCollection().getDecks().get(i));
                    check = true;
                }
            }
            if (!check){
                System.out.println("Deck doesnt exist!");
            }
        }
        else if(input.compareToIgnoreCase("show all decks") == 0){

        }
        else if(input.length() > 10 && input.substring(0, 8).compareToIgnoreCase("show deck") == 0){

        }
        else if(input.compareToIgnoreCase("help") == 0){
            collecionHelp();
        }
        collectionMenu();
    }
    public static void shopMenu(){
        ShopMenu menu = new ShopMenu ();
        menu.help();
        input= scanner.nextLine();
        if(input.compareToIgnoreCase("exit")== 0){
            secondMenu();
        }
        if(input.compareToIgnoreCase ("show collection")== 0){
        }
        if(input.length ()> 7 && input.substring (0,5).compareToIgnoreCase ("search")== 0){
            String name= input.substring (6);
            menu.search (name);
        }
        if(input.length ()> 18 && input.substring (0,16).compareToIgnoreCase ("search collection")== 0){
            String name= input.substring (18);
            menu.searchCollection (name,loggedInPlayer);
        }
        if(input.length()> 4 && input.substring (0,2).compareToIgnoreCase ("buy")== 0){
            String name= input.substring (3);
            menu.buy (name,loggedInPlayer);
        }
        if(input.length ()> 5 && input.substring (0,3).compareToIgnoreCase ("sell")== 0){
            String id= input.substring (4);
            menu.sell (Integer.parseInt (id));
        }
        if(input.compareToIgnoreCase ("show")== 0){
            //menu.show();
        }
        if(input.compareToIgnoreCase ("help")== 0){
            menu.help ();
        }

    }
    public static void collecionHelp(){
        System.out.println("exit");
        System.out.println("show");
        System.out.println("save");
        System.out.println("create deck");
        System.out.println("delete deck");
        System.out.println("add card to deck");
        System.out.println("remove card from deck");
        System.out.println("validate dec");
        System.out.println("select deck");
        System.out.println("show all decks");
        System.out.println("show deck");
        System.out.println("help");
    }
    public static void help(){
        System.out.println("Collection");
        System.out.println("Shop");
        System.out.println("Battle");
        System.out.println("Exit");
        System.out.println("Help");
    }

}