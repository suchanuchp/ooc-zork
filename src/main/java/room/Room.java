package room;


import food.Food;
import item.Item;
import monster.Monster;
import treasure.Treasure;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private Monster monster;

    private List<Item> items;

    private Food food;

    private Treasure treasure;

    public Room(Monster monster, Item item, Food food) {
        this.monster = monster;
        this.items = new ArrayList<Item>();
        if(item!=null){ this.items.add(item);}
        this.food = food;
        this.treasure = null;

    }
    public void setTreasure(Treasure treasure){
        this.treasure = treasure;
    }

    public Treasure getTreasure(){
        return treasure;
    }

    public Treasure getTreasureAndRemove(){
        Treasure temp = treasure;
        treasure = null;
        return temp;
    }

    public void describe(){
        if (monster==null && items.isEmpty()&&treasure==null){
            System.out.println("You're in an empty room.");
        }
        else if(monster==null){
            System.out.println("Items in the room:");
            for(Item item : items){
                System.out.println(item.getName());
            }

        }
        else if(items.isEmpty()){
            System.out.println("You're in a room with a " + monster.getName() + ".");
        }

        else{
            System.out.println("You're in a room with a " + monster.getName() + ".");
            if(!items.isEmpty()){

                System.out.println("Items in the room:");
                for(Item item : items){

                    System.out.println(item.getName());
                }
            }

        }
        if(treasure!=null){
            if(monster!=null){
                System.out.println("The "+monster.getName()+" is guarding a "+treasure.getName()+"." );
            }
            else{
                System.out.println("There's a "+ treasure.getName()+" in this room.");
            }
        }

        if(food!=null){
            System.out.println("There's also "+food.getName()+" here.");
        }


    }



    public Item getItemAndRemove(String itemString){
        if(!hasItem(itemString)){
            return null;
        }
        else{
            int index = getItemIndex(itemString);
            Item item = items.get(index);
            items.remove(index);
            return item;
        }

    }


    public boolean hasItem(String itemString){
        return getItemIndex(itemString)!=-1;
    }

    public int getItemIndex(String itemString){
        int i = 0;
        for(Item item : items){
            if(item.isEqual(itemString)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public Food getAndRemoveFood(){
        Food temp = this.food;
        this.food = null;
        return temp;
    }


    public void addItem(Item item){
        items.add(item);
    }

    public Monster getMonster(){
        return this.monster;
    }
    public void removeMonster(){
        monster = null;
    }
}
