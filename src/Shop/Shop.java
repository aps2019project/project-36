package Shop;

import java.util.ArrayList;
import Collective.Card;
import Collective.Item;

public class Shop {
    protected ArrayList<Card> cards= new ArrayList<Card>();
    protected ArrayList<Item> items= new ArrayList<Item>();
    public void showCollection(){}
    public int search(String name){
        for(int i=0; i<cards.size(); i++){
            if(name.equals(cards.get(i).getName())){
                return cards.get(i).getCardNumber();
            }
        }
        for(int i=0; i<items.size(); i++){
            if(name.equals(items.get(i).getName())){
               return items.get(i).getItemNumber();
            }
        }
        return 0;
    }
    //public Array searchCollection(String name){}
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
        System.out.println("sell[card id|card id]");
        System.out.println("show");
        System.out.println("help");
    }

}
