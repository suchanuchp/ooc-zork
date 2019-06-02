package room;

import food.Food;
import food.FoodFactory;
import item.Item;
import item.ItemFactory;
import monster.Monster;
import monster.MonsterFactory;
import treasure.Treasure;
import treasure.TreasureFactory;

public class RoomFactory {

    public static Room createRoom(){

        Monster monster = MonsterFactory.createMonster();
        Item item = ItemFactory.createItem();
        Food food = FoodFactory.createFood();
        Room room = new Room(monster, item, food);

        return room;
    }

    public static void setTreasure(Room room){
        Treasure treasure = TreasureFactory.createTreasure();
        room.setTreasure(treasure);
    }
}
