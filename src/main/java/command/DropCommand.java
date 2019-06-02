package command;

import item.Item;
import player.Player;
import simulator.Grid;

import java.util.List;

public class DropCommand implements Command{

    Player player = Player.getInstance();

    public void apply() {}

    public void apply(String item){
        player.dropItem(item);
    }


}
