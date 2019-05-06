package Menu;

import Battle.AccountMenu;
import Collective.Card;
import Collective.Item;
import Player.*;
import Battle.BattleMenu;
import Shop.Shop;
import Shop.ShopMenu;
import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    static boolean EXIT = false;
    static Scanner scanner = new Scanner(System.in);
    static String input = new String();
    static Account loggedInPlayer = new Account();

    public static void menu(){
        while (true) {
            firstMenu();
            if (EXIT) {
                return;
            }
            secondMenu();
        }
    }

    public static void firstMenu() {
        AccountMenu menu = new AccountMenu();
        menu.help();
        input = scanner.nextLine();
        if (input.compareToIgnoreCase("exit") == 0) {
            EXIT = true;
        }
        if (input.length() > 15 && input.substring(0, 13).compareToIgnoreCase("create account") == 0) {
            if (!Player.takenUsernames(input.substring((14)))) {
                String username = input.substring((14));
                input = scanner.nextLine();
                menu.createAccount(username, input);
            } else
                System.out.println("This username is already taken!");
        } else if (input.length() > 6 && input.substring(0, 4).compareToIgnoreCase("login") == 0) {
            if (loggedInPlayer != null) {
                System.out.println("Another account is logged in! Please first logout!");
            }
            if (Player.takenUsernames(input.substring((5)))) {
                String username = input.substring((5));
                input = scanner.nextLine();
                loggedInPlayer = menu.login(username, input);
            } else
                System.out.println("This username does not exist!");
        } else if (input.compareToIgnoreCase("show leaderboard") == 0) {
            menu.showLeaderboard();
        } else if (input.compareToIgnoreCase("save") == 0) {

        } else if (input.compareToIgnoreCase("logout") == 0) {
            loggedInPlayer = null;
        } else if (input.compareToIgnoreCase("help") == 0) {
            menu.help();
        }
        if (loggedInPlayer == null) {
            firstMenu();
        }
    }

    public static void secondMenu() {
        help();
        input = scanner.nextLine();
        if (input.compareToIgnoreCase("exit") == 0) {
            firstMenu();
        } else if (input.compareToIgnoreCase("collection") == 0) {
            collectionMenu();
        } else if (input.compareToIgnoreCase("shop") == 0) {
            shopMenu();
        } else if (input.compareToIgnoreCase("battle") == 0) {
            battleMenu();
        } else if (input.compareToIgnoreCase("help") == 0) {
            help();
        }
        secondMenu();
    }

    public static void collectionMenu() {
        collecionHelp();
        input = scanner.nextLine();
        if (input.compareToIgnoreCase("exit") == 0) {
            secondMenu();
        } else if (input.compareToIgnoreCase("show") == 0) {
            //todo

        } else if (input.length() > 7 && input.substring(0, 5).compareToIgnoreCase("search") == 0) {
            String temp = loggedInPlayer.getCollection().search(input.substring(6));
            if (temp != "") {
                System.out.println(temp);
            } else
                System.out.println("entered card/item does not exist in this collection");
        } else if (input.compareToIgnoreCase("save") == 0) {

        } else if (input.length() > 12 && input.substring(0, 10).compareToIgnoreCase("create deck") == 0) {
            boolean check = false;
            Deck deck = new Deck();
            deck.setName(input.substring(11));
            for (int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++) {
                if (loggedInPlayer.getCollection().getDecks().get(i).getName().equals(input.substring(11))) {
                    System.out.println("Deck already exists!");
                    check = true;
                }
            }
            if (!check) {
                loggedInPlayer.getCollection().addToDecks(deck);
            }
        } else if (input.length() > 12 && input.substring(0, 10).compareToIgnoreCase("delete deck") == 0) {
            boolean check = false;
            for (int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++) {
                if (loggedInPlayer.getCollection().getDecks().get(i).getName().equals(input.substring(11))) {
                    loggedInPlayer.getCollection().getDecks().remove(i);
                    check = true;
                }
            }
            if (!check) {
                System.out.println("Deck doesn't exist!");
            }
        }
        else if(input.substring(0,2).compareToIgnoreCase("add") == 0 ||
                input.substring(0,5).compareToIgnoreCase("remove") == 0){
            String[] str = input.split(" ");
            outer:
            for (Deck deck: Deck.getDecks()) {
                if(deck.getName().equals(str[3])){
                    for (Card card: loggedInPlayer.getCollection().getCards()) {
                        if(card.getCardID().equals(str[2])){
                            if (card.getType().equals("Hero")){
                                if(deck.getHero() != null){
                                    if(str[0].equals("add")) {
                                        System.out.println("cannot add any hero to deck");
                                    }
                                    else{
                                        deck.setHero(null);
                                    }
                                    break outer;
                                }
                                else {
                                    deck.setHero(card);
                                    break outer;
                                }
                            }
                            if(str[0].equals("add")) {
                                deck.addToCards(card);
                                if(!deck.validateDeck()){
                                    System.out.println("cannot add any cart to deck");
                                    deck.removeFromCards(card);
                                }
                            }
                            else
                            if(deck.contains(card)) {
                                deck.removeFromCards(card);
                            }
                            else {
                                System.out.println("Deck doesn't contain this card");
                            }
                            break outer;
                        }
                    }
                    for (Item item : loggedInPlayer.getCollection().getItems()){
                        if(item.getItemID().equals(str[2])){
                            if (str[0].equals("add")) {
                                deck.addToItems(item);
                                if (!deck.validateDeck()) {
                                    System.out.println("cannot add any item to deck");
                                    deck.removeFromItems(item);
                                }
                            }
                            else {
                                if(deck.contains(item)) {
                                    deck.removeFromItems(item);
                                }
                                else {
                                    System.out.println("Deck doesn't contain this item");
                                }
                            }
                            break outer;
                        }
                    }
                    System.out.println("selected card/item is not in the collection");
                }
            }
        }
        else if(input.substring(0,5).compareToIgnoreCase("remove") == 0){
            String[] str = input.split(" ");
        }
        else if (input.length() > 14 && input.substring(0, 12).compareToIgnoreCase("validate deck") == 0) {
            for (int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++) {
                if (loggedInPlayer.getCollection().getDecks().get(i).getName().equals(input.substring(13))) {
                    if (loggedInPlayer.getCollection().validateDeck(loggedInPlayer.getCollection().getDecks().get(i))) {
                        System.out.println("valid");
                    } else
                        System.out.println("invalid");
                    break;
                }
            }
        } else if (input.length() > 12 && input.substring(0, 10).compareToIgnoreCase("select deck") == 0) {
            boolean check = false;
            for (int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++) {
                if (loggedInPlayer.getCollection().getDecks().get(i).getName().equals(input.substring(11))) {
                    loggedInPlayer.setMainDeck(loggedInPlayer.getCollection().getDecks().get(i));
                    check = true;
                }
            }
            if (!check) {
                System.out.println("Deck doesnt exist!");
            }
        } else if (input.compareToIgnoreCase("show all decks") == 0) {
            showAllDecks(loggedInPlayer);
        } else if (input.length() > 10 && input.substring(0, 8).compareToIgnoreCase("show deck") == 0) {

        } else if (input.compareToIgnoreCase("help") == 0) {
            collecionHelp();
        }
        collectionMenu();
    }

    public static void shopMenu() {
        ShopMenu menu = new ShopMenu();
        menu.help();
        input = scanner.nextLine();
        if (input.compareToIgnoreCase("exit") == 0) {
            secondMenu();
        }
        if (input.compareToIgnoreCase("show collection") == 0) {
            menu.showCollection (loggedInPlayer);
        }
        if (input.length() > 7 && input.substring(0, 5).compareToIgnoreCase("search") == 0) {
            String name = input.substring(6);
            menu.search(name);
        }
        if (input.length() > 18 && input.substring(0, 16).compareToIgnoreCase("search collection") == 0) {
            String name = input.substring(18);
            menu.searchCollection(name, loggedInPlayer);
        }
        if (input.length() > 4 && input.substring(0, 2).compareToIgnoreCase("buy") == 0) {
            String name = input.substring(3);
            menu.buy(name, loggedInPlayer);
        }
        if (input.length() > 5 && input.substring(0, 3).compareToIgnoreCase("sell") == 0) {
            //String id = input.substring(4);
            menu.sell(input.substring(4), loggedInPlayer);
        }
        if (input.compareToIgnoreCase("show") == 0) {
            menu.show ();
        }
        if (input.compareToIgnoreCase("help") == 0) {
            menu.help();
        }

    }

    public static void battleMenu() {
        BattleMenu menu = new BattleMenu();
        int mode;
        int numOfFlags = 0;
        if (!loggedInPlayer.getCollection().validateDeck(loggedInPlayer.getMainDeck())) {
            System.out.println("selected deck is invalid");
            secondMenu();
        }
        input = scanner.nextLine();
        System.out.println("single player");
        System.out.println("multi player");
        System.out.println("exit");
        if (input.compareToIgnoreCase("exit") == 0) {
            secondMenu();
        } else if (input.compareToIgnoreCase("Single player") == 0) {
            System.out.println("story");
            System.out.println("Custom game");
            input = scanner.nextLine();
            if (input.compareToIgnoreCase("story") == 0) {
                menu.singlePlayerStory(loggedInPlayer);
            } else if (input.compareToIgnoreCase("custom") == 0) {
                showAllDecks(loggedInPlayer);
                System.out.println("mode 1: kill competitor's hero");
                System.out.println("mode 2: keep the only flag for six turns");
                System.out.println("mode 3:collect half of flags");
                mode = scanner.nextInt();
                if (mode == 3)
                    numOfFlags = scanner.nextInt();
                if (mode == 2)
                    numOfFlags = 1;
                menu.singlePlayerCustom(loggedInPlayer, mode, numOfFlags);
            }
        } else if (input.compareToIgnoreCase("multi player") == 0) {
            Account.getAccounts().forEach(i -> System.out.println(i.getUsername()));
            input = scanner.nextLine();
            Player player2 = Player.findPlayerByUsername(input.substring(12));
            if (player2.getMainDeck() == null || !player2.getMainDeck().validateDeck()) {
                System.out.println("selected deck for second player is invalid");
                battleMenu();
            }
            mode = scanner.nextInt();
            if (mode == 3)
                numOfFlags = scanner.nextInt();
            if (mode == 2)
                numOfFlags = 1;
            menu.multiPlayer(loggedInPlayer, player2, mode, numOfFlags);
        }
        battleMenu();
    }

    public static void showAllDecks(Account account) {
        boolean haveMainDeck=false;
        if(account.getMainDeck ()!=null){
            System.out.println (account.getMainDeck ().getName () );
            showDeck (account.getMainDeck ());
            haveMainDeck=true;
        }
        for(Deck x:account.getDecks ()){
            if(!haveMainDeck){
                System.out.println (x.getName () );
                showDeck (x);
            }
            else if(!(x.equals (account.getMainDeck ()))){
                System.out.println (x.getName () );
                showDeck (x);
            }
        }
    }

    public static void showDeck(Deck deck){
        System.out.println ("Heroes:" );
        for(int i = 0; i< deck.getCards ().size (); i++){
            if(deck.getCards ().get(i).getType ().compareTo ("Hero")==0){
                System.out.println ((i+1) +" Name: " + deck.getCards ().get(i).getName () +" - AP: "+deck.getCards ().get(i).getAP ()+
                        " - HP: "+ deck.getCards ().get(i).getHP ()+" - Special Power: "+ deck.getCards ().get(i).getDesc () +
                        " - Buy Cost: " + deck.getCards ().get (i).getPrice ());
            }
        }
        System.out.println ("Items:" );
        for(int i= 0; i< deck.getItems ().size(); i++){
            System.out.println ((i+1) + ": Name:" + deck.getItems ().get(i).getName () + "- Desc:" + deck.getItems ().get (i).getDesc () +
                    "Buy Cost:" + deck.getItems ().get(i).getPrice ());
        }
        System.out.println ("Cards:" );
        for(int i= 0; i< deck.getCards ().size (); i++){
            if(deck.getCards ().get(i).getType ().compareTo ("Spell")== 0){
                System.out.println ((i+1) +"Type "+ deck.getCards ().get (i).getType ()+ " - Name: " +deck.getCards ().get(i).getName () +
                        " - MP: "+deck.getCards ().get(i).getMP ()+" - Class: " +deck.getCards ().getClass () +" - Description: "+
                        deck.getCards ().get(i).getDesc () + " - Buy Cost: " + deck.getCards ().get (i).getPrice ());
            }
            else if(deck.getCards ().get(i).getType ().compareTo ("Minion")== 0){
                System.out.println ((i+1) +"Type "+ deck.getCards ().get (i).getType ()+ " - Name: " +
                        deck.getCards ().get(i).getName () + " - Class: " +deck.getCards ().getClass () +
                        " - AP: "+deck.getCards ().get(i).getAP ()+" - HP: "+deck.getCards ().get (i).getHP ()+
                        " - MP"+deck.getCards ().get (i).getMP ()+" - SpecialPower: "+
                        deck.getCards ().get(i).getDesc () + " - Buy Cost: " + deck.getCards ().get (i).getPrice ());
            }
        }
    }
    public static String getInput() {
        return scanner.nextLine();
    }

    public static void collecionHelp() {
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

    public static void help() {
        System.out.println("Collection");
        System.out.println("Shop");
        System.out.println("Battle");
        System.out.println("Exit");
        System.out.println("Help");
    }
}