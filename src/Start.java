// Executes all other classes, will be the main class to instantiate all objects
public class Start {

	public static void testGUI() {

		GUI tester = new GUI();

	}

	public static void testController() {


	}

	public static void testModel () {

		
	}

	public static void readSlimeFile(String filePath) {

		Events.readSlimeFile(filePath);
		Decisions.readSlimeFile(filePath);
		Inventory.readSlimeFile(filePath);
	}

	public static void main(String[] args) {
		/*
		System.out.println("Enter your name:");

		String playerName = "" + System.console().readLine();

		Player mainCharacter = new Player(playerName);

		//Inventory.Item gun = new Inventory.Item("Gun", "It's a gun");

		int[] myArray = {0, 1, 2, 3, 4};


		System.out.println(mainCharacter.getName()); // Should be whatever the player types in
		System.out.println(mainCharacter.getKarma()); // Should be 0
		//System.out.println(mainCharacter.addToInventory(gun));
		System.out.println(mainCharacter.getInventory()); // idek
		System.out.println(myArray[1]);
		*/
		testGUI();
		testController();
		testModel();
	}
}
