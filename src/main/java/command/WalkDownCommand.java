package command;

import player.Player;

public class WalkDownCommand implements Command {

    Player player = Player.getInstance();

    public void apply() {
       player.walkDown();
    }

    public void apply(String name) {

    }
}
