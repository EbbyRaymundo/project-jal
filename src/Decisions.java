import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collection;


public class Decisions {

    private LinkedHashMap<String, Decision> decisions; // the String key will represent the name of the event

    /**
     * Event constructor that creates an empty Events master list
     * that contains no Event objects.
     */
    public Decisions() {

        this.decisions = new LinkedHashMap<String, Decision>();
    }

    /*
     * @TODO: Return an iterable of the map instead of the whole damn thing (Fixt but untested)
     * @return ArrayList of Decision objects
     */
    public Collection<Decision> getDecisions()
    {
        return this.decisions.values();
    }
    
    /**
     * Puts a new decision object into the decisions LinkedHashMap using
     * its key 
     * @param decision Decision to append to ArrayList of Decision objects
     * @return The previous Decision value if key existed, null if a new key
     */
    public Decision addDecision(Decision decision)
    {
        return this.decisions.put(decision.getName(), decision);
    }

    /**
     * 
     * @param decision
     * @return The Event object associated with the Event name
     */
    public Decision removeDecision(Decision decision)
    {
        return this.decisions.remove(decision.getName());
    }

    /**
     * Decision subclass stores all the data members of the
     * Decision object. The Decision object is referenced by
     * the Decisions class LinkedHashMap.
     */
    public class Decision {

        private String name;

        private String text;

        // @TODO think about how the Decision will reference the next
        // Event in the Events master list.
        private Events nextEvent;

        private int karmaThreshold;

        private int condition; // @TODO: Figure out how to set this

        /**
         * Constructor
         */
        public Decision ()
        {
            this.name = "";
            this.text = "";
            this.nextEvent = null;
            this.karmaThreshold = 0;
            //@TODO: Create a condition method
            this.condition = -1;
        }

        /**
         * @return Decision name
         */
        public String getName( )
        {
            return this.name;
        }

        /**
         * @return Decision text
         */
        public  String getText( )
        {
            return this.text;
        }

        /**
         * @return next Event
         */
        public Events.Event getNextEvent( )
        {
            return null;
        }

        /**
         * @return karma threshold
         */
        public int getKarmaThreshold( )
        {
            return this.karmaThreshold;
        }

        /**
         * @return condition
         */
        public Inventory.Item getCondition( )
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
}