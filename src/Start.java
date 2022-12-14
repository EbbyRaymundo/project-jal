/**
 * Executes all other classes, will be the main class to instantiate all objects.
 * Has functions that allow for the modular testing of the Model, View, and Controller
 * separately so that they can easily be turned off in main( ).
 */
public class Start {

	public static void testGUI() {

		new GUI();

	}

	public static void testController() {

	}

	public static void testModel() {
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
		System.out.println(Decisions.getChoiceFromFullList(6).getNextSituation()); // will be false
		System.out.println("test");
		Inventory.addPlayerItem(0); // this is how you add an item. 0 corresponds to the phone
		System.out.println(Decisions.getChoiceFromFullList(5).isAvailable()); // will be true

		for (Integer it : Inventory.getPlayerItems()) {
			// this is how you access an Item's data from checking what the player has
			System.out.println(Inventory.getItemFromFullList(it).getDescription());

		}

	}

	public static void main(String[] args) {

		
		try {
			Inventory.readSlimeFile("src/horror.slime");
			Events.readSlimeFile("src/horror.slime");
			Decisions.readSlimeFile("src/horror.slime");
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
