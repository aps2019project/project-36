package Shop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import Collective.Card;

public class Shop {
    protected ArrayList<Card> cards = new ArrayList<Card>();
    public void showCollection(){}
    //public int search(String name){}
    //public Array searchCollection(String name){}
    public void buy(String name){}
    public void sell(int ID){}
    public void show(){}
    public void showShopHelp(){}
    public void exit(){
    }
    public void help(){
        System.out.println("exit");
        System.out.println("show collection");
        System.out.println("search[item name|card name]");
        System.out.println("search collection[item name|card name]");
        System.out.println("buy[card name|item name]");
        System.out.println("sell[card id|card id]");
        System.out.println("show");
        System.out.println("help");
    }

}
