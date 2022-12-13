import java.util.ArrayList;

public class Decisions {

    private static ArrayList<Choice> choiceList; // the String key will represent the name of the event

    /**
     * Event constructor that creates an empty Decisons master list
     * that contains no Choice objects.
     */
    public Decisions() {

        choiceList = new ArrayList<Choice>();
    }

    public Decisions(ArrayList<Choice> newChoiceList) {

        choiceList = newChoiceList;
    }
    
    /**
     * Puts a new decision object into the decisions LinkedHashMap using
     * its key 
     * @param choice Choice to append to the LinkedHashMap of Choice objects
     * @return The previous Choice value if key existed, null if a new key
     */
    public static void addChoice(Choice newChoice)
    {
        choiceList.add(newChoice);
    }

    /**
     * 
     * @param choice
     * @return The Choice object associated with the Choice name
     */
    public static Choice removeDecision(int choiceKey)
    {
        return choiceList.remove(choiceKey);
    }

    /**
     * Choice subclass stores all the data members of the
     * Choice object. The Choice object is referenced by
     * the Decisions class LinkedHashMap.
     */
    public class Choice {

        private String text;
        private int nextSituationKey;
        // NEGATIVE_INFINITY if there is no threshold
        private double karmaThreshold;
        // this will serve as the Item condition for being able to select this Choice
        private int itemKey;

        /**
         * Constructor
         */
        public Choice (String text, int nextSituationKey, int karmaThreshold, int itemKey)
        {
            this.text = text;
            this.nextSituationKey = nextSituationKey;
            this.karmaThreshold = karmaThreshold;
            this.itemKey = itemKey;
        }

        /**
         * Constructor
         */
        public Choice (String text, int nextSituationKey, double karmaThreshold)
        {
            this.text = text;
            this.nextSituationKey = nextSituationKey;
            this.karmaThreshold = karmaThreshold;
            this.itemKey = -1;
        }

        public Choice (String text, int nextSituationKey, int itemKey) {

            this.text = text;
            this.nextSituationKey = nextSituationKey;
            this.itemKey = itemKey;
            this.karmaThreshold = Double.NEGATIVE_INFINITY;
        }

        public Choice (String text, int nextSituationKey) {

            this.text = text;
            this.nextSituationKey = nextSituationKey;
            this.itemKey = -1;
            this.karmaThreshold = Double.NEGATIVE_INFINITY;
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
        public int getNextSituation( )
        {
            return this.nextSituationKey;
        }

        /**
         * @return karma threshold
         */
        public double getKarmaThreshold( )
        {
            return this.karmaThreshold;
        }

        /**
         * @param newText
         * @return the original text
         */
        public String setText(String newText)
        {
            String oldText = this.text;
            this.text = newText;

            return oldText;
        }

        /**
         * @param null
         */
        public int setNextSituation(int newSituationKey)
        {
            int oldSituation = this.nextSituationKey;
            this.nextSituationKey = newSituationKey;

            return oldSituation;
        }

        /**
         * @param null
         */
        public void setKarmaThreshold(int newKarmaThreshold)
        {
            this.karmaThreshold = newKarmaThreshold;
        }

        /**
         * @param null
         */
        public int setItemCondition(int newItemKey)
        {
            int oldItemKey = this.itemKey;
            this.itemKey = newItemKey;

            return oldItemKey;
        }

        public boolean isAvailable() {

            return(this.itemKey == -1 || (Inventory.getPlayerItems().contains(this.itemKey) && Player.getKarma() >= this.karmaThreshold));
            
        }
    }
}