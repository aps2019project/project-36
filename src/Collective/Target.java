package Collective;
import Battle.Battle;
import Collective.Card.Card;
import Consts.Consts;
import Map.Cell;
import Map.Map;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Target{

    private String typeOfTarget;
    private String friendlyOrEnemy;
    private String targetUnitClass;
    private int width;
    private int length;
    private int distance;
    private boolean isRandomSelecting;
    private boolean doesAffectAllCards;


    public void setTargetType(Card defender, Card selected,int x1,int x2,int y1,int y2){
        if (selected.equals("two")) {
            if (abs(x1 - x2) <= 1 && abs(y1 - y2) <= 1) {
                selected.setCanAttack(true);
                this.distance=1;
            }
        }
        if (selected.equals("three")) {
            if (abs(x1 - x2) <= 2 && abs(y1 - y2) <= 2) {
                selected.setCanAttack(true);
                this.distance=2;
            }
        }

        if (selected.equals("all_in_one_column")) {
            ArrayList<Integer> Ys_In_Same_Column = new ArrayList();
            for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                if (Map.getCardsInMap().get(k).getCell().getY() == y1
                        && Map.getCardsInMap().get(k).getOwner() != selected.getOwner()) {
                    Ys_In_Same_Column.add(Map.getCardsInMap().get(k).getCell().getY());
                }
            }
            if (Ys_In_Same_Column.contains(y2)) {
                selected.setCanAttack(true);
            }
        }

        if (selected.equals("enemy")) {
            ArrayList<Integer> enemies = new ArrayList();
            for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                if (Map.getCardsInMap().get(k).getOwner() != selected.getOwner()) {
                    enemies.add(Map.getCardsInMap().get(k).getCell().getY());
                }
            }
            if (enemies.contains(y2)) {
                selected.setCanAttack(true);
            }
        }

        if (selected.equals("friend")) {
            ArrayList<Integer> friends = new ArrayList();
            for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                if (Map.getCardsInMap().get(k).getOwner() == selected.getOwner()) {
                    friends.add(Map.getCardsInMap().get(k).getCell().getY());
                }
            }
            if (friends.contains(y2)) {
                selected.setCanAttack(true);
            }
        }

        if (selected.equals("eight_arounds")) {
            ArrayList<Cell> around_cells = new ArrayList();
            for (int k = 0; k < Map.getCardsInMap().size(); k++) {
                if (Map.getCardsInMap().get(k).getCell().getX() - x1 <= 2
                        && Map.getCardsInMap().get(k).getCell().getY() - y1 <= 2) {
                    around_cells.add(Map.getCardsInMap().get(k).getCell());
                }
            }
            if (around_cells.contains(defender)) {
                selected.setCanAttack(true);

            }
        }
    }


}
