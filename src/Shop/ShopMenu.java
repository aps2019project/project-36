package Shop;

import Battle.MainMenu;
import Collective.Card;
import Collective.Item;
import Player.Account;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopMenu {
    private static ArrayList<Card> cards= new ArrayList<>();
    private static ArrayList<Item> items= new ArrayList<>();

    public static void showCollection(){}

    public static void search(String name){
        boolean exist=false;
        for(Card x: cards){
            if(name.equals(x.getName())){
                System.out.println(x.getCardNumber());
                exist=true;
            }
        }
        for(Item x:items){
            if(name.equals(x.getName())){
                System.out.println(x.getItemNumber());
                exist=true;
            }
        }
        if(!exist){
            System.out.println("This Card/Item is not in the shop");
        }
    }

    public static void searchCollection(String name, Account account){
        boolean exist=false;
        for(Card x: account.getCollection().getCards()){
            if(name.equals(x.getName())){
                System.out.println(x.getCardNumber());
                exist=true;
            }
        }
        for(Item x:account.getCollection().getItems()){
            if(name.equals(x.getName())){
                System.out.println(x.getItemNumber());
                exist=true;
            }
        }
        if(!exist){
            System.out.println("This Card/Item is not in the collection");
        }
    }

    public static void buy(String name){}

    public static void sell(int ID){}

    /*public static void show(JSONArray list){
        return list;
    }
    */

    public static void help(){
        System.out.println("exit");
        System.out.println("show collection");
        System.out.println("search[item name|card name]");
        System.out.println("search collection[item name|card name]");
        System.out.println("buy[card name|item name]");
        System.out.println("sell[card id|item id]");
        System.out.println("show");
        System.out.println("help");
    }

    public static void getOptions(){
        boolean y = true;
        StringBuilder option = new StringBuilder();
        StringBuilder cardName = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        ShopMenu.help();
        while(y){
            cardName.setLength(0);
            option.setLength(0);
            option.append(scanner.next());
            switch (option.toString().toLowerCase()) {
                case "help":
                    ShopMenu.help();
                    break;
                case "exit":
                    y =false;
                    break;
                case "search":
                    ShopMenu.search(option.toString());
                    break;
                case "search collection ":
                    //ShopMenu.searchCollection(option.toString(),account);
                    //account ro voridu begire
                    break;
                case "buy":
                    ShopMenu.buy(option.toString());
                    break;
                case "sell":
                    //ShopMenu.sell();
                    break;
                case "show":
                    //tabe ro bezan
                    break;
                case "show collection":
                    ShopMenu.showCollection();
                    break;
                    default:
                        System.out.println("Option not found");
            }
        }
    }

    private void split(String string){
// esme card ro az dastur joda konam
    }
}
//qabl az hame split konim