/**
 * Executes all other classes, will be the main class to instantiate all objects.
 * Has functions that allow for the modular testing of the Model, View, and Controller
 * separately so that they can easily be turned off in main( ).
 */
public class Start {

	public static void testGUI() {

		new GUI();

	}

	/**
	 * @deprecated
	 * This method checks to see if things are getting added to the master lists
	 * and in the correct order. This method no longer works since the master
	 * lists are no longer public variables. The master lists can be changed
	 * to public if you'd still like to use this method to see if you formatted
	 * things correctly in the slimeball.
	 */
	@Deprecated
	public static void testModel( ) {

		/*
		System.out.println("Event\n");

		for (Events.Situation std : Events.situationList) {
			// these are how you invoke the different instance variables
			// of a Situation
			System.out.println(std.getPrompt());
			System.out.println(std.getChoices().size());
			System.out.println(std.getItem());
			System.out.println(std.getImage());
		}

		System.out.println("Decisions\n");

		for (Decisions.Choice ch : Decisions.choiceList) {
			// these are how you invoke the instance variables
			// of a Choice
			System.out.println(ch.getText());
			System.out.println(ch.getNextSituation());
			System.out.println(ch.getClass());
		}

		System.out.println("Inventory\n");

		for (Inventory.Item it : Inventory.fullItemList) {
			// these are how you invoke the instance variables
			// of an Item
			System.out.println(it.getDescription());
			System.out.println(it.getName());
			System.out.println(it.getClass());

		}

		System.out.println(Decisions.getChoice(6).getNextSituation()); // will be false
		System.out.println("test");
		Inventory.addPlayerItem(0); // this is how you add an item. 0 corresponds to the phone
		System.out.println(Decisions.getChoice(5).isAvailable()); // will be true

		for (Integer it : Inventory.getPlayerItems()) {
			// this is how you access an Item's data from checking what the player has
			System.out.println(Inventory.getItem(it).getDescription());

		}
		*/

	}

	public static void main(String[] args) {

		String slimeFile = args[0]; // arg [0] is the name of the slimeball

		try {
			Inventory.readSlimeFile(slimeFile);
			Events.readSlimeFile(slimeFile);
			Decisions.readSlimeFile(slimeFile);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		//testModel();
		//testGUI();
		//testController();
		new GUI();
	}
}
