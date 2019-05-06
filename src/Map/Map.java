package Map;

import Collective.Card.Card;
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
    public static void addToFlagsInMap(Cell cell){
        Flag flag = new Flag();
        flag.setCell(cell);
        flagsInMap.add(flag);
    }
    public static void clearMap(){
        flagsInMap.clear();
        cardsInMap.clear();
    }
}