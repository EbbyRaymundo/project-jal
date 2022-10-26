public class Decision{

    private String name;
    
    private String text;
    
    private Event nextEvent;
    
    private int karmaThreshold;
    
    private Item condition;
    
    /**
     * Constructo
     */
    public Decision ()
    {
        this.name = "";
        this.text = "";
        this.nextEvent = new Event();
        this.karmaThreshold = 0;
        this.condition = new Item ();
    }
    
    /**
     * @return Decision name
     */
    public static String getName( )
    {
        return null;
    }
    
    /**
     * @return Decision text
     */
    public static String getText( )
    {
        return null;
    }
    
    /**
     * @return next Event
     */
    public static Event getNextEvent( )
    {
        return null;
    }
    
    /**
     * @return karma threshold
     */
    public static int getKarmaThreshold( )
    {
        return -1;
    }
    
    /**
     * @return condition
     */
    public static Item getCondition( )
    {
        return null;
    }
    
    /**
     * @param null
     */
    public void setName( )
    {

    }
    
    /**
     * @param null
     */
    public void setText( )
    {
        
    }
    
    /**
     * @param null
     */
    public void setNextEvent( )
    {

    }
    
    /**
     * @param null
     */
    public void setKarmaThreshold( )
    {
        
    }
    
    /**
     * @param null
     */
    public void setCondition( )
    {
        
    }
}