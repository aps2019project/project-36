//package Collective;
//
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.FileWriter;
//
//public class JSONSpell {
//
//    public static void main(String[] args) throws JSONException {
//
//        JSONObject TotalDisarm = new JSONObject();
//        TotalDisarm.put("Name", "TotalDisarm");
//        TotalDisarm.put("Class", "Spell");
//        TotalDisarm.put("price", "1000");
//        TotalDisarm.put("neededManna", "0");
//        TotalDisarm.put("targetArea", "one of enemies");
//        TotalDisarm.put("Effect", "Disarm for the whole game");
//        try (
//                FileWriter file = new FileWriter("TotalDisarm.json")) {
//            file.write(TotalDisarm.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject AreaDispel = new JSONObject();
//        AreaDispel.put("Name", "AreaDispel");
//        AreaDispel.put("Class", "Spell");
//        AreaDispel.put("price", "1500");
//        AreaDispel.put("neededManna", "2");
//        AreaDispel.put("targetArea", "2*2 square");
//        AreaDispel.put("Effect", "destroy positive buffs of enemies and negative buffs of own");
//        try (
//                FileWriter file = new FileWriter("AreaDispel.json")) {
//            file.write(AreaDispel.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject Empower = new JSONObject();
//        Empower.put("Name", "Empower");
//        Empower.put("Class", "Spell");
//        Empower.put("price", "250");
//        Empower.put("neededManna", "1");
//        Empower.put("targetArea", "one own force");
//        Empower.put("Effect", "add 2 points to AP force");
//        try (
//                FileWriter file = new FileWriter("Empower.json")) {
//            file.write(Empower.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject GodStrength = new JSONObject();
//        GodStrength.put("Name", "GodStrength");
//        GodStrength.put("Class", "Spell");
//        GodStrength.put("price", "450");
//        GodStrength.put("neededManna", "2");
//        GodStrength.put("targetArea", "own champion");
//        GodStrength.put("Effect", "add 4 points to champion AP");
//        try (
//                FileWriter file = new FileWriter("GodStrength.json")) {
//            file.write(GodStrength.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject HellFire = new JSONObject();
//        HellFire.put("Name", "HellFire");
//        HellFire.put("Class", "Spell");
//        HellFire.put("price", "600");
//        HellFire.put("neededManna", "3");
//        HellFire.put("targetArea", "a 2*@ square");
//        HellFire.put("Effect", "stun Buff twice");
//        try (
//                FileWriter file = new FileWriter("HellFire.json")) {
//            file.write(HellFire.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject LightingBolt = new JSONObject();
//        LightingBolt.put("Name", "LightingBolt");
//        LightingBolt.put("Class", "Spell");
//        LightingBolt.put("price", "1250");
//        LightingBolt.put("neededManna", "2");
//        LightingBolt.put("targetArea", " enemy champion");
//        LightingBolt.put("Effect", "8 points strike the champion of enemy");
//        try (
//                FileWriter file = new FileWriter("LightingBolt.json")) {
//            file.write(LightingBolt.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject PoisonLake = new JSONObject();
//        PoisonLake.put("Name", "PoisonLake");
//        PoisonLake.put("Class", "Spell");
//        PoisonLake.put("price", "900");
//        PoisonLake.put("neededManna", "5");
//        PoisonLake.put("targetArea", "3*# square");
//        PoisonLake.put("Effect", "poison buff in target area once");
//        try (
//                FileWriter file = new FileWriter("PoisonLake.json")) {
//            file.write(PoisonLake.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject Madness = new JSONObject();
//        Madness.put("Name", "Madness");
//        Madness.put("Class", "Spell");
//        Madness.put("price", "650");
//        Madness.put("neededManna", "0");
//        Madness.put("targetArea", "1 own force");
//        Madness.put("Effect", "add 4points to AP 3 times but will be disarmed");
//        try (
//                FileWriter file = new FileWriter("Madness.json")) {
//            file.write(Madness.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject AllDisarm = new JSONObject();
//        AllDisarm.put("Name", "AllDisarm");
//        AllDisarm.put("Class", "Spell");
//        AllDisarm.put("price", "2000");
//        AllDisarm.put("neededManna", "9");
//        AllDisarm.put("targetArea", "All enemies");
//        AllDisarm.put("Effect", "Disarm once");
//        try (
//                FileWriter file = new FileWriter("AllDisarm.json")) {
//            file.write(AllDisarm.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject AllPoison = new JSONObject();
//        AllPoison.put("Name", "AllPoison");
//        AllPoison.put("Class", "Spell");
//        AllPoison.put("price", "1500");
//        AllPoison.put("neededManna", "8");
//        AllPoison.put("targetArea", "all enemies");
//        AllPoison.put("Effect", "poison buff 4 times");
//        try (
//                FileWriter file = new FileWriter("AllPoison.json")) {
//            file.write(AllPoison.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Dispel = new JSONObject();
//        Dispel.put("Name", "Dispel");
//        Dispel.put("Class", "Spell");
//        Dispel.put("price", "2100");
//        Dispel.put("neededManna", "0");
//        Dispel.put("targetArea", "1 own or enemy");
//        Dispel.put("Effect", "remove positive buffs of enemy and negative buffs of own");
//        try (
//                FileWriter file = new FileWriter("Dispel.json")) {
//            file.write(Dispel.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject HealthWithProfit = new JSONObject();
//        HealthWithProfit.put("Name", "HealthWithProfit");
//        HealthWithProfit.put("Class", "Spell");
//        HealthWithProfit.put("price", "2250");
//        HealthWithProfit.put("neededManna", "0");
//        HealthWithProfit.put("targetArea", "1 friend");
//        HealthWithProfit.put("Effect", "a weakness buff with 6 points HP decrease, 2 holy buffs for 3 times");
//        try (
//                FileWriter file = new FileWriter("HealthWithProfit.json")) {
//            file.write(HealthWithProfit.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject GhazaBokhorJoonBegiri = new JSONObject();
//        GhazaBokhorJoonBegiri.put("Name", "GhazaBokhorJoonBegiri");
//        GhazaBokhorJoonBegiri.put("Class", "Spell");
//        GhazaBokhorJoonBegiri.put("price", "2500");
//        GhazaBokhorJoonBegiri.put("neededManna", "2");
//        GhazaBokhorJoonBegiri.put("targetArea", "1 own ");
//        GhazaBokhorJoonBegiri.put("Effect", "a power buff with AP of current HP for whole game");
//        try (
//                FileWriter file = new FileWriter("GhazaBokhorJoonBegiri.json")) {
//            file.write(GhazaBokhorJoonBegiri.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject AllPower = new JSONObject();
//        AllPower.put("Name", "AllPower");
//        AllPower.put("Class", "Spell");
//        AllPower.put("price", "2000");
//        AllPower.put("neededManna", "4");
//        AllPower.put("targetArea", "all own");
//        AllPower.put("Effect", "a power buff with 2 more AP for whole game");
//        try (
//                FileWriter file = new FileWriter("AllPower.json")) {
//            file.write(AllPower.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject AllAttack = new JSONObject();
//        AllAttack.put("Name", "AllAttack");
//        AllAttack.put("Class", "Spell");
//        AllAttack.put("price", "1500");
//        AllAttack.put("neededManna", "4");
//        AllAttack.put("targetArea", "All enemies in one column");
//        AllAttack.put("Effect", "strike all enemies 6 points");
//        try (
//                FileWriter file = new FileWriter("AllAttack.json")) {
//            file.write(AllAttack.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject Weakening = new JSONObject();
//        Weakening.put("Name", "Weakening");
//        Weakening.put("Class", "Spell");
//        Weakening.put("price", "1000");
//        Weakening.put("neededManna", "1");
//        Weakening.put("targetArea", "one enemy minion");
//        Weakening.put("Effect", "weakness buff with 4 less points of AP i  1 force");
//        try (
//                FileWriter file = new FileWriter("Weakening.json")) {
//            file.write(Weakening.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject Sacrifice = new JSONObject();
//        Sacrifice.put("Name", "Sacrifice");
//        Sacrifice.put("Class", "Spell");
//        Sacrifice.put("price", "1600");
//        Sacrifice.put("neededManna", "3");
//        Sacrifice.put("targetArea", "1 own minion ");
//        Sacrifice.put("Effect", "add current HP of minion to champion and kill the minion");
//        try (
//                FileWriter file = new FileWriter("Sacrifice.json")) {
//            file.write(Sacrifice.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JSONObject KingsGaurd = new JSONObject();
//        KingsGaurd.put("Name", "KingsGaurd");
//        KingsGaurd.put("Class", "Spell");
//        KingsGaurd.put("price", "1750");
//        KingsGaurd.put("neededManna", "3");
//        KingsGaurd.put("targetArea", "an enemy minion in 8 cells around the champion own");
//        KingsGaurd.put("Effect", "kill the enemy");
//        try (
//                FileWriter file = new FileWriter("KingsGaurd.json")) {
//            file.write(KingsGaurd.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject Shock = new JSONObject();
//        Shock.put("Name", "Shock");
//        Shock.put("Class", "Spell");
//        Shock.put("price", "1200");
//        Shock.put("neededManna", "1");
//        Shock.put("targetArea", "one enemy");
//        Shock.put("Effect", "stun twice");
//        try (
//                FileWriter file = new FileWriter("Shock.json")) {
//            file.write(Shock.toString());
//            file.flush();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
