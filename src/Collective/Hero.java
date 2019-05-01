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

    public int getRangeOfAttack() {
        return RangeOfAttack;
    }

    public void setRangeOfAttack(int rangeOfAttack) {
        RangeOfAttack = rangeOfAttack;
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

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public Hero() {
        for (HeroTypes hero : heroArr) {
            switch (hero) {
                case DIVESEFID:
                    kindOfAttack = "melee";
                    setPrice(8000);
                    setHP(50);
                    setAP(4);
                    setMP(1);
                    setCooldown(2);
                    break;
                case SIMORGH:
                    kindOfAttack = "melee";
                    setPrice(9000);
                    setHP(50);
                    setAP(4);
                    setMP(3);
                    setCooldown(8);
                    break;
                case EZHDEHA:
                    kindOfAttack = "melee";
                    setPrice(8000);
                    setHP(50);
                    setAP(4);
                    setMP(0);
                    setCooldown(1);
                    break;
                case RAKHSH:
                    kindOfAttack = "melee";
                    setPrice(8000);
                    setHP(50);
                    setAP(4);
                    setMP(1);
                    setCooldown(2);
                    break;
                case ZAHAK:
                    kindOfAttack = "melee";
                    setPrice(10000);
                    setHP(50);
                    setAP(4);
                    setMP(1);
                    setCooldown(3);
                    break;
                case KAVEH:
                    kindOfAttack = "melee";
                    setPrice(8000);
                    setHP(50);
                    setAP(4);
                    setMP(1);
                    setCooldown(3);
                    break;
                case ARASH:
                    kindOfAttack = "ranged";
                    setPrice(10000);
                    setHP(30);
                    setAP(2);
                    setMP(2);
                    setCooldown(2);
                    setRangeOfAttack(6);
                    break;
                case AFSANE:
                    kindOfAttack = "ranged";
                    setPrice(11000);
                    setHP(40);
                    setAP(3);
                    setMP(1);
                    setCooldown(2);
                    setRangeOfAttack(3);
                    break;
                case EFANDIAR:
                    kindOfAttack = "hybrid";
                    setPrice(12000);
                    setHP(5);
                    setAP(3);
                    setMP(0);
                    setRangeOfAttack(3);
                    break;
                case ROSTAM:
                    kindOfAttack = "hybrid";
                    setPrice(8000);
                    setHP(55);
                    setAP(7);
                    setRangeOfAttack(4);
                    break;
            }
        }
    }

}
