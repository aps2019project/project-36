package Collective.Buff;

public class KillBuff {
    //remove that buff
    public void kill(Buff buff){
        buff.getBuffs().remove(buff);
    }
}
