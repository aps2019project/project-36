package Menu;

import Battle.AccountMenu;
import Collective.Card.Card;
import Collective.Item;
import Player.*;
import Battle.BattleMenu;
import Shop.ShopMenu;

import java.util.Scanner;

public class Menu {

    static boolean EXIT = false;
    static Scanner scanner = new Scanner(System.in);
    static String input = new String();
    static Account loggedInPlayer = null;

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
        String[] str = input.split(" ");
        if (input.compareToIgnoreCase("exit") == 0) {
            EXIT = true;
        }
        else if(str[0].compareToIgnoreCase("login")==0){
            if (loggedInPlayer != null) {
                System.out.println("Another account is logged in! Please first logout!");
            }
            if (Player.takenUsernames(str[1])) {
                String username = str[1];
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
        else if (str[0].compareToIgnoreCase("create")==0 && str[1].compareToIgnoreCase("account")==0){
            if (!Player.takenUsernames(str[2])) {
                String username = str[2];
                System.out.println("enter pass");
                input = scanner.nextLine();
                menu.createAccount(username, input);
            } else
                System.out.println("This username is already taken!");
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
        String[] str = input.split(" ");
        if (input.compareToIgnoreCase("exit") == 0) {
            secondMenu();
        }
        else if (input.compareToIgnoreCase("show all decks") == 0) {
            showAllDecks(loggedInPlayer);
        }
        else if (input.compareToIgnoreCase("help") == 0) {
            collecionHelp();
        }else if (input.compareToIgnoreCase("show") == 0) {

            //todo

        } //else if (input.length() > 7 && input.substring(0, 5).compareToIgnoreCase("search") == 0) {
        else if(str[0].equals("search")){
            String temp = loggedInPlayer.getCollection().search(str[1]);
            if (temp != "") {
                System.out.println(temp);
            } else
                System.out.println("entered card/item does not exist in this collection");
        } else if (input.compareToIgnoreCase("save") == 0) {

        }
        else if(str[0].compareToIgnoreCase("create")==0 && str[1].compareToIgnoreCase("deck")==0){
            boolean check = false;
            Deck deck = new Deck();
            deck.setName(str[2]);
            for (int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++) {
                if (loggedInPlayer.getCollection().getDecks().get(i).getName().equals(str[2])) {
                    System.out.println("Deck already exists!");
                    check = true;
                }
            }
            if (!check) {
                loggedInPlayer.getCollection().addToDecks(deck);
            }
            System.out.println("deck.getName() = " + deck.getName());
        } else if (str[0].compareToIgnoreCase("create")==0 && str[1].compareToIgnoreCase("deck")==0) {
            boolean check = false;
            for (int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++) {
                if (loggedInPlayer.getCollection().getDecks().get(i).getName().equals(str[2])) {
                    loggedInPlayer.getCollection().getDecks().remove(i);
                    check = true;
                }
            }
            if (!check) {
                System.out.println("Deck doesn't exist!");
            }
        }
        else if(str[0].compareToIgnoreCase("add") == 0 ||
                str[0].compareToIgnoreCase("remove") == 0){
            String[] str1 = input.split(" ");
            outer:
            for (Deck deck: loggedInPlayer.getCollection().getDecks()) {
                if(deck.getName().equals(str1[3])){
                    for (Card card: loggedInPlayer.getCollection().getCards()) {
                        System.out.println("card.getName() = " + card.getName());
                        if(card.getCardID().equals(str1[1])){
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
                            if(str1[0].compareToIgnoreCase("add")==0) {
                                deck.addToCards(card);
                                if(deck.getCards().size() > 20){
                                    System.out.println("cannot add any card to deck");
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
                        if(item.getItemID().equals(str[1])){
                            if (str[0].compareToIgnoreCase("add")==0) {
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

        else if (str[0].compareToIgnoreCase("validate") == 0 && str[1].compareToIgnoreCase("deck")== 0) {
            for (int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++) {
                if (loggedInPlayer.getCollection().getDecks().get(i).getName().compareToIgnoreCase(str[2])==0) {
                    if (loggedInPlayer.getCollection().validateDeck(loggedInPlayer.getCollection().getDecks().get(i))) {
                        System.out.println("valid");
                    } else
                        System.out.println("invalid");
                    break;
                }
            }
        } else if (str[0].compareToIgnoreCase("select") == 0 && str[1].compareToIgnoreCase("deck") == 0) {
            boolean check = false;
            for (int i = 0; i < loggedInPlayer.getCollection().getDecks().size(); i++) {
                if (loggedInPlayer.getCollection().getDecks().get(i).getName().compareToIgnoreCase(str[2])==0) {
                    loggedInPlayer.setMainDeck(loggedInPlayer.getCollection().getDecks().get(i));
                    check = true;
                }
            }
            if (!check) {
                System.out.println("Deck doesnt exist!");
            }
        } else if (str[0].compareToIgnoreCase("show") == 0 && str[1].compareToIgnoreCase("deck") == 0) {
            for (Deck deck: loggedInPlayer.getCollection().getDecks()) {
                if(deck.getName().compareToIgnoreCase(str[2]) == 0){
                    showDeck(deck);
                }
            }
        }
        collectionMenu();
    }

    public static void shopMenu() {
        ShopMenu menu = new ShopMenu();
        menu.help();
        input = scanner.nextLine();
        String[] str= input.split(" ");
        if (input.compareToIgnoreCase("exit") == 0) {
            secondMenu();
        }
        else if (str[0].compareToIgnoreCase("buy") == 0) {
            menu.buy(str[1], loggedInPlayer);
        }
        else if (str[0].compareToIgnoreCase("sell") == 0) {
            menu.sell(str[1], loggedInPlayer);
        }
        else if (input.compareToIgnoreCase("show") == 0) {
            menu.show ();
        }
        else if (input.compareToIgnoreCase("help") == 0) {
            menu.help();
        }
        else if (str[0].compareToIgnoreCase("show") == 0 && str[1].compareToIgnoreCase("collection") == 0) {
            menu.showCollection (loggedInPlayer);
        }
        else if (str[0].compareToIgnoreCase("search") == 0) {
            menu.search(str[1]);
        }
        else if (str[0].compareToIgnoreCase("search") == 0 && str[1].compareToIgnoreCase("collection") == 0) {
            menu.searchCollection(str[2], loggedInPlayer);
        }
        shopMenu();
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
        System.out.println("deckname = " + deck.getName());
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
        for(int i = 0; i< deck.getCards ().size (); i++){
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