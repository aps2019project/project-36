package Shop;

import Collective.*;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;


public class Shop {
    private ArrayList<Card> cards = new ArrayList<> ( );
    private ArrayList<Item> items = new ArrayList<> ( );

    public enum TypeOfFiles {
        Collectible,
        Usable,
        Hero,
        Spell,
        Minion
    }

    private void init() {
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

    public void makeNewFromFile(String path, String type) {
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
                    Hero hero = gson.fromJson (reader, Collective.Hero.class);
                    cards.add (hero);
                    break;
                case "Spell":
                    Spell spell = gson.fromJson (reader, Collective.Spell.class);
                    cards.add (spell);
                    break;
                case "Minion":
                    Minion minion = gson.fromJson (reader, Collective.Minion.class);
                    cards.add (minion);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    public void makeNewItemByName(String name) {
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

    }

    public Card makeNewCardByName(String name) {
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
        return card;
    }


    public Card checkNameCard(String name) {
        for (Card x : cards) {
            if (x.getName ( ).compareTo (name) == 0) {
                return x;
            }
        }
        return null;
    }

    public Item checkNameItem(String name){
        for(Item x: items){
            if(x.getName ().compareTo (name)== 0){
                return x;
            }
        }
        return null;
    }

}

