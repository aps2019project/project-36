package Collective;

public class Usable extends Item {

    enum UsableTypes {
        SOULEATER, TAJDANAYI, NAMOOSSEPAR, KAMANDAMOOL, PARSIMORGH, TERRORHOOD,
        KINGKILLER, ASSASSINATIONDAGGER, POISONOUSDAGGER, SHOCKHAMMER, GHOSLTAMID;
    }

    private int price;
    private UsableTypes usabletype;
    private Card owner;

    public Card getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOwner(Card owner) {
        this.owner = owner;
    }

    public void setUsabletype() {
        switch (usabletype) {
            case SOULEATER:
                setPrice(25000);
                break;
            case TAJDANAYI:
                setPrice(300);
                //if(owner.getOwner().getTurn()>= 3)
                owner.MP+= 1;
                break;
            case NAMOOSSEPAR:
                setPrice(4000);
                break;
            case KAMANDAMOOL:
                setPrice(3000);
                break;
            case PARSIMORGH:
                setPrice(3500);
               break;
            case TERRORHOOD:
                setPrice(20000);
                break;
            case KINGKILLER:
                setPrice(9000);
                break;
            case ASSASSINATIONDAGGER:
                setPrice(5000);
                break;
            case POISONOUSDAGGER:
                setPrice(7000);
                break;
            case SHOCKHAMMER:
                setPrice(15000);
                break;
            case GHOSLTAMID:
                setPrice(20000);
                break;

        }
    }

}
//chejuri az player be game va turn beresam?
//tabe baraye karha