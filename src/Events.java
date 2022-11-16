import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.Map;
import java.util.ArrayList;

/**
 * Events class will hold the master list of all the Event objects.
 * An Event object in the Events list will point to its corresponding
 * Decision objects in the Decisions class master list.
 */
public class Events {

    private LinkedHashMap<String, Event> events; // the String key will represent the name of the event

    /**
     * Event constructor that creates an empty Events master list
     * that contains no Event objects.
     */
    public Events() {

        this.events = new LinkedHashMap<String, Event>();
    }

    /*
     * @TODO: Return an iterable of the map instead of the whole damn thing (Fixt but untested)
     * @return ArrayList of Decision objects
     */
    public Collection<Event> getEvents()
    {
        return this.events.values();
    }
    
    /**
     * @param decision Decision to append to ArrayList of Decision objects
     */
    public void addEvent(Event event)
    {
        this.events.put(event.getName(), event);
    }

    /**
     * 
     * @param event
     * @return The Event object associated with the Event name
     */
    public Event removeEvent(Event event)
    {
        return this.events.remove(event.getName());
    }

    /**
     * Event subclass stores the name and prompt of the
     * Event object. The Event object is referenced by
     * the Events class LinkedHashMap.
     */
    public class Event {

        private String name;
        private String prompt;
        private ArrayList<Decisions.Decision> decisions;

        /**
         * Event constructor that creates an Event with a prompt but
         * doesn't point to any Decisions.
         * @param prompt
         */
        public Event(String name, String prompt)
        {
            this.decisions = new ArrayList<Decisions.Decision>();
            this.prompt = prompt;
        }

        /**
         * 
         * @param decisions
         * @return The newly added Decision object
         */
        public ArrayList<Decisions.Decision> setDecisions(ArrayList<Decisions.Decision> decisions){

            this.decisions = decisions;

            return this.decisions;
        }

        /**
         * 
         * @param decision
         */
        public void addDecision(Decisions.Decision decision){

            this.decisions.add(decision);

        }

        /**
         * 
         * @param decision
         */
        public void removeDecision(Decisions.Decision decision){

            this.decisions.remove(decision);

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
        * @return prompt string of the Event object
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