package monster;

import item.Item;
import player.Player;

public class Pikachu extends Monster{


    public Pikachu(){
        name = "Pikachu";
        power = 70;
    }


    public void scream() {
        System.out.println("Pika Pikaaaaa!!!!");
    }

    public void weaken(Item item){
        if(item.getName().equals("water bucket")){
            power = 0;
        }
        else{
            Player.getInstance().increaseHp(item.getPower());
            power -= item.getPower();
        }
    }

    @Override
    public void attack() {
        System.out.println("Pikachu attacking back...");
        System.out.println("Pika Pika CHUUUUU!!!");
        Player.getInstance().decreaseHp(power);
    }


}
