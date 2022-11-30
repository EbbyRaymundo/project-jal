import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.ArrayList;

/**
 * Events class will hold the master list of all the Event objects.
 * An Event object in the Events list will point to its corresponding
 * Decision objects in the Decisions class master list.
 */
public class Events {

    private LinkedHashMap<String, Situation> eventMap; // the String key will represent the name of the eventInMap

    /**
     * Event constructor that creates an empty Events master list
     * that contains no Event objects.
     */
    public Events() {

        this.eventMap = new LinkedHashMap<String, Situation>();
    }

    /*
     * @TODO: Return an iterable of the map instead of the whole damn thing (Fixt but untested)
     * @return ArrayList of Decision objects
     */
    public Collection<Situation> getEvents()
    {
        return this.eventMap.values();
    }
    
    /**
     * @param decision Decision to append to ArrayList of Decision objects
     */
    public void addEvent(Situation eventInMap)
    {
        this.eventMap.put(eventInMap.getName(), eventInMap);
    }

    /**
     * 
     * @param eventInMap
     * @return The Event object associated with the Event name
     */
    public Situation removeEvent(Situation eventInMap)
    {
        return this.eventMap.remove(eventInMap.getName());
    }

    /**
     * Situation subclass stores the name and prompt of the
     * Situation object. The Situation object is referenced by
     * the Events class LinkedHashMap.
     */
    public class Situation {

        private String name;
        private String prompt;
        private ArrayList<Decisions.Choice> decisions;

        /**
         * Event constructor that creates an Event with a prompt but
         * doesn't point to any Decisions.
         * @param prompt
         */
        public Situation(String name, String prompt)
        {
            this.decisions = new ArrayList<Decisions.Choice>();
            this.prompt = prompt;
        }

        /**
         * 
         * @param decisions
         * @return The newly added Decision object
         */
        public ArrayList<Decisions.Choice> setDecisions(ArrayList<Decisions.Choice> decisions){

            this.decisions = decisions;

            return this.decisions;
        }

        /**
         * 
         * @param decision
         */
        public void addChoice(Decisions.Choice choice){

            this.decisions.add(choice);

        }

        /**
         * 
         * @param choice
         */
        public void removeChoice(Decisions.Choice choice){

            this.decisions.remove(choice);

        }
        
        /**
         * 
         */
        public String getName(){

            return this.name;
        }
        
        /**
         * 
         * @param name
         */
        public String setName(String name)
        {
            this.name = name;
    
            return this.name;
        }

        /**
        * 
        * @return prompt string of the Situation object
        */
        public String getPrompt()
        {
            return this.prompt;
        }

        /**
         * 
         * @param prompt
         */
        public String setPrompt(String prompt)
        {
            this.prompt = prompt;
    
            return this.prompt;
        }
    }
}