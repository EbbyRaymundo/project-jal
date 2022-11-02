public class Item {

    private String name;
    
    private String description;
    
    /**
     * Constructor
     */
    public Item ()
    {
        this.name = "";
        this.description = "";
    }

    /**
     * Constructor
     */
    public Item (String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    
    /**
     * @return Item name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * @return Item description
     */
    public String getDescription() 
    {
        return this.description;
    }

    /**
     * @param null
     */
    public String setName(String newName)
    {
        this.name = newName;

        return this.name;
    }
    /**
     * @param null
     */
    public String setDescription(String newDescription)
    {
        this.description = newDescription;

        return this.description;
    }
}