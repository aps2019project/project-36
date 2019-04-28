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
