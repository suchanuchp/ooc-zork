package food;

import java.util.LinkedHashMap;
import java.util.Map;

public class FoodFactory {
    private static final double SANDWICH_PROB = 0.03;
    private static final double PIE_PROB = 0.02;
    private static final double CHOCO_PROB = 0.04;
    private static final double PIZZA_PROB = 0.04;



    private static Map<String, Double > probabilities = new LinkedHashMap<String, Double>() {{
        put("sandwich", SANDWICH_PROB);
        put("pie", PIE_PROB);
        put("chocolate", CHOCO_PROB);
        put("pizza", PIZZA_PROB);
    }};

    public static Food createFood(){
        double random = Math.random();
        for (Map.Entry<String, Double> entry : probabilities.entrySet()) {
            String type = entry.getKey();
            Double prob = entry.getValue();
            if(random < prob) {
                return getFood(type);
            } else{
                random = random - prob;
            }
        }
        return null;
    }

    public static Food getFood(String type){
        if(type.equals("sandwich"))
            return new Food(30, type);
        else if(type.equals("pie"))
            return new Food(20, type);
        else if(type.equals("chocolate"))
            return new Food(10, type);
        else
            return new Food(30, type);

    }
}
