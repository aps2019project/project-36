package Collective;

import Battle.Game;
import Player.Player;

public class Usable extends Item {
    private int price;
    /*public void usableEffect(String name, Card card, Game game) {
        switch (name) {
            case "SOULEATER":
                if(card.isAttacker ()){
                    if (card.getOwner().getMainDeck ().getHero ().getKindOfAttack ().compareTo ("melee") == 0){
                        card.getOwner().getMainDeck ().getHero ().setHP (card.getOwner().getMainDeck ().getHero ().getHP ()+2);
                    }
                }
                break;
            case "TAJDANAYI":
                if(card.getOwner().equals (game.getPlayer1 ()) && game.getTurn ()>= 2 ){
                    game.setManaPlayer1 (game.getManaPlayer1 ()+ 1);
                }
                else if(card.getOwner().equals (game.getPlayer2 ()) && game.getTurn ()>= 3 ){
                    game.setManaPlayer2 (game.getManaPlayer2 ()+ 1);
                }
                break;
            case "NAMOOSSEPAR":
                activeHolyBuff (card.getOwner().getMainDeck().getHero(), 2); //activeHolyBuff(Card card,number of buffs)
                break;
            case "KAMANDAMOOL":
                if (card.getOwner().getMainDeck ().getHero ().getKindOfAttack ().compareTo ("ranged") == 0 || card.getOwner().getMainDeck ( ).getHero ( ).getKindOfAttack ( ).compareTo ("hybrid") == 0) {
                    card.getOwner().getMainDeck ().getHero ().setRangeOfAttack (card.getOwner().getMainDeck ( ).getHero ( ).getRangeOfAttack ( ) + 2);
                }
                break;
            case "PARSIMORGH":
                if(card.getOwner().getMainDeck ().getHero ().getHP ()< 15){
                    card.getOwner().getMainDeck ().getHero ().setHP (card.getOwner().getMainDeck ().getHero ().getHP()* 2 );
                }
                break;
            case "TERRORHOOD":
                activeWeaknessBuff(card,2);//activeWeaknessBuff(Card card,int power)
                break;
            case "KINGKILLER":
                if(card.getOwner ().equals (game.getPlayer1 ())){
                    game.setManaPlayer1 (game.getManaPlayer1 () - 1);
                }
                else if(card.getOwner ().equals (game.getPlayer2 ())){
                    game.setManaPlayer2 (game.getManaPlayer2 () - 1);
                }
                break;
            case "ASSASSINATIONDAGGER":
                if((card.getOwner().getMainDeck ().getHero ().getKindOfAttack().compareToIgnoreCase("ranged")== 0 ||card.getOwner().getMainDeck ().getHero ().getKindOfAttack().compareToIgnoreCase("hybrid")== 0) && card.getEnemy ().equals (card.getEnemy ().getOwner ().getMainDeck ().getHero ())){
                    card.getOwner().getMainDeck ().getHero ().setAP (card.getOwner().getMainDeck ().getHero ().getAP ()+ 8);
                }
                break;
            case "POISONOUSDAGGER":
                if(card.isAttacker ()){
                    activePosionBuff(card.getEnemy ());
                }
                break;
            case "SHOCKHAMMER":
                if(card.isAttacker ()){
                    stun(card.getEnemy ());
                }
                break;
            case "GHOSLTAMID":
                activeHolyBuff(card);
                break;
        }
    }*/
}
//chejuri az player be game va turn beresam?
//tabe baraye karha
