package player;

import item.Item;
import monster.Monster;
import room.Room;
import simulator.Grid;
import treasure.Treasure;

import java.util.ArrayList;
import java.util.List;

public class Player {

    static List<Item> inventory = new ArrayList<Item>();
    static int INVEN_CAP = 5;
    static int hp = 100;
    static int hpMax;
    static private int row = 0;
    static private int col = 0;
    static private Grid grid;
    static private final int ROOM_HP = 10;
    static List<Treasure> treasures = new ArrayList<>();

    private static Player instance = new Player();

    private Player(){}

    public static Player getInstance(){
        return instance;
    }

    public boolean isAlive(){
        return hp > 0;
    }

    public void setPosition(int irow, int icol){
        row = irow;
        col = icol;

    }

    public void setGrid(Grid grid){
        this.grid = grid;
    }

    public boolean hasMaxInventory(){
        return inventory.size()==INVEN_CAP;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public List<Item> getInventories(){
        return inventory;
    }

    public void dropItem(String itemString){
        int index = getItemIndex(itemString);
        if(index==-1){
            System.out.println("you don't have any "+ itemString);
        }
        else{
            Item droppedItem = inventory.get(index);
            inventory.remove(index);
            Room room = getCurrentRoom();
            room.addItem(droppedItem);
            System.out.println("you've dropped a "+ itemString);
        }
    }

    private int getItemIndex(String itemString){
        int i = 0;
        for(Item item : inventory){
            if(item.getName().equals(itemString)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public Item takeItemFromInventory(String itemString){
        int index = getItemIndex(itemString);
        if(index==-1) return null;
        else{
            Item item = inventory.get(index);
            inventory.remove(index);
            return item;
        }
    }

    public Room getCurrentRoom(){
        return grid.getRoomAt(row, col);
    }


    public void walkDown(){
        if(row+1 < grid.getnRow()){
            row += 1;
            increaseHp(ROOM_HP);
        }
        else{
            System.out.println("Cannot walk further down!");
        }

    }

    public void walkUp(){
        if(row-1 < grid.getnRow() && row-1>=0){
            row -= 1;
            increaseHp(ROOM_HP);
        }
        else{
            System.out.println("Cannot walk further up!");
        }
    }

    public void walkLeft(){
        if(col-1>=0){
            col -= 1;
            increaseHp(ROOM_HP);
        }
        else{
            System.out.println("Cannot walk further left!");
        }
    }

    public void walkRight(){
        if(col+1<grid.getnCol()){
            col += 1;
            increaseHp(ROOM_HP);
        }
        else{
            System.out.println("Cannot walk further right!");
        }
    }

    public int getHp(){
        return hp;
    }

    public int getHpMax(){
        return hpMax;
    }

    public void increaseHp(int nHp){
        hp += nHp;
        if(hp>hpMax){
            hpMax = hp;
        }
        //System.out.println("inc hp: "+hp);
    }

    public void decreaseHp(int nHp){
        hp -= nHp;
        //System.out.println("nhp: "+hp);
    }
    public void takeItemFromRoom(String itemString){
        Room room = getCurrentRoom();
        int size = inventory.size();
        boolean hasItem = room.hasItem(itemString);
        if(hasItem && INVEN_CAP>size){
            Item item = room.getItemAndRemove(itemString);
            inventory.add(item);
        }
        else if(!hasItem){
            System.out.println("There's no "+itemString+ " in this room!");
        }
        else {
            System.out.println("Your inventory is full. Drop an item to take "+ itemString+'.');
        }


    }


    public void attackWith(String itemString){
        Room room = getCurrentRoom();
        Monster monster = room.getMonster();
        Item item = room.getItemAndRemove(itemString);
        if(item==null){
            item = takeItemFromInventory(itemString);
        }
        if(item==null){
            System.out.println("you have no " + itemString + " to attack!");
        }
        else if(monster==null){
            System.out.println("there's no monster in this room!");
        }
        else{
            monster.weaken(item);
            monster.scream();
            if(!monster.isAlive()){
                System.out.println("you've killed "+ monster.getName()+".");
                room.removeMonster();
            }
            else{
                monster.attack();
            }
        }

    }

    public void collectTreasureInRoom(){
        Room room = getCurrentRoom();
        if(room.getMonster()==null && room.getTreasure()!=null){
            Treasure treasure = room.getTreasureAndRemove();
            addTreasureToCollection(treasure);
            System.out.println("Added "+ treasure.getName()+" to your collection.");


        }
        else if(room.getMonster()!=null){
            System.out.println("You have to kill the "+room.getMonster().getName()+" first!");
        }
        else{
            System.out.println("There's no treasure to collect in this room :(");
        }
    }

    private void addTreasureToCollection(Treasure treasure){
        treasures.add(treasure);
    }

    public List<Treasure> getTreasureCollections(){
        return treasures;
    }





}
