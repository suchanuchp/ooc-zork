package monster;

import player.Player;

public class Troll extends Monster {

    public Troll(){
        name = "Troll";
        power = 90;
    }

    @Override
    public void attack() {
        System.out.println("Troll attacking back...");
        System.out.println("Puff puff pufff!!");
        Player.getInstance().decreaseHp(power);
    }

    public void scream() {
        System.out.println("Urgggggg!!!");
    }
}
