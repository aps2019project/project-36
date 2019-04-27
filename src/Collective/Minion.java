package Collective;

enum MinionTypes{
    KamandareFars,ShamshirZaneFars,NeizedareFars,AsbsavareFars,PahlevaneFars,
    SepahsalareFars,KamandareToorani,GhollabsangdareToorani,NeizedareToorani,
    JasooseToorani,GorzdareToorani,ShahzadeyeToorani,DiveSiah,GhooleSangandaz,
    Oghab,DiveGorazsavar,GhooleTakcheshm,MareSammi,EzhdehayeAtashandaz,Shiredarande,
    MareGhoolpeikar,GorgeSefid,Palang,Gorg,Jadoogar,JadoogareAzam,Jen,GorazeVahshi,
    Piran,Giv,Bahman,Ashkboos,Iraj,GhooleBozorg,GhooleDosar,NaneSarma,FooladZere,
    Siavash,ShahGhool,ArzhangDiv;
}

public class Minion extends Card {

    private int HP;
    private int AP;
    private int MP;
    private Spell specialPower;
    private String classType;
    private int neededManna;
    private int typeOfActivation;
    private int rangeOfAttack;
    private String typeOfImpact;

    public void attack(){
    }

    public void move(){}

    public void setPRice(int price){}

    public void setType(String type){}

    public String getClassType(){
        return classType;
    }
}
