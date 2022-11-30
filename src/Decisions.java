import java.util.LinkedHashMap;
import java.util.Collection;


public class Decisions {

    private LinkedHashMap<String, Choice> decisions; // the String key will represent the name of the event

    /**
     * Event constructor that creates an empty Decisons master list
     * that contains no Choice objects.
     */
    public Decisions() {

        this.decisions = new LinkedHashMap<String, Choice>();
    }

    /*
     * @TODO: Return an iterable of the map instead of the whole damn thing (Fixt but untested)
     * @return ArrayList of Decision objects
     */
    public Collection<Choice> getDecisions()
    {
        return this.decisions.values();
    }
    
    /**
     * Puts a new decision object into the decisions LinkedHashMap using
     * its key 
     * @param choice Choice to append to the LinkedHashMap of Choice objects
     * @return The previous Choice value if key existed, null if a new key
     */
    public Choice addDecision(Choice choice)
    {
        return this.decisions.put(choice.getName(), choice);
    }

    /**
     * 
     * @param choice
     * @return The Choice object associated with the Choice name
     */
    public Choice removeDecision(Choice choice)
    {
        return this.decisions.remove(choice.getName());
    }

    /**
     * Choice subclass stores all the data members of the
     * Choice object. The Choice object is referenced by
     * the Decisions class LinkedHashMap.
     */
    public class Choice {

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
        public Choice ()
        {
            this.name = "";
            this.text = "";
            this.nextEvent = null;
            this.karmaThreshold = 0;
            //@TODO: Create a condition method
            this.condition = -1;
        }

        /**
         * @return Choice name
         */
        public String getName( )
        {
            return this.name;
        }

        /**
         * @return Choice text
         */
        public String getText( )
        {
            return this.text;
        }

        /**
         * @return next Situation
         */
        public Events.Situation getNextSituation( )
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