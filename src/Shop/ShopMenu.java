package Shop;

import Collective.Card;
import Collective.Item;
import Player.Account;
import java.util.ArrayList;

public class ShopMenu{
    private static ArrayList<Card> cards = new ArrayList<> ( );
    private static ArrayList<Item> items = new ArrayList<> ( );

    public void exit(){
        return;
    }

    //public void showCollection() {}
    public void search(String name) {
        boolean found= false;
        for(Card x: cards){
            if(name.compareToIgnoreCase (x.getName ())== 0){
                System.out.println (x.getCardNumber ());
                found= true;
                break;
            }
        }
        if(!found){
            for(Item x: items){
                if(name.compareToIgnoreCase (x.getName ())== 0){
                    System.out.println (x.getItemID ());
                    found= true;
                    break;
                }
            }
        }
        if(!found){
            System.out.println ("This Card/Item is not in the shop");
        }
    }

    public void searchCollection(String name, Account account) {
        boolean found= false;
        for(Card x: account.getCollection ().getCards ()){
            if(name.compareToIgnoreCase (x.getName ())== 0){
                System.out.println (x.getCardNumber ());
                found= true;
            }
        }
        if(!found){
            for(Item x: account.getCollection ().getItems ()){
                if(name.compareToIgnoreCase (x.getName ())== 0){
                    System.out.println (x.getItemID ());
                    found= true;
                }
            }
        }
        if(!found){
            System.out.println ("This Card/Item is not in the shop");
        }
    }

    public void buy(String name, Account account) {
        boolean found= false;
        for(Card x: cards ){
            if(name.compareToIgnoreCase (x.getName ())== 0){
                Card wantedCard= new Card();
                wantedCard.setAP(x.getAP ());
                wantedCard.setOwner (account);
                wantedCard.setHP(x.getHP ());
                wantedCard.setPrice (x.getPrice ());
                wantedCard.setName (x.getName ());
                wantedCard.setMP (x.getMP ());
                found= true;
                if(found){
                    if(wantedCard.getPrice ()> account.getDaric ()){
                        System.out.println ("You don't have enough money");
                    }
                    else if(wantedCard.getPrice ()<= account.getDaric ()){
                        System.out.println ("You bought this card successfully");
                        //account.getCollection ().add(wantedCard.getCardID ());
                        account.changeDaric (account.getDaric()- wantedCard.getPrice());
                    }
                    break;
                }
            }
        }
        if(!found){
            for(Item x: items){
                if(name.compareToIgnoreCase (x.getName ())== 0){
                    Item wantedItem= new Item ();
                    wantedItem.setName (name);
                    wantedItem.setType (x.getType ());
                    wantedItem.setOwner (account);
                    found= true;
                    if(found){
                        if(wantedItem.getPrice()> account.getDaric ()){
                            System.out.println ("You don't have enough money.");
                        }
                        else if(account.getNumberOfItemsOwned ()>= 3){
                            System.out.println ("You can't have more than 3 items.");
                        }
                        else if(account.getNumberOfItemsOwned ()< 3 && wantedItem.getPrice()<= account.getDaric ()){
                            System.out.println ("You bought this item successfully");
                            account.changeDaric (account.getDaric ()- wantedItem.getPrice());
                            //account.getCollection ().addItem (wantedItem);
                            account.setNumberOfItemsOwned (account.getNumberOfItemsOwned ()+ 1);
                        }
                    }
                }
            }
        }
        if(!found){
            System.out.println ("This Card/Item is not in the shop");
        }

    }

    public void sell(int ID,Account account) {
        boolean found= false;
        for(Card x: cards){
            if(x.getCardNumber ()== ID){
                System.out.println ("You sold this card successfully");
                account.changeDaric (account.getDaric () - x.getPrice ());
                found= true;
                break;
            }
        }
        if(!found){
            for(Item x: items){
                if(x.getItemNumber ()== ID){
                    System.out.println ("You sold this item successfully");
                    account.changeDaric (account.getDaric ()- x.getPrice ());
                    account.setNumberOfItemsOwned (account.getNumberOfItemsOwned ()- 1);
                    found= true;
                    break;
                }
            }
        }
        if(!found){
            System.out.println ("This Card/Item is not in the shop");
        }
    }

    //public void show() {}

    public void help() {
        System.out.println ("exit");
        System.out.println ("show collection");
        System.out.println ("search[item name|card name]");
        System.out.println ("search collection[item name|card name]");
        System.out.println ("buy[card name|item name]");
        System.out.println ("sell[card id|item id]");
        System.out.println ("show");
        System.out.println ("help");
    }

}

