package Shop;

import Collective.*;
import Collective.Card.Card;
import Collective.Card.Hero;
import Collective.Card.Minion.Minion;
import Collective.Card.Spell;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;


public class Shop {
    private static ArrayList<Card> cards = new ArrayList<> ( );
    private static ArrayList<Item> items = new ArrayList<> ( );

    public enum TypeOfFiles {
        Collectible,
        Usable,
        Hero,
        Spell,
        Minion
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

   // private static void init()
    static
   {
        for (TypeOfFiles typeOfFiles : TypeOfFiles.values ( )) {
            File folder = new File (typeOfFiles.name ( ));
            File[] listOfFiles = folder.listFiles ( );
            if (!(listOfFiles == null || typeOfFiles.name ( ).compareTo ("Buff") == 0)) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    makeNewFromFile (listOfFiles[i].getPath ( ), typeOfFiles.toString ( ));
                }
            }
        }
    }

    public static void makeNewFromFile(String path, String type) {
        try {
            Gson gson = new Gson ( );
            InputStream input = new FileInputStream (path);
            Reader reader = new InputStreamReader (input);
            switch (type) {
                case "Collectible":
                    Collectible collectible = gson.fromJson (reader, Collective.Collectible.class);
                    items.add (collectible);
                    break;
                case "Usable":
                    Usable usable = gson.fromJson (reader, Collective.Usable.class);
                    items.add (usable);
                    break;
                case "Hero":
                    Hero hero = gson.fromJson (reader, Hero.class);
                    cards.add (hero);
                    break;
                case "Spell":
                    Spell spell = gson.fromJson (reader, Spell.class);
                    cards.add (spell);
                    break;
                case "Minion":
                    Minion minion = gson.fromJson (reader, Minion.class);
                    cards.add (minion);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    public static Item makeNewItemByName(String name) {
        Item item= checkNameItem (name);
        TypeOfFiles typeOfFile= null;
        if(item instanceof Collectible){
            typeOfFile= TypeOfFiles.Collectible;
        }
        if(item instanceof Usable){
            typeOfFile= TypeOfFiles.Usable;
        }
        if(item != null){
            makeNewFromFile (typeOfFile.name ( )+"/"+item.getName ()+".json",typeOfFile.toString ());
        }
        items.remove (item);
        return item;


    }

    public static Card makeNewCardByName(String name) {
        Card card = checkNameCard (name);
        TypeOfFiles typeOfFile = null;

        if (card instanceof Hero) {
            typeOfFile = TypeOfFiles.Hero;

        }
        if (card instanceof Minion) {
            typeOfFile = TypeOfFiles.Minion;
        }
        if (card instanceof Spell) {
            typeOfFile = TypeOfFiles.Spell;
        }
        if (card != null) {
            makeNewFromFile (typeOfFile.name() + "/" + card.getName() + ".json", typeOfFile.toString());
        }
        cards.remove (card);
        //Card.addToCards(card);
        return card;
    }


    public static Card checkNameCard(String name) {
        for (Card x : cards) {
            if (x.getName ( ).compareTo (name) == 0) {
                return x;
            }
        }
        return null;
    }

    public static Item checkNameItem(String name){
        for(Item x: items){
            if(x.getName ().compareTo (name)== 0){
                return x;
            }
        }
        return null;
    }

    public static Card buyCardForStoryDeck(String name){
        for (Card card1 : cards) {
            if (name.compareToIgnoreCase(card1.getName()) == 0) {
                Card card = Shop.makeNewCardByName(card1.getName());
                return card;
            }
        }
        return null;
    }

    public static Item buyItemForStoryDeck(String name){
        for (Item x : items) {
            if (name.compareToIgnoreCase(x.getName()) == 0) {
                Item item = Shop.makeNewItemByName (x.getName ( ));
                return item;
            }
        }
        return null;
    }
}

