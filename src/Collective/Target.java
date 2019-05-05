package Collective;
import Battle.Battle;
import Consts.Consts;
import Map.Cell;
import java.util.ArrayList;
import java.util.List;
public class Target{
public enum TargetType {
    ENEMY,
    INSIDER,
    ENEMY_HERO,
    INSIDER_HERO,
    CELL,
    PLAYER,
    SELF_NOT_MELEE,
    INSIDER_NOT_MELEE,
    NONE
}

    private String typeOfTarget;
    private String friendlyOrEnemy;
    private String targetUnitClass;
    private int width;
    private int length;
    private int Distance;
    private boolean isRandomSelecting;
    private boolean doesAffectAllCards;

    public Target(String typeOfTarget, int width, int length,
                  String friendlyOrEnemy, boolean isRandomSelecting,
                  boolean doesAffectAllCards, int Distance, String targetUnitClass) {
        this.typeOfTarget = typeOfTarget;
        this.friendlyOrEnemy = friendlyOrEnemy;
        this.targetUnitClass = targetUnitClass;
        this.width = width;
        this.length = length;
        this.Distance = Distance;
        this.isRandomSelecting = isRandomSelecting;
        this.doesAffectAllCards = doesAffectAllCards;
    }


}
