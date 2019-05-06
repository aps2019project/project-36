package Map;

import Collective.Card;
import Collective.Flag;

import java.util.ArrayList;

public class Map {
    private static ArrayList<Flag> flagsInMap= new ArrayList<>();
    private static ArrayList<Card> cardsInMap = new ArrayList<>();
    private int [][] cells = new int[5][9];

    public static ArrayList<Card> getCardsInMap() {
        return cardsInMap;
    }

    public static void addToCardsInMap(Card card) {
        cardsInMap.add(card);
    }

    public static ArrayList<Flag> getFlagsInMap(){
        return flagsInMap;
    }
    public static void addToFlagsInMap(Flag flag){
        flagsInMap.add(flag);
    }
}