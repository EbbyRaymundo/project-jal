import java.awt.Image;
import javax.swing.ImageIcon;

public class Controller {

    public static String[] testArray = new String[] { "Hi there", "Testinggg", "Fun Times", "Last one" };

    public static void start() {
        
    }

    public static void action1() {
        GUI.button1.setEnabled(false);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testSet(testArray);
        GUI.button1.setEnabled(true);
    }

    public static void action2() {

    }

    public static void action3() {

    }

    public static void action4() {

    }

    public static void controlFunction(int x){

    }





    public static void dispSet(String text) {
        GUI.prompt.setText(text);
    }

    public static void testSet(String[] test) {
        for (int i = 0; i < test.length; i++) {
            set(i, test[i]);
        }
    }

    /**
     * The for
     * 
     * @param choices key list of Choice objects within the
     *                Decisions.choiceList ArrayList
     */
    public static void choiceSet(Events.Situation sit) {

        for (int i = 0; i < sit.getChoices().size(); i++) {
            set(i, Decisions.choiceList.get(sit.getChoices().get(i)).getText());
        }
    }

    public static void set(int i, String text) {
        if (i == 0) {
            GUI.label1.setText(text);
        } else if (i == 1) {
            GUI.label2.setText(text);
        } else if (i == 2) {
            GUI.label3.setText(text);
        } else if (i == 3) {
            GUI.label4.setText(text);
        }
    }

    public static void setImage(String imageName) {
        if (!imageName.equals("")) {
            Image image = new ImageIcon("src//photos//" + imageName).getImage();
            Image scaledImage = image.getScaledInstance((GUI.depth.getWidth() - 10), (GUI.depth.getHeight() - 10),
                    Image.SCALE_SMOOTH);
            GUI.icon.setIcon(new ImageIcon(scaledImage));
            GUI.icon.setBounds(0, 0, 350, 400);
            GUI.depth.add(GUI.icon);
        }
    }
}