package monster;

import item.Item;
import player.Player;

public abstract class Monster {

    protected int power;
    protected String name;



    public void weaken(Item item){

        Player.getInstance().increaseHp(item.getPower());
        power -= item.getPower();

    }

    public abstract void attack();

    public String getName(){
        return this.name;
    }

    public boolean isAlive(){
        return power > 0;
    }

    public abstract void scream();

}
