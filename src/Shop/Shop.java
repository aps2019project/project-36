package Shop;

import Collective.Card;
import Collective.Item;
import org.json.JSONArray;
import org.json.*
import java.util.ArrayList;

public class Shop {
    private ArrayList<Card> cards= new ArrayList<>();
    private ArrayList<Item> items= new ArrayList<>();

    public static void main(String[] args) {
        JSONObject HeroDetails = new JSONObject();
        HeroDetails.put("Name", "Sven");
        HeroDetails.put("AP", "5");
        HeroDetails.put("HP", "30");
        HeroDetails.put("Class", "Melee");
        HeroDetails.put("Special power", "attack to all enemy minion");
        HeroDetails.put("Sell Cost", "100");
        JSONObject HeroObject = new JSONObject();
        HeroObject.put("Hero", HeroDetails);


        JSONObject ItemDetails = new JSONObject();
        ItemDetails.put("Name", "TajDanayi");
        ItemDetails.put("Desc", "Add mana after third turn");
        ItemDetails.put("Buy Cost", "300");

        ItemDetails.put("Name", "NamoosSepar");
        ItemDetails.put("Desc", "Activate 2 passive HolyBuffs");
        ItemDetails.put("Buy Cost", "4000");

        ItemDetails.put("Name", "KamanDamool");
        ItemDetails.put("Desc", "Add 2 to Hero's Range");
        ItemDetails.put("Buy Cost", "3000");

        ItemDetails.put("Name", "ParSimorgh");
        ItemDetails.put("Desc", "Multiple Hero's life by 2");
        ItemDetails.put("Buy Cost", "3000");

        ItemDetails.put("Name", "TerrorHood");
        ItemDetails.put("Desc", "aActivate WeaknessBuff");
        ItemDetails.put("Buy Cost", "20000");

        ItemDetails.put("Name", "KingKiller");
        ItemDetails.put("Desc", "Kill enemy's hero after 15 turns");
        ItemDetails.put("Buy Cost", "9000");

        ItemDetails.put("Name", "AssassinationDagger");
        ItemDetails.put("Desc", "Hero hits 8 more times when attacking the enemy's hero");
        ItemDetails.put("Buy Cost", "5000");

        ItemDetails.put("Name", "PoisonousDagger");
        ItemDetails.put("Desc", "After every hit poisons the enemy's force for 1 turn");
        ItemDetails.put("Buy Cost", "7000");

        ItemDetails.put("Name", "ShockHammer");
        ItemDetails.put("Desc", "Stun enemy for 1 turn");
        ItemDetails.put("Buy Cost", "15000");

        ItemDetails.put("Name", "SoulEater");
        ItemDetails.put("Desc", "Only for Melee : Add 2 HP after a hit");
        ItemDetails.put("Buy Cost", "25000");

        ItemDetails.put("Name", "GhoslTamid");
        ItemDetails.put("Desc", "Hit 5 more times while the enemy has not been hit 5 times");
        ItemDetails.put("Buy Cost", "20000");


        JSONObject ItemObject = new JSONObject();
        ItemObject.put("Item", ItemDetails);





        JSONObject CardsDetails = new JSONObject();
        CardsDetails.put("Type", "Spell");
        CardsDetails.put("Name", "OverPower");
        CardsDetails.put("MP", "2");
        CardsDetails.put("Desc", "add 2 AP to selected card");
        CardsDetails.put("Sell Cost", "50");
        CardsDetails.put("Type", "Minion");
        CardsDetails.put("Name", "Dex");
        CardsDetails.put("Class", "Melee");
        CardsDetails.put("AP", "3");
        CardsDetails.put("HP", "5");
        CardsDetails.put("MP", "1");
        CardsDetails.put("Special power", "Heal 1 allied minion on spawn");
        CardsDetails.put("Sell Cost", "10");
        JSONObject CardsObject = new JSONObject();
        CardsObject.put("Cards", CardsDetails);


        //Add Objects to list
        JSONArray List = new JSONArray();
        List.add(HeroObject);
        List.add(ItemObject);
        List.add(CardsObject);

        //Write JSON file
        try (
                FileWriter file = new FileWriter("Cards.json")) {

            file.write(List.toJSONString());
            file.flush();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}

