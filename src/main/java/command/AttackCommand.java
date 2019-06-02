package command;

import player.Player;

public class AttackCommand implements Command {

    Player player = Player.getInstance();

    public void apply() {

    }

    public void apply(String itemString) {
        player.attackWith(itemString);
    }
}
