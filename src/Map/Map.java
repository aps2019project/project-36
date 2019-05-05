package Map;

import Collective.Flag;

import java.util.ArrayList;

public class Map {
    private static ArrayList<Flag> flagsInMap= new ArrayList<>();
    private int [][] cells = new int[5][9];

    public static ArrayList<Flag> getFlagsInMap(){
        return flagsInMap;
    }
}