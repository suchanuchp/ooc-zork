package command;

import player.Player;
import room.Room;

public class CollectCommand implements Command {

    Player player = Player.getInstance();

    @Override
    public void apply() {
        player.collectTreasureInRoom();
    }

    @Override
    public void apply(String name) {

    }
}
