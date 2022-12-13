import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.*;

import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener{
    //declare parts of GUI so they can be seen by other components of the GUI
    private static JPanel mainPanel;
    private static JPanel depth;
    private static JLabel icon;
    private static JLabel characterName;
    private static JLabel hook;
    private static JTextArea prompt;
    private static JScrollPane scrollingPrompt;
    private static JTextArea label1;
    private static JTextArea label2;
    private static JTextArea label3;
    private static JTextArea label4;
    private static JButton button1;
    private static JButton button2;
    private static JButton button3;
    private static JButton button4;
    private static Color backgroundDarkGray = new Color(0x222327);
    private static Color borderGray = new Color(0x475059);
    private static Color textTan = new Color(0x8c8477);
    private static Color brickRed = new Color(0xa54b29);
    private static Color myYellow = new Color(0xf3be22);
    private static Color choiceGreen = new Color(0x717341);
    private static Color darkGreen = new Color(0x545847);
    private static Color darkTan = new Color(0x8c8477);
    

    public GUI(){

        //Creating the Objects to stack
        super("J.ump A.nd L.ink");
        setSize(1215,900);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        


//
        //mainPanel is the MAIN PANEL
//

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(backgroundDarkGray);
        add(mainPanel);

        depth = new JPanel();
        depth.setBounds(830, 50, 350, 400);
        depth.setBackground(borderGray);
        depth.setBorder(new LineBorder(darkTan,3));
        mainPanel.add(depth);

        icon = new JLabel();
        Image image = new ImageIcon("src//photos//me_when_java.jpg").getImage();
        Image scaledImage = image.getScaledInstance(depth.getWidth(), depth.getHeight(), Image.SCALE_SMOOTH);
        icon.setIcon(new ImageIcon(scaledImage));
        depth.add(icon);


        // Setting character name that will always be present at the top of the GUI
        characterName = new JLabel("Harrier");
        characterName.setBounds(5,5,100,30 );
        characterName.setFont(new Font("Serif", Font.BOLD, 24));
        characterName.setForeground(myYellow);
        mainPanel.add(characterName);

        hook = new JLabel("Time is a Circle");
        hook.setBounds(550, 450, 200,30);
        hook.setFont((new Font("Serif", Font.BOLD, 15)));
        hook.setForeground(myYellow);   
        mainPanel.add(hook);


        //creates the prompt.JTextArea and fills it with text
        prompt = new JTextArea();
        //we will eventually use files for this part
        prompt.setText("The demo for DSDA that's all I care about. I am not going to stream as I do not care for an audience and am not influenced by the accusations of an envious stranger. I only streamed briefly for a short time in the past out of curiosity, but it does not interest me nor do I feel passion for it. I haven't watched Twitch in over a year, I was drawn to it in my spare time during the short period prior to my first full time job after finishing my studies. My life has changed a lot in the past two years and their are far more important aspects in life which draw my attention, I have little free time as well. Also you must be very self-conscious if you honestly think one has to stream their demo to demonstrate they aren't cheating, that just indicates your disrespect and distrust towards other players with exceptional playing ability, you'll never be a talented survivalist like me :) Let me make it clear I don't give a damn what you or anyone else thinks of me, when I am passionate about a subject I will speak my mind truthfully even if it means being brash at times, both online and in real life, I won't be intimidated by anyone and will confront them with assertion and confidence. I'm here for fun, making speedruns and commenting on subjects once in a while which capture my eye. Thank you for revealing your true colors, seething with jealously and enveloped by arrogance, you've lost what respect I had for you. If you've come to your senses you will offer an apology, take a good luck in the mirror before you make such a disgusting accusation against a fellow Doom player, who has not caused strife and discord but shows humility and respect with a care free attitude, or will you continue this charade and repeat history, replicating the case of Okuplok? If you do continue to accuse, it will be solely for my amusement as I will not take you seriously and will likely ignore you. Choose wisely.");
        prompt.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        //title = BorderFactory.createTitledBorder(null)
        prompt.setLineWrap(true);
        prompt.setWrapStyleWord(true);
        prompt.setEditable(false);
        prompt.setBackground(backgroundDarkGray);
        prompt.setForeground(textTan);
        
        

        //creates sp.JScrollPane and applies it to the prompt
        //
        scrollingPrompt = new JScrollPane(prompt);
        scrollingPrompt.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        scrollingPrompt.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollingPrompt.setBounds(5,40,800,400); // we want the panel to be wider than it is tall for reading purposes
        scrollingPrompt.setBorder(new LineBorder(brickRed, 2));
        JScrollBar scrollBar = scrollingPrompt.getVerticalScrollBar();
        scrollBar.setBackground(darkGreen);
        mainPanel.add(scrollingPrompt);

        //Adds the text areas for the choices
        //
        label1 = new JTextArea();
        label1.setEditable(false);
        label1.setBounds(25,500,250,200);
        label1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        label1.setWrapStyleWord(true);
        label1.setLineWrap(true);
        label1.setBackground(null);
        label1.setForeground(textTan);
        label1.setBorder(new LineBorder(brickRed));
        label1.setText("This is the first Choice:\n Something straightforward");


        label2 = new JTextArea();
        label2.setEditable(false);
        label2.setBounds(325,500,250,200);
        label2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        label2.setWrapStyleWord(true);
        label2.setLineWrap(true);
        label2.setBackground(null);
        label2.setForeground(textTan);
        label2.setBorder(new LineBorder(brickRed));
        label2.setText("This is the first Choice:\n Something straightforward");

        label3 = new JTextArea();
        label3.setEditable(false);
        label3.setBounds(625,500,250,200);
        label3.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        label3.setWrapStyleWord(true);
        label3.setLineWrap(true);
        label3.setBackground(null);
        label3.setForeground(textTan);
        label3.setBorder(new LineBorder(brickRed));
        label3.setText("This is the first Choice:\n Something straightforward");

        label4 = new JTextArea();
        label4.setEditable(false);
        label4.setBounds(925,500,250,200);
        label4.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        label4.setWrapStyleWord(true);
        label4.setLineWrap(true);
        label4.setBackground(null);
        label4.setForeground(textTan);
        label4.setBorder(new LineBorder(brickRed));
        label4.setText("This is the first \nChoice:\n Something \nstraightforward");

        mainPanel.add(label1);
        mainPanel.add(label2);
        mainPanel.add(label3);
        mainPanel.add(label4);

        //Adds the buttons for the choices to the GUI
        //
        button1 = new JButton("Select");
        button1.setBounds(25,700,250,50);
        button1.setBackground(choiceGreen);
        button1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        button1.setForeground(myYellow);
        button1.setBorder(new LineBorder(darkGreen,3));
        button1.addActionListener(this);
        mainPanel.add(button1);

        button2 = new JButton("Select");
        button2.setBounds(325,700,250,50);
        button2.setBackground(choiceGreen);
        button2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        button2.setForeground(myYellow);
        button2.setBorder(new LineBorder(darkGreen,3));
        button2.addActionListener(this);
        mainPanel.add(button2);

        button3 = new JButton("Select");
        button3.setBounds(625, 700, 250,50);
        button3.setBackground(choiceGreen);
        button3.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        button3.setForeground(myYellow);
        button3.setBorder(new LineBorder(darkGreen,3));
        button3.addActionListener(this);
        mainPanel.add(button3);

        button4 = new JButton("Select");
        button4.setBounds(925, 700, 250,50);
        button4.setBackground(choiceGreen);
        button4.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        button4.setForeground(myYellow);
        button4.setBorder(new LineBorder(darkGreen,3));
        button4.addActionListener(this);
        mainPanel.add(button4);


		setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){}
        if(e.getSource() == button2){}
        if(e.getSource() == button3){}
        if(e.getSource() == button4){}
    }



}