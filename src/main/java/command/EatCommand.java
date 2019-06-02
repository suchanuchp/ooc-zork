package command;

import food.Food;
import player.Player;
import room.Room;

public class EatCommand implements Command {
    Player player = Player.getInstance();
    public void apply() {
       Room room = player.getCurrentRoom();
       Food food = room.getAndRemoveFood();
       if(food == null){
           System.out.println("There's nothing to eat.");
       }
       else{
           System.out.println("Eatting "+food.getName()+"...");
           System.out.println("yum yum");
           player.increaseHp(food.getEnergy());
       }
    }

    public void apply(String name) {}
}
