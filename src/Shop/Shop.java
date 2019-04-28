package Shop;

import java.util.ArrayList;
import Collective.Card;
import Collective.Item;
import Player.Account;

public class Shop {
    private ArrayList<Card> cards= new ArrayList<>();
    private ArrayList<Item> items= new ArrayList<>();
    private Account account;
    public void showCollection(){}
    public void search(String name){
        for(Card x: cards){
            if(name.equals(x.getName())){
                System.out.println(x.getCardNumber());
            }
        }
        for(Item x:items){
            if(name.equals(x.getName())){
                System.out.println(x.getItemNumber());
            }
        }
    }
    public void searchCollection(String name){
        for(Card x: account.getCollection().getCards()){
            if(name.equals(x.getName())){
                System.out.println(x.getCardNumber());
            }
        }
        for(Item x:account.getCollection().getItems()){
            if(name.equals(x.getName())){
                System.out.println(x.getItemNumber());
            }
        }
    }
    public void buy(String name){}
    public void sell(int ID){}
    public void show(){}
    public void showShopHelp(){}
    public void exit(){
        return;
    }
    public void help(){
        System.out.println("exit");
        System.out.println("show collection");
        System.out.println("search[item name|card name]");
        System.out.println("search collection[item name|card name]");
        System.out.println("buy[card name|item name]");
        System.out.println("sell[card id|item id]");
        System.out.println("show");
        System.out.println("help");
    }

}
