package monster;

import player.Player;

public class Werewolf extends Monster {

    public Werewolf(){
        name = "Werewolf";
        power = 90;
    }

    @Override
    public void attack() {
        System.out.println("Werewolf attacking back...");
        scream();
        Player.getInstance().decreaseHp(power);
    }

    public void scream() {
        System.out.println("Wolf wolf wolf!!");
    }

}
