package Player;

import Collective.Card;
import java.util.ArrayList;

public class GraveYard {

    private ArrayList<Card> cards = new ArrayList<Card>();

    public void addNewCard(Card card) {
        cards.add(card);
    }
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void showInfo(String ID){
        for(Card x:cards){
            if(x.getCardID ().compareTo (ID)==0){
                if(x.getType ().compareTo ("Hero")==0){
                    System.out.println (" Name: " + x.getName () +" - AP: "+x.getAP ()+
                            " - HP: "+x.getHP ()+" - Special Power: "+ x.getDesc () +
                            " - Buy Cost: " +x.getPrice ());
                }
                if(x.getType ().compareTo ("Spell")== 0){
                    System.out.println ("Type "+ x.getType ()+ " - Name: " + x.getName () +
                            " - MP: "+x.getMP ()+" - Class: " +x.getClass () +" - Description: "+
                            x.getDesc () + " - Buy Cost: " + x.getPrice ());
                }
                else if(x.getType ().compareTo ("Minion")== 0){
                    System.out.println ("Type "+ x.getType ()+ " - Name: " +
                            x.getName () + " - Class: " +x.getClass () +
                            " - AP: "+x.getAP ()+" - HP: "+x.getHP ()+
                            " - MP"+x.getMP ()+" - SpecialPower: "+
                            x.getDesc () + " - Buy Cost: " + x.getPrice ());
                }
            }
        }
    }

    public void showCards(){
        for(Card x: cards){

        }
    }
}
