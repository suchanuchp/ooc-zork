package monster;

import player.Player;

public class Basilisk extends Monster {

    public Basilisk(){
        name = "Basilisk";
        power = 100;
    }

    @Override
    public void attack() {
        System.out.println("Basilisk attacking back....");
        scream();
        Player.getInstance().decreaseHp(power);
    }

    @Override
    public void scream() {
        System.out.println("Ssss Ssss Ssss!!!");
    }
}
