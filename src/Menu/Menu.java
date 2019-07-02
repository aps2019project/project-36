package Menu;


import Battle.AccountMenu;
import Battle.BattleMenu;
import Player.Account;
import Player.Deck;
import Player.Player;
import Shop.ShopMenu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Queue;
import java.util.Scanner;

public class Menu {

    static boolean EXIT = false;
    static Scanner scanner = new Scanner (System.in);
    static String input = new String ();
    static Account loggedInPlayer = null;

    public static void menu(){
        firstMenu();
        /*while (true) {
            input = "1";
            firstMenu();
            if (EXIT) {
                return;
            }
            secondMenu();
        }*/
    }

    public static void firstMenu() {


        //if (input == "1") {
        MainMenuView menuView = new MainMenuView(input);
        Graphics.changeScene(menuView.getMainMenuScene());
        input = "";
        //}

        /*if (input == "" || input == "1"){
            firstMenu();
        }

        if (loggedInPlayer == null) {
            firstMenu();
        }*/
    }

    public static void firstMenuCommand(String input) {

        AccountMenu menu = new AccountMenu();
        menu.help();
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
                //input = scanner.nextLine();
                loggedInPlayer = menu.login(str[1], str[2]);
            } else
                System.out.println("This username does not exist!");
            secondMenu();
        } else if (input.compareToIgnoreCase("show leaderBoard") == 0) {
            //menu.showLeaderboard();
        } else if (input.compareToIgnoreCase("save") == 0) {

        } else if (input.compareToIgnoreCase("logout") == 0) {
            //System.out.println ("here" );
            //saveAccountInfo(loggedInPlayer);
            //loggedInPlayer = null;

        } else if (input.compareToIgnoreCase("help") == 0) {
            menu.help();
        }
        else if (str[0].compareToIgnoreCase("create")==0 && str[1].compareToIgnoreCase("account")==0){
            if (!Player.takenUsernames(str[2])) {
                menu.createAccount(str[2], str[3]);
                accountsList (str[2]);
                System.out.println("New Account Created!");
                firstMenu();
            } else
                System.out.println("This username is already taken!");
        }
    }
    public static void secondMenu() {
        SecondMenuView menuView = new SecondMenuView();
        Graphics.changeScene(menuView.getSecondMenuScene());
    }

    public static void secondMenuCommand(String input) {
        System.out.println("input = " + input);
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
        //secondMenu();
    }
    public static void collectionMenu() {
        CollectionMenuView menuView = new CollectionMenuView();
        Graphics.changeScene(menuView.getCollectionMenuScene());
        collecionHelp();
        //input = scanner.nextLine();
    }

    public static void collectionMenuCommand(String input) {
        String[] str = input.split(" ");
        if (input.compareToIgnoreCase("exit") == 0) {
            secondMenu();
        }
        else if (input.compareToIgnoreCase("show all decks") == 0) {
            //showAllDecks(loggedInPlayer);
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
        } else if (str[0].compareToIgnoreCase("remove")==0 && str[1].compareToIgnoreCase("deck")==0) {
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
                    //showDeck(deck);
                }
            }
        }
    }

    public static void shopMenu() {
        ShopMenuView menu = new ShopMenuView();
        Graphics.changeScene(menu.getShopMenuScene());

    }

    public static void shopMenuCommand(String input) {
        ShopMenu menu = new ShopMenu();
        menu.help();
        //input = scanner.nextLine();
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
    }

    public static void battleMenu() {
        BattleMenuView menu = new BattleMenuView();
        Graphics.changeScene(menu.getBattleMenuScene());
    }

    public static void battleMenuCommand(String input) {
        BattleMenu menu = new BattleMenu();
        int mode;
        int numOfFlags = 0;
        if (!loggedInPlayer.getCollection().validateDeck(loggedInPlayer.getMainDeck())) {
            System.out.println("selected deck is invalid");
            secondMenu();
        }
        //input = scanner.nextLine();
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
                //showAllDecks(loggedInPlayer);
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

    public static void saveAccountInfo(Account account) {
        Gson gson = new GsonBuilder ().setPrettyPrinting ().create ();
        try{
            FileWriter fileWriter = new FileWriter ("AccountInfo/"+account.getUsername ()+".json");
            fileWriter.write (gson.toJson (account));
            fileWriter.close ();
        } catch (IOException e) {
            e.printStackTrace ( );
        }

    }

    public static void accountsList(String username){
        Gson gson = new GsonBuilder ().setPrettyPrinting ().create ();
        try{
            FileWriter fileWriter = new FileWriter ("AccountInfo/accountList.txt");
            fileWriter.append (username);
            fileWriter.close ();
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }


    public static void makeAllAccounts(){
        try {
            FileReader fileReader = new FileReader ("AccountInfo/accountList.txt");
            BufferedReader bufferedReader = new BufferedReader (fileReader);
            while(true){
                String line = bufferedReader.readLine();
                if (line == null){
                    break;
                }
                String userName= line.trim ();
                Gson gson = new Gson();
                InputStream input = new FileInputStream("AccountInfo/"+ userName+".json");
                Reader reader = new InputStreamReader(input);
                Account account = gson.fromJson (reader,Account.class);
                Account.addToAccounts (account);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace ( );
        } catch (IOException e) {
            e.printStackTrace ( );
        }

    }
}