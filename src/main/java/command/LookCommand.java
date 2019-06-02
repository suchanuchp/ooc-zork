package command;

import player.Player;

public class LookCommand implements Command {
    Player player = Player.getInstance();
    public void apply() {
        player.getCurrentRoom().describe();
    }

    public void apply(String name) {

    }
}
