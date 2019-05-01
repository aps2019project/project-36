package Shop;

import Collective.Card;
import Collective.Item;
import Player.Account;
import org.json.JSONArray;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Card> cards= new ArrayList<>();
    private ArrayList<Item> items= new ArrayList<>();
    public void showCollection(){}
    public void search(String name){
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
    public void searchCollection(String name,Account account){
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
    public void buy(String name){}
    public void sell(int ID){}

    public JSONArray show(JSONArray list){
        return list;
    }
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


/*just writing some things down:
show collection:
Items:
Name: TajDanayi - Desc: Add mana after third turn - Buy Cost : 300
Name: NamoosSepar - Desc: Activate 2 passive HolyBuffs - Buy Cost : 4000
Name: KamanDamool - Desc: Add 2 to Hero's Range - Buy Cost : 3000
Name: ParSimorgh - Desc: Multiple Hero's life by 2 - Buy Cost : 3000
Name: TerrorHood - Desc: Activate WeaknessBuff - Buy Cost : 20000
Name: KingKiller - Desc: Kill enemy's hero after 15 turns - Buy Cost : 9000
Name: AssassinationDagger - Desc: Hero hits 8 more times when attacking the enemy's hero - Buy Cost : 5000
Name: PoisonousDagger - Desc: After every hit poisons the enemy's force for 1 turn - Buy Cost : 7000
Name: ShockHammer - Desc: Stun enemy for 1 turn - Buy Cost : 15000
Name: SoulEater - Desc: ONly for Melee : Add 2 HP after a hit - Buy Cost : 25000
Name: GhoslTamid - Desc: Hit 5 more times while the enemy has not been hit 5 times - Buy Cost : 20000
sell cost?!
 */

