import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Controller {

    public static Events.Situation currentSituation;
    public static Decisions.Choice choice0;
    public static Decisions.Choice choice1;
    public static Decisions.Choice choice2;
    public static Decisions.Choice choice3;

    /**
     * Sets the game state to Situation 0 and prompts the user for their character name
     */
    public static void start() {
        currentSituation = Events.getSituation(0);
        String input = JOptionPane.showInputDialog("Please enter your name:");
        if (!input.equals("")) {
            GUI.characterName.setText(input);
            setImage(currentSituation.getImage());

        }
        GUI.start.setEnabled(false);
        GUI.prompt.setText(Events.getSituation(0).getPrompt());
        choiceSet(Events.getSituation(0));

    }

    public static void action1() {
        GUI.button1.setEnabled(false);
        controlFunction(choice0);
        GUI.button1.setEnabled(true);
    }

    public static void action2() {
        GUI.button2.setEnabled(false);
        controlFunction(choice1);
        GUI.button2.setEnabled(true);
    }

    public static void action3() {
        GUI.button3.setEnabled(false);
        controlFunction(choice2);
        GUI.button3.setEnabled(true);
    }

    public static void action4() {
        GUI.button4.setEnabled(false);
        controlFunction(choice3);
        GUI.button4.setEnabled(true);
    }

    /**
     * Logic control for advancing the player to the next
     * Situation after selecting a Choice. Hands the player
     * the Situation's Item if it has one. Sets the image
     * if the Situation has one.
     * 
     * @param choice that the player selected
     */
    public static void controlFunction(Decisions.Choice choice) {

        currentSituation = choice.getNextSituation();
        setImage(currentSituation.getImage());

        if (currentSituation.hasItem()) {

            Inventory.addPlayerItem(currentSituation.getItemKey());
            // This next very large part sets the Inventory to include the newly aquired
            // item
            if (GUI.invArea.getText().equals("")) {
                GUI.invArea.setText(currentSituation.getItem().getName() + " "
                        + currentSituation.getItem().getDescription());
            } else {
                GUI.invArea.setText(GUI.invArea.getText() + "\n\n"
                        + currentSituation.getItem().getName() + " "
                        + currentSituation.getItem().getDescription());
            }

        }

        GUI.prompt.setText(currentSituation.getPrompt());
        choiceSet(currentSituation);
    }

    /**
     * The iterates through the 4 Choices and calls set( )
     * to set up their text in the GUI.
     * 
     * @param choices key list of Choice objects within the
     *                Decisions.choiceList ArrayList
     */
    public static void choiceSet(Events.Situation sit) {

        for (int i = 0; i < 4; i++) {

            // if we haven't exceeded how many Choices this Situation has
            if (i < sit.getChoices().size() && sit.getNthChoice(i).isAvailable()) {

                set(i, sit.getNthChoice(i));
            } 
            else {
                // we don't want to try accessing out of bounds in the getChoices()
                // ArrayList so we hand it null instead
                set(i, null);
            }
        }
    }

    public static void set(int i, Decisions.Choice choice) {

        String choiceText;

        if (choice == null) { choiceText = ""; }

        else { choiceText = choice.getText(); }

        switch (i) {
            case 0:
                GUI.label1.setText(choiceText);
                choice0 = choice;
                break;
            case 1:
                GUI.label2.setText(choiceText);
                choice1 = choice;
                break;
            case 2:
                GUI.label3.setText(choiceText);
                choice2 = choice;
                break;
            case 3:
                GUI.label4.setText(choiceText);
                choice3 = choice;
                break;
            default:
                break;
        }
    }

    public static void setImage(String imageName) {
        if (currentSituation.hasImage()) {
            Image image = new ImageIcon("photos/" + imageName).getImage();
            Image scaledImage = image.getScaledInstance((GUI.depth.getWidth() - 10), (GUI.depth.getHeight() - 10),
                    Image.SCALE_SMOOTH);
            GUI.icon.setIcon(new ImageIcon(scaledImage));
            GUI.icon.setBounds(0, 0, 350, 400);
            GUI.depth.add(GUI.icon);
        } else {
            GUI.icon.setIcon(null);
            GUI.depth.add(GUI.icon);
        }
    }
}