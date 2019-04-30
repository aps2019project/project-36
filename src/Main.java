import Consts.Consts;
import java.io.FileWriter;
import java.io.IOException;

import Player.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main
{
    static Player loggedInPlayer = new Player();
    public static void main( String[] args )
    {
        JSONObject HeroDetails = new JSONObject();
        HeroDetails.put("Name", "Sven");
        HeroDetails.put("AP", "5");
        HeroDetails.put("HP", "30");
        HeroDetails.put("Class", "Melee");
        HeroDetails.put("Special power", "attack to all enemy minion");
        HeroDetails.put("Sell Cost", "100");
        JSONObject HeroObject = new JSONObject();
        HeroObject.put("Hero", HeroDetails);


        JSONObject ItemDetails2 = new JSONObject();
        ItemDetails2.put("Name", "Yasha");
        ItemDetails2.put("Desc", "add 3 HP to Hero");
        ItemDetails2.put("Sell Cost", "300");
        JSONObject ItemObject = new JSONObject();
        ItemObject.put("Item", ItemDetails2);

        JSONObject CardsDetails2 = new JSONObject();
        CardsDetails2.put("Type", "Spell");
        CardsDetails2.put("Name", "OverPower");
        CardsDetails2.put("MP", "2");
        CardsDetails2.put("Desc", "add 2 AP to selected card");
        CardsDetails2.put("Sell Cost", "50");
        CardsDetails2.put("Type", "Minion");
        CardsDetails2.put("Name", "Dex");
        CardsDetails2.put("Class", "Melee");
        CardsDetails2.put("AP", "3");
        CardsDetails2.put("HP", "5");
        CardsDetails2.put("MP", "1");
        CardsDetails2.put("Special power", "Heal 1 allied minion on spawn");
        CardsDetails2.put("Sell Cost", "10");
        JSONObject CardsObject = new JSONObject();
        CardsObject.put("Cards", CardsDetails2);


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