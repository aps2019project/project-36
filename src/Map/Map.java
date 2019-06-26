package Map;

import Collective.Card.Card;
import Collective.Flag;

import java.util.ArrayList;

public class Map {
    private  ArrayList<Flag> flagsInMap= new ArrayList<>();
    private  ArrayList<Card> cardsInMap = new ArrayList<>();
    private int [][] cells = new int[5][9];

    public  ArrayList<Card> getCardsInMap() {
        return cardsInMap;
    }

    public  void addToCardsInMap(Card card) {
        cardsInMap.add(card);
    }

    public  ArrayList<Flag> getFlagsInMap(){
        return flagsInMap;
    }
    public  void addToFlagsInMap(Cell cell){
        Flag flag = new Flag();
        flag.setCell(cell);
        flagsInMap.add(flag);
    }
    public  void clearMap(){
        flagsInMap.clear();
        cardsInMap.clear();
    }
}