package command;

import player.Player;
import simulator.Grid;
import simulator.Simulator;

public class QuitCommand implements Command {

    Player player = Player.getInstance();

    public void apply() {
        Simulator.setQuit();
        System.out.println("quit game");
        System.out.println("----final stats----");
        System.out.println("HP: "+player.getHp());
        System.out.println("MAX HP: "+player.getHpMax());
        System.out.println("------------------");
    }

    public void apply(String name) {}


}
