package Collective;

import Player.Player;

public class Usable extends Item {
    private int price;
    public void usableEffect(String name, Player player) {
        switch (name) {
            case "SOULEATER":
                break;
            case "TAJDANAYI":
                break;
            case "NAMOOSSEPAR":
                activeHolyBuff (player.getMainDeck ( ).getHero ( ), 2); //activeHolyBuff(Card card,number of buffs)
                break;
            case "KAMANDAMOOL":
                if (player.getMainDeck ( ).getHero ( ).getKindOfAttack ( ).compareTo ("ranged") == 0 || player.getMainDeck ( ).getHero ( ).getKindOfAttack ( ).compareTo ("hybrid") == 0) {
                    player.getMainDeck ( ).getHero ( ).setRangeOfAttack (player.getMainDeck ( ).getHero ( ).getRangeOfAttack ( ) + 2);
                }
                break;
            case "PARSIMORGH":
                if(player.getMainDeck ().getHero ().getHP ()< 15){
                    player.getMainDeck ().getHero ().setHP (player.getMainDeck ().getHero ().getHP()* 2 );
                }
                break;
            case "TERRORHOOD":
                break;
            case "KINGKILLER":
                break;
            case "ASSASSINATIONDAGGER":
                break;
            case "POISONOUSDAGGER":
                break;
            case "SHOCKHAMMER":
                break;
            case "GHOSLTAMID":
                break;
        }
    }
}
//chejuri az player be game va turn beresam?
//tabe baraye karha