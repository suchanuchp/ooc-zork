package monster;

import monster.Monster;

import java.util.LinkedHashMap;
import java.util.Map;

public class MonsterFactory {

    private static final double PIKA_PROB = 0.25;
    private static final double DRAGON_PROB = 0.2;
    private static final double BASIL_PROB = 0.2;
    private static final double WOLF_PROB = 0.2;
    private static final double TROLL_PROB = 0.15;



    private static Map<String, Double > probabilities = new LinkedHashMap<String, Double>() {{
        put("pikachu", PIKA_PROB);
        put("dragon", DRAGON_PROB);
        put("basilisk", BASIL_PROB);
        put("troll", WOLF_PROB);
        put("werewolf", TROLL_PROB);
    }};

    public static Monster createMonster(){
        double random = Math.random();
        for (Map.Entry<String, Double> entry : probabilities.entrySet()) {
            String type = entry.getKey();
            Double prob = entry.getValue();
            if(random < prob) {
                return getMonster(type);
            } else{
                random = random - prob;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }

    public static Monster getMonster(String type){
        if(type.equals("pikachu"))
            return new Pikachu();
        else if(type.equals("dragon"))
            return new Dragon();
        else if(type.equals("basilisk"))
            return new Basilisk();
        else if(type.equals("troll"))
            return new Troll();
        else
            return new Werewolf();
    }
}
