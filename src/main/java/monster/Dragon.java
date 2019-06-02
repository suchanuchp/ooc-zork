package monster;

import player.Player;

public class Dragon extends Monster {

    public Dragon(){
        power = 120;
        name = "Dragon";
    }

    @Override
    public void attack() {
        System.out.println("dragon attacking back...");
        scream();
        Player.getInstance().decreaseHp(power);

    }

    public void scream() {
        System.out.println("HREE! HREE! HREE!!!");
    }
}
