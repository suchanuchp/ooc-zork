package command;


import player.Player;
import simulator.Grid;

public class WalkLeftCommand implements Command{

    Player player = Player.getInstance();

    public void apply() {
        player.walkLeft();
    }

    public void apply(String name) {}

}
