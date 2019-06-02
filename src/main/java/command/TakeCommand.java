package command;

import player.Player;
import simulator.Grid;

public class TakeCommand implements Command {

    Player player = Player.getInstance();

    public void apply() {}

    public void apply(String item) {
        player.takeItemFromRoom(item);
    }


}
