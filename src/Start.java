// Executes all other classes, will be the main class to instantiate all objects
public class Start {

	public static void main(String[] args) {
		System.out.println("Enter your name:");

		String playerName = "" + System.console().readLine();

		Player mainCharacter = new Player(playerName);

		System.out.println(mainCharacter.getName()); // Should be whatever the player types in
		System.out.println(mainCharacter.getKarma()); // Should be 0
		System.out.println(mainCharacter.getInventory()); // idek

	}

}
