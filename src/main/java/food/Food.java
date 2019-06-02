package food;

public class Food {

    private String name;
    private int energy;

    public Food(int energy, String name){
        this.name = name;
        this.energy = energy;
    }
    public String getName(){
        return this.name;
    }

    public int getEnergy(){
        return this.energy;
    }

}
