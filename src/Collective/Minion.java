package Collective;


public class Minion extends Card {

    enum MinionTypes {
        KAMANDAREFARS, SHAMSHIRZANEFARS, NEIZEDAREFARS, ASBSAVAREFARS, PAHLEVANEFARS,
        SEPAHSALAREFARS, KAMANDARETOORANI, GHOLLABSANGDARETOORANI, NEIZEDARETOORANI,
        JASOOSETOORANI, GORZDARETOORANI, SHAHZADEYETOORANI, DIVESIAH, GHOOLESANGANDAZ,
        OGHAB, DIVEGORAZSAVAR, GHOOLETAKCHESHM, MARESAMMI, EZHDEHAYEATASHANDAZ, SHIREDARANDE,
        MAREGHOOLPEIKAR, GORGESEFID, PALANG, GORG, JADOOGAR, JADOOGAREAZAM, JEN, GORAZEVAHSHI,
        PIRAN, GIV, BAHMAN, ASHKBOOS, IRAJ, GHOOLEBOZORG, GHOOLEDOSAR, NANESARMA, FOOLADZERE,
        SIAVASH, SHAHGHOOL, ARZHANGDIV;
    }

    protected Spell specialPower;
    protected String classType;
    protected int neededManna;
    protected int typeOfActivation;
    protected int rangeOfAttack;
    protected String typeOfImpact;
    protected MinionTypes minionArr[] = MinionTypes.values();

    public int getNeededManna() {
        return neededManna;
    }

    public void setNeededManna(int neededManna) {
        this.neededManna = neededManna;
    }

    public void attack() {
    }

    public void move() {
    }

    public void setPrice(int price) {
    }

    public void setType(String type) {
    }

    public String getCard() {
        return "Minion";
    }

    public String getClassType() {
        return classType;
    }

    public Minion() {
        for (MinionTypes minion : minionArr) {
            switch (minion) {
                case KAMANDAREFARS:
//                     setPrice();
//                    setHP();
//                    setAP();
                    break;
            }
        }
    }
}
