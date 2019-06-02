package command;

import player.Player;

public class WalkRightCommand implements Command {

    Player player = Player.getInstance();

    public void apply() {
        player.walkRight();
    }

    public void apply(String name) {

    }
}
