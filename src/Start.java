// Executes all other classes, will be the main class to instantiate all objects
public class Start {

	public static void testGUI() {

		new GUI();

	}

	public static void testController() {

	}

	public static void testModel() {

	}

	public static void readSlimeFile(String filePath) {

		try {
			Inventory.readSlimeFile(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Events.readSlimeFile(filePath);
		// Decisions.readSlimeFile(filePath);

	}

	public static void main(String[] args) {
		/*
		 * System.out.println("Enter your name:");
		 * 
		 * String playerName = "" + System.console().readLine();
		 * 
		 * Player mainCharacter = new Player(playerName);
		 * 
		 * //Inventory.Item gun = new Inventory.Item("Gun", "It's a gun");
		 * 
		 * int[] myArray = {0, 1, 2, 3, 4};
		 * 
		 * 
		 * System.out.println(mainCharacter.getName()); // Should be whatever the player
		 * types in
		 * System.out.println(mainCharacter.getKarma()); // Should be 0
		 * //System.out.println(mainCharacter.addToInventory(gun));
		 * System.out.println(mainCharacter.getInventory()); // idek
		 * System.out.println(myArray[1]);
		 */
		try {
			Inventory.readSlimeFile("src/master.slime");
			Events.readSlimeFile("src/master.slime");
			Decisions.readSlimeFile("src/master.slime");
		} catch (Exception e) {
			// @TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("Event\n");
		// for (Events.Situation std : Events.situationList) {
		// // these are how you invoke the different instance variables
		// // of a Situation
		// 	System.out.println(std.getPrompt());
		// 	System.out.println(std.getChoices().size());
		// 	System.out.println(std.getItem());
		// 	System.out.println(std.getImage());
		// }
		// System.out.println("Decisions\n");
		// for (Decisions.Choice ch : Decisions.choiceList) {
		// 	// these are how you invoke the instance variables
		// 	// of a Choice
		// 	System.out.println(ch.getText());
		// 	System.out.println(ch.getNextSituation());
		// 	System.out.println(ch.getClass());
		// }
		// System.out.println("Inventory\n");

		// for (Inventory.Item it : Inventory.fullItemList) {
		// 	// these are how you invoke the instance variables
		// 	// of an Item
		// 	System.out.println(it.getDescription());
		// 	System.out.println(it.getName());
		// 	System.out.println(it.getClass());

		// }
		// System.out.println(Decisions.getChoiceFromFullList(6).getNextSituation()); // will be false
		// System.out.println("test");
		// Inventory.addPlayerItem(0); // this is how you add an item. 0 corresponds to the phone
		// System.out.println(Decisions.getChoiceFromFullList(5).isAvailable()); // will be true

		// for (Integer it : Inventory.getPlayerItems()) {
		// 	// this is how you access an Item's data from checking what the player has
		// 	System.out.println(Inventory.getItemFromFullList(it).getDescription());

		// }

		
		//  for(Integer it : Inventory.playerItemList){
		//   System.out.println(it.getDescription());
		//   System.out.println(it.getName());
		//   System.out.println(it.getClass());
		//   }
		

		testGUI();
		// testController();
		// testModel();
	}
}
