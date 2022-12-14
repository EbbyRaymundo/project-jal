import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Controller {

    // for(Integer it : Inventory.playerItemlist)
    // System.out.println(Inventory.getItemFromFullList(it).getDescription());
    // //Gets the item discription from the

    public static Events.Situation currentSituation;
    public static Decisions.Choice choice0;
    public static Decisions.Choice choice1;
    public static Decisions.Choice choice2;
    public static Decisions.Choice choice3;

    public static void start() {
        currentSituation = Events.getSituationFromFullList(0);
        String input = JOptionPane.showInputDialog("Please enter your name:");
        if (!input.equals("")) {
            GUI.characterName.setText(input);
            setImage(currentSituation.getImage());

        }
        GUI.start.setEnabled(false);
        GUI.prompt.setText(Events.getSituationFromFullList(0).getPrompt());
        choiceSet(Events.getSituationFromFullList(0));

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

    public static void controlFunction(Decisions.Choice choice) {
        currentSituation = Events.getSituationFromFullList(choice.getNextSituation());
        setImage(currentSituation.getImage());
        if (currentSituation.hasItem()) {

            Inventory.addPlayerItem(currentSituation.getItem());
            //This next very large part sets the Inventory to include the newly aquired item
            if(GUI.invArea.getText().equals("")){
            GUI.invArea.setText(Inventory.getItemFromFullList(currentSituation.getItem()).getName() + " " + Inventory.getItemFromFullList(currentSituation.getItem()).getDescription());
            }
            else{
                GUI.invArea.setText(GUI.invArea.getText() + "\n\n" + Inventory.getItemFromFullList(currentSituation.getItem()).getName() + " " + Inventory.getItemFromFullList(currentSituation.getItem()).getDescription());
            }

        }

        GUI.prompt.setText(currentSituation.getPrompt());
        choiceSet(currentSituation);
    }

    /**
     * The for
     * 
     * @param choices key list of Choice objects within the
     *                Decisions.choiceList ArrayList
     */
    public static void choiceSet(Events.Situation sit) {

        for (int i = 0; i < 4; i++) {
            //
            if (i < sit.getChoices().size() && Decisions.choiceList.get(sit.getChoices().get(i)).isAvailable()) {

                set(i, Decisions.choiceList.get(sit.getChoices().get(i)).getText(),
                        Decisions.choiceList.get(sit.getChoices().get(i)));
            } else {
                // we don't want to try accessing out of bounds in the getChoices()
                // ArrayList so we hand it an empty String instead
                set(i, "", null);
            }
        }
    }

    public static void set(int i, String text, Decisions.Choice choice) {

        switch (i) {
            case 0:
                GUI.label1.setText(text);
                choice0 = choice;
                break;
            case 1:
                GUI.label2.setText(text);
                choice1 = choice;
                break;
            case 2:
                GUI.label3.setText(text);
                choice2 = choice;
                break;
            case 3:
                GUI.label4.setText(text);
                choice3 = choice;
               
                break;
            default:
                break;
        }
    }

    public static void setImage(String imageName) {
        if (currentSituation.hasImage()) {
            Image image = new ImageIcon("src//photos//" + imageName).getImage();
            Image scaledImage = image.getScaledInstance((GUI.depth.getWidth() - 10), (GUI.depth.getHeight() - 10),
                    Image.SCALE_SMOOTH);
            GUI.icon.setIcon(new ImageIcon(scaledImage));
            GUI.icon.setBounds(0, 0, 350, 400);
            GUI.depth.add(GUI.icon);
        }
        else{
            GUI.icon.setIcon(null);
            GUI.depth.add(GUI.icon);
        }
    }
}