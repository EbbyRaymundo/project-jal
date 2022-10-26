public class Decision{

    private String name;
    
    private String text;
    
    private Event nextEvent;
    
    private int karmaThreshold;
    
    private Item condition;
    
    public Decision ()
    {
        this.name = "";
        this.text = "";
        this.nextEvent = new Event();
        this.karmaThreshold = 0;
        this.condition = new Item ();
    }
    
    public static String getName( )
    {
        return null;
    }
    
    public static String getText( )
    {
        return null;
    }
    
    public static Event getNextEvent( )
    {
        return null;
    }
    
    public static int getKarmaThreshold( )
    {
        return -1;
    }
    
    public static Item getCondition( )
    {
        return null;
    }
}