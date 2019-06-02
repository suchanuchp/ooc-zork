package item;

public class Item {

    private int power;
    private String name;

    public Item(int power, String name) {
        this.power = power;
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public boolean isEqual(String itemString){
        return name.equals(itemString);
    }


}
