package Collective;

public class Hero extends Card {

    enum HeroTypes {
        DIVESEFID, SIMORGH, EZHDEHA, RAKHSH, ZAHAK,
        KAVEH, ARASH, AFSANE, EFANDIAR, ROSTAM;
    }

    private Spell specialPower;
    private HeroTypes heroArr[] = HeroTypes.values();
    private int RangeOfAttack;
    private String kindOfAttack;
    private int cooldown;

    public Hero() {
        for (HeroTypes hero : heroArr) {
            switch (hero) {
                case DIVESEFID:
                    setPrice(8000);
                    setHP(50);
                    setAP(4);
                    setMP(1);
                    kindOfAttack = "melee";
                    break;
                case SIMORGH:
                    kindOfAttack = "melee";
                    break;
                case EZHDEHA:
                    kindOfAttack = "melee";
                    break;
                case RAKHSH:
                    kindOfAttack = "melee";
                    break;
                case ZAHAK:
                    kindOfAttack = "melee";
                    break;
                case KAVEH:
                    kindOfAttack = "melee";
                    break;
                case ARASH:
                    kindOfAttack = "ranged";
                    break;
                case AFSANE:
                    kindOfAttack = "ranged";
                    break;
                case EFANDIAR:
                    kindOfAttack = "hybrid";
                    break;
                case ROSTAM:
                    kindOfAttack = "hybrid";
                    break;


            }
        }
    }


    public void removeCard(int AP) {
    }

    public void setPrice(int price) {
    }

    public void setHeroType() {
    }

    public HeroTypes[] getType() {
        return heroArr;
    }

}
