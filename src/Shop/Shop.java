package Shop;

import java.util.ArrayList;
import Collective.Card;
import Collective.Item;

public class Shop {
    private ArrayList<Card> cards= new ArrayList<>();
    private ArrayList<Item> items= new ArrayList<>();
    public void showCollection(){}
    public int search(String name){
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
        return 0;
    }
    public void searchCollection(String name){
        
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
