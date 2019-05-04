package Collective;

public class Usable extends Item {

    enum UsableTypes {
        SOULEATER, TAJDANAYI, NAMOOSSEPAR, KAMANDAMOOL, PARSIMORGH, TERRORHOOD,
        KINGKILLER, ASSASSINATIONDAGGER, POISONOUSDAGGER, SHOCKHAMMER, GHOSLTAMID;
    }

    private int price;
    private UsableTypes usabletype;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUsabletype() {
        switch (usabletype) {
            case SOULEATER:
                setPrice(25000);
                break;
            case TAJDANAYI:
                setPrice(300);
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

    public void usableEffect(String name,Card card){
        switch(name){
            case "SOULEATER":
                break;
            case "TAJDANAYI":
                break;
            case "NAMOOSSEPAR":
                break;
            case "KAMANDAMOOL":
                card.HP+= 6;
                break;
            case "PARSIMORGH":
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