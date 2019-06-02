package command;

import simulator.Grid;

public class HelpCommand implements Command {
    public void apply() {
        String newLine = System.getProperty("line.separator");
        System.out.println("----------available commands-----------");
        System.out.println("walk <direction> : walk to new room (left, right, up, down)");
        System.out.println("look: look around the room for monster and items");
        System.out.println("attack with <item>: attack a monster in the room with item");
        System.out.println("drop <item>: drop an item in the inventory");
        System.out.println("take <item>: take an item in the room");
        System.out.println("eat: eat food in the room");
        System.out.println("collect: collect treasure in the roon");
        System.out.println("help: see available commands");
        System.out.println("quit: quit zork");
        System.out.println("----------------------------------------------------");

    }

    public void apply(String name) {

    }




}
