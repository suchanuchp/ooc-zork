package command;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The command.CommandFactory class.<br/>
 */
import java.util.HashMap;
import java.util.Scanner;

public final class CommandFactory {

    private static final HashMap<String, Command> commands = new HashMap<String, Command>() {
        {
            // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
            put("walk left", new WalkLeftCommand());
            put("walk right", new WalkRightCommand());
            put("walk up", new WalkUpCommand());
            put("walk down", new WalkDownCommand());
            put("take", new TakeCommand());
            put("help", new HelpCommand());
            put("quit", new QuitCommand());
            put("info", new InfoCommand());
            put("drop", new DropCommand());
            put("look", new LookCommand());
            put("eat", new EatCommand());
            put("attack", new AttackCommand());
            put("collect", new CollectCommand());

        }
    };

    public static Command getCommand(String name) {

        return commands.get(name);
    }




}
