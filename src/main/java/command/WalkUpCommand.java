package command;

import player.Player;

public class WalkUpCommand implements Command {

    Player player = Player.getInstance();

    public void apply() {
        player.walkUp();
    }

    public void apply(String name) {}
}
