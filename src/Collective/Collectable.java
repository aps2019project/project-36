package Collective;

import java.util.ArrayList;
import Cell.Cell;

enum CollectableTypes{
    MajoonMana, MajoonRoointan, NefrinMarg, RandomDamage,
    BladesofAgility, ChineseSword, JoonBaw, TirSeShakh,
    Eksir;
}

public class Collectable extends Item{
    private int MP ;
    private ArrayList <Card> targetArea =new ArrayList<Card>();
    private Cell cell;

}
