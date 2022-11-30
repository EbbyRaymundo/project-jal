import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener{
    //declare parts of GUI so they can be seen by other components of the GUI
    private static JPanel mainPanel;
    private static JLabel characterName;
    private static JTextArea prompt;
    private static JScrollPane scrollingPrompt;
    private static JScrollPane scrollingDecision;
    private static JPanel decisionPanel;
    private static JButton button1;
    private static JButton button2;
    private static JButton button3;
    private static JButton button4;


    public GUI(){

        //Creating the Objects to stack
        super("J.ump A.nd L.ink");
        setSize(1200,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//
        //mainPanel is the MAIN PANEL
//

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        add(mainPanel);

        // Setting character name that will always be present at the top of the GUI
        characterName = new JLabel("Harrier");
        characterName.setBounds(5,5,100,30 );
        characterName.setFont(new Font("Serif", Font.BOLD, 24));
        mainPanel.add(characterName);

        //creates the prompt.JTextArea and fills it with text
        prompt = new JTextArea();
        prompt.setText("The demo for DSDA that's all I care about. I am not going to stream as I do not care for an audience and am not influenced by the accusations of an envious stranger. I only streamed briefly for a short time in the past out of curiosity, but it does not interest me nor do I feel passion for it. I haven't watched Twitch in over a year, I was drawn to it in my spare time during the short period prior to my first full time job after finishing my studies. My life has changed a lot in the past two years and their are far more important aspects in life which draw my attention, I have little free time as well. Also you must be very self-conscious if you honestly think one has to stream their demo to demonstrate they aren't cheating, that just indicates your disrespect and distrust towards other players with exceptional playing ability, you'll never be a talented survivalist like me :) Let me make it clear I don't give a damn what you or anyone else thinks of me, when I am passionate about a subject I will speak my mind truthfully even if it means being brash at times, both online and in real life, I won't be intimidated by anyone and will confront them with assertion and confidence. I'm here for fun, making speedruns and commenting on subjects once in a while which capture my eye. Thank you for revealing your true colors, seething with jealously and enveloped by arrogance, you've lost what respect I had for you. If you've come to your senses you will offer an apology, take a good luck in the mirror before you make such a disgusting accusation against a fellow Doom player, who has not caused strife and discord but shows humility and respect with a care free attitude, or will you continue this charade and repeat history, replicating the case of Okuplok? If you do continue to accuse, it will be solely for my amusement as I will not take you seriously and will likely ignore you. Choose wisely.");
        prompt.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        prompt.setLineWrap(true);
        prompt.setWrapStyleWord(true);
        prompt.setEditable(false);
        
        //creates sp.JScrollPane and applies it to the prompt
        scrollingPrompt = new JScrollPane(prompt);
        scrollingPrompt.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        scrollingPrompt.setBounds(5,40,800,400); // we want the panel to be wider than it is tall for reading purposes
        mainPanel.add(scrollingPrompt);

        
        /* This code will dynamically generate as many buttons as we ne
        JButton btn;
        for (int i=1; i<=4; i++) {
            for (int j=1; j<=4; j++) {
                btn = new JButton();
                btn.setPreferredSize(new Dimension(100, 100));
                firstPanel.add(btn); 
        */
        //Creates the panel that will contain Decision Buttons
        JPanel decisionPanel = new JPanel();
        decisionPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;


        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;





        JButton button1 = new JButton("Does something spectacular");
        button1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        JButton button2 = new JButton("eh");
        button2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        JButton button3 = new JButton("In all honesty pressing this button will not get you anywhere at all,maybe you should just face it, you're a fraud");
        button3.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        JButton button4 = new JButton("damn that guy was angry");
        button4.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        decisionPanel.add(button1, gbc);
        decisionPanel.add(button2, gbc);
        decisionPanel.add(button3, gbc);
        decisionPanel.add(button4, gbc);        
        





        // add JScrollPane so that you can scroll through the different decisions if they don't fit on the GUI
        scrollingDecision = new JScrollPane(decisionPanel);
        scrollingDecision.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        scrollingDecision.setBounds(5,450,800,400);
        mainPanel.add(scrollingDecision);



		setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {}


}
