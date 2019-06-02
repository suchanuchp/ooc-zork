package treasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreasureFactory {

    private static int i = 0;

    private static List<Treasure> treasures = new ArrayList<Treasure>(Arrays.asList(new Treasure("diamonds"),
            new Treasure("snitch"), new Treasure("elder-wand"), new Treasure("time-turner"),
            new Treasure("socerer's-stone"), new Treasure("hedwig")));

    public static Treasure createTreasure(){
        if(i<treasures.size()){
            return treasures.get(i++);
        }
        return null;
    }
}
