import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUI extends JFrame implements ActionListener{
    //declare parts of GUI so they can be seen by other components of the GUI
    private static JPanel promptPanel;
    private static JPanel decisionPanel;
    private static JLabel characterName;

    public GUI(){

        //Creating the Objects to stack
        super("J.ump A.nd L.ink");


        promptPanel = new JPanel();
        decisionPanel = new JPanel();

        
        characterName = new JLabel();

        //construction of GUI



        //musthaves
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(800,500);
        
        

    }
    
    public void actionPerformed(ActionEvent e) {}







}
