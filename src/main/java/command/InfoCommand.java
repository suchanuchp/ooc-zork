package command;

import item.Item;
import player.Player;
import simulator.Grid;
import treasure.Treasure;

public class InfoCommand implements Command {

    Player player = Player.getInstance();

    public void apply() {
        System.out.println("----Player stats----");
        System.out.println("HP: "+player.getHp());
        System.out.println("Max HP: "+ player.getHpMax());
        System.out.println("----Inventory----");
        for (Item item : player.getInventories()){
            System.out.println(item.getName());
        }
        System.out.println("----Treasure Collections----");
        for(Treasure treasure : player.getTreasureCollections()){
            System.out.println(treasure.getName());
        }
    }

    public void apply(String name) {

    }


}
