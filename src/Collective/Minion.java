package Collective;

enum MinionTypes{
    KAMANDAREFARS,SHAMSHIRZANEFARS,NEIZEDAREFARS,ASBSAVAREFARS,PAHLEVANEFARS,
    SEPAHSALAREFARS,KAMANDARETOORANI,GHOLLABSANGDARETOORANI,NEIZEDARETOORANI,
    JASOOSETOORANI,GORZDARETOORANI,SHAHZADEYETOORANI,DIVESIAH,GHOOLESANGANDAZ,
    OGHAB,DIVEGORAZSAVAR,GHOOLETAKCHESHM,MARESAMMI,EZHDEHAYEATASHANDAZ,SHIREDARANDE,
    MAREGHOOLPEIKAR,GORGESEFID,PALANG,GORG,JADOOGAR,JADOOGAREAZAM,JEN,GORAZEVAHSHI,
    PIRAN,GIV,BAHMAN,ASHKBOOS,IRAJ,GHOOLEBOZORG,GHOOLEDOSAR,NANESARMA,FOOLADZERE,
    SIAVASH,SHAHGHOOL,ARZHANGDIV;
}

public class Minion extends Card {
    protected Spell specialPower;
    protected String classType;
    protected int neededManna;
    protected int typeOfActivation;
    protected int rangeOfAttack;
    protected String typeOfImpact;

    public void attack(){
    }

    public void move(){}

    public void setPRice(int price){}

    public void setType(String type){}

    public String getClassType(){
        return classType;
    }
}
