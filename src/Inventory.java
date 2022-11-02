import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {

        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems() {

        return this.items;
    }

    /**
     * @param null
     */
    public ArrayList<Item> setItems(ArrayList<Item> items) {

      this.items = items;

      return this.items;
    }

    /**
     * @param null
     */
    public void addItem(Item item) {

        this.items.add(item);
    }

    public void removeItem(Item item) {

        this.items.remove(item);


    }
    
}