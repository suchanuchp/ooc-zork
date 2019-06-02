package item;

import monster.Monster;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemFactory {

    private static final double WATER_PROB = 0.25;
    private static final double POTION_PROB = 0.1;
    private static final double SWORD_PROB = 0.25;
    private static final double KNIFE_PROB = 0.25;



    private static Map<String, Double > probabilities = new LinkedHashMap<String, Double>() {{
        put("water bucket", WATER_PROB);
        put("potion", POTION_PROB);
        put("sword", SWORD_PROB);
        put("knife", KNIFE_PROB);
    }};

    public static Item createItem(){
        double random = Math.random();
        for (Map.Entry<String, Double> entry : probabilities.entrySet()) {
            String type = entry.getKey();
            Double prob = entry.getValue();
            if(random < prob) {
                return getItem(type);
            } else{
                random = random - prob;
            }
        }
        return null;
    }

    public static Item getItem(String type){
        if(type.equals("potion"))
            return new Item(40, type);
        else if(type.equals("sword"))
            return new Item(100, "sword");
        else if(type.equals("knife"))
            return new Item(80, type);
        else
            return new Item(10, type);
    }
}
