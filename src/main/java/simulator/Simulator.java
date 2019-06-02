package simulator;

import command.Command;
import command.CommandFactory;
import player.Player;
import room.Room;

import java.util.Scanner;

public class Simulator {
    private final int ROW = 6;
    private final int COL = 6;
    private Player player = Player.getInstance();
    private Grid grid;
    private static boolean quit = false;
    public void simulate() {

        grid = new Grid(ROW, COL);
        player.setGrid(grid);

        System.out.println("--------Welcome to Zork--------");

        simulate(1);
        simulate(2);
        simulate(3);

    }
    public void simulate(int level){
        Scanner scanner = new Scanner(System.in);
        if(!isOver()&&!quit){
            System.out.println("--------LEVEL"+level+"--------");
        }
        while (!isOver()&&!quit&&!levelComplete(level)) { //game not over
            System.out.print("You: ");
            String[] commandLine = scanner.nextLine().toLowerCase().split(" ");
            String[] parsed = commandParser(commandLine);
            String commandString = parsed[0];

            String info = parsed[1];

            Command command = CommandFactory.getCommand(commandString);
            if (null == command) {
                System.out.println("Oops I don't know what that means.");
            } else {
                command.apply();
                command.apply(info);
            }

        }
    }

    public String[] commandParser(String[] commandLine){
        int len = commandLine.length;
        if(len==0) return null;
        if(len==1){
            return new String[]{commandLine[0],""};
        }
        if(len==2){
            if(commandLine[0].equals("walk")){
                return new String[]{commandLine[0]+" "+commandLine[1],""};
            }
            return commandLine;
        }
        if(len==3){
            if(commandLine[0].equals("attack")){
                return new String[]{commandLine[0],commandLine[2]};
            }
            else if(commandLine[0].equals("take")){
                return new String[]{commandLine[0],commandLine[1]+" "+commandLine[2]};
            }
        }
        if(len==4){
            if(commandLine[0].equals("attack")){
                return new String[]{commandLine[0],commandLine[2]+" "+commandLine[3]};
            }
        }
        return new String[]{"",""};
    }


    public boolean isOver(){
        return !player.isAlive();
    }

    public static void setQuit(){
        quit = true;
    }

    public static boolean levelComplete(int level){
        if(level==1){
            return Player.getInstance().getHp()>1100;
        }
        else if(level==2){
            return Player.getInstance().getTreasureCollections().size()==6;
        }
        else{
            return Player.getInstance().getTreasureCollections().size()==6 && Player.getInstance().getHp()>2000;
        }
    }

}
