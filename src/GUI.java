import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    // declare parts of GUI so they can be seen by other components of the GUI
    private static JPanel mainPanel;
    public static JPanel depth;
    private static JPanel rectangle;

    public static JLabel icon;
    public static JLabel characterName;
    private static JLabel hook;

    public static JTextArea invArea;
    public static JTextArea prompt;
    private static JScrollPane scrollingInv;
    private static JScrollBar invBar;
    private static JScrollPane scrollingPrompt;
    private static JScrollBar promptBar;

    public static JTextArea label1;
    public static JTextArea label2;
    public static JTextArea label3;
    public static JTextArea label4;

    public static JButton start;
    public static JButton cancel;
    public static JButton button1;
    public static JButton button2;
    public static JButton button3;
    public static JButton button4;

    private static int promptTextSize = 40;
    private static int labelTextSize = 30;
    private static int invTextSize = 20;
    private static Color backgroundDarkGray = new Color(0x222327);
    private static Color textTan = new Color(0x8c8477);
    private static Color brickRed = new Color(0xa54b29);
    private static Color myYellow = new Color(0xf3be22);
    private static Color choiceGreen = new Color(0x717341);
    private static Color darkGreen = new Color(0x545847);
    private static Color darkTan = new Color(0x8c8477);

    public GUI() {

        // Creating the Objects to stack
        super("J.ump A.nd L.ink");
        setSize(1215, 900);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(); // Main Panel
        mainPanel.setLayout(null);
        mainPanel.setBackground(backgroundDarkGray);

        add(mainPanel);

        rectangle = new JPanel(); // Rectangle for Inventory
        rectangle.setBounds(75, 760, 1050, 90);
        rectangle.setBackground(null);
        rectangle.setForeground(myYellow);
        Border redLine = BorderFactory.createLineBorder(brickRed);// title stuff
        TitledBorder title = BorderFactory.createTitledBorder(redLine, "Inventory");
        title.setTitleColor(brickRed);
        rectangle.setBorder(title);

        mainPanel.add(rectangle);

        // Inventory Area where text will be updated to add to the Inventory, gets
        // wrapped with scrollbar
        invArea = new JTextArea();
        invArea.setFont(new Font("Serif", Font.ROMAN_BASELINE, invTextSize));
        invArea.setBackground(backgroundDarkGray);
        invArea.setForeground(myYellow);
        invArea.setEditable(false);
        invArea.setText("");
        invArea.setLineWrap(true);
        invArea.setWrapStyleWord(true);
        scrollingInv = new JScrollPane(invArea);
        scrollingInv.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollingInv.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        invBar = scrollingInv.getVerticalScrollBar();
        invBar.setBackground(choiceGreen);

        scrollingInv.setBounds(120, 775, 1000, 70);

        mainPanel.add(scrollingInv);

        depth = new JPanel(); // Panel for Photos
        depth.setBounds(830, 50, 350, 400);
        depth.setBackground(darkTan);
        depth.setBorder(new LineBorder(darkTan, 3));

        mainPanel.add(depth);

        icon = new JLabel(); // Image for Photo Panel

        characterName = new JLabel(); // Character Name
        characterName.setBounds(30, 5, 300, 30);
        characterName.setFont(new Font("Serif", Font.BOLD, 24));
        characterName.setForeground(myYellow);

        mainPanel.add(characterName);

        hook = new JLabel(); // Flavor Text
        hook.setBounds(550, 450, 200, 30);
        hook.setFont((new Font("Serif", Font.BOLD, 15)));
        hook.setForeground(myYellow);
        hook.setText("Time is a Circle");

        mainPanel.add(hook);

        prompt = new JTextArea(); // Prompt Panel with Scrollbar
        prompt.setFont(new Font("Serif", Font.ROMAN_BASELINE, promptTextSize));
        prompt.setLineWrap(true);
        prompt.setWrapStyleWord(true);
        prompt.setEditable(false);
        prompt.setBackground(backgroundDarkGray);
        prompt.setForeground(textTan);
        // wraps in scrollpane()
        scrollingPrompt = new JScrollPane(prompt); // creates sp.JScrollPane and applies it to the prompt
        scrollingPrompt.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollingPrompt.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollingPrompt.setBounds(5, 40, 800, 400); // we want the panel to be wider than it is tall for reading
        scrollingPrompt.setBorder(new LineBorder(brickRed, 2));
        promptBar = scrollingPrompt.getVerticalScrollBar();
        promptBar.setBackground(darkGreen);

        mainPanel.add(scrollingPrompt);

        // Adds the text areas for the choices
        //
        label1 = new JTextArea(); // First Choice Label
        label1.setEditable(false);
        label1.setBounds(25, 500, 250, 200);
        label1.setFont(new Font("Serif", Font.ROMAN_BASELINE, labelTextSize));
        label1.setWrapStyleWord(true);
        label1.setLineWrap(true);
        label1.setBackground(null);
        label1.setForeground(textTan);
        label1.setBorder(new LineBorder(brickRed));

        mainPanel.add(label1);

        label2 = new JTextArea(); // Second Choice Label
        label2.setEditable(false);
        label2.setBounds(325, 500, 250, 200);
        label2.setFont(new Font("Serif", Font.ROMAN_BASELINE, labelTextSize));
        label2.setWrapStyleWord(true);
        label2.setLineWrap(true);
        label2.setBackground(null);
        label2.setForeground(textTan);
        label2.setBorder(new LineBorder(brickRed));

        mainPanel.add(label2);

        label3 = new JTextArea(); // Third Choice Label
        label3.setEditable(false);
        label3.setBounds(625, 500, 250, 200);
        label3.setFont(new Font("Serif", Font.ROMAN_BASELINE, labelTextSize));
        label3.setWrapStyleWord(true);
        label3.setLineWrap(true);
        label3.setBackground(null);
        label3.setForeground(textTan);
        label3.setBorder(new LineBorder(brickRed));

        mainPanel.add(label3);

        label4 = new JTextArea(); // Fourth Choice Label
        label4.setEditable(false);
        label4.setBounds(925, 500, 250, 200);
        label4.setFont(new Font("Serif", Font.ROMAN_BASELINE, labelTextSize));
        label4.setWrapStyleWord(true);
        label4.setLineWrap(true);
        label4.setBackground(null);
        label4.setForeground(textTan);
        label4.setBorder(new LineBorder(brickRed));

        mainPanel.add(label4);

        // Adds the Start and Cancel buttons
        start = new JButton("Start");// Start Button + Name Entry
        start.setBounds(875, 15, 100, 20);
        start.setBackground(darkGreen);
        start.setBorder(new LineBorder(choiceGreen, 3));
        start.setForeground(myYellow);
        start.addActionListener(this);

        mainPanel.add(start);

        cancel = new JButton("Exit");// Cancel Button (Closes Program)
        cancel.setBounds(1025, 15, 100, 20);
        cancel.setBackground(darkGreen);
        cancel.setBorder(new LineBorder(choiceGreen, 3));
        cancel.setForeground(myYellow);
        cancel.addActionListener(this);

        mainPanel.add(cancel);

        // Adds the buttons for the choices to the GUI
        button1 = new JButton("Select");
        button1.setBounds(25, 700, 250, 50);
        button1.setBackground(choiceGreen);
        button1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        button1.setForeground(myYellow);
        button1.setBorder(new LineBorder(darkGreen, 3));
        button1.addActionListener(this);

        mainPanel.add(button1);

        button2 = new JButton("Select");
        button2.setBounds(325, 700, 250, 50);
        button2.setBackground(choiceGreen);
        button2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        button2.setForeground(myYellow);
        button2.setBorder(new LineBorder(darkGreen, 3));
        button2.addActionListener(this);

        mainPanel.add(button2);

        button3 = new JButton("Select");
        button3.setBounds(625, 700, 250, 50);
        button3.setBackground(choiceGreen);
        button3.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        button3.setForeground(myYellow);
        button3.setBorder(new LineBorder(darkGreen, 3));
        button3.addActionListener(this);

        mainPanel.add(button3);

        button4 = new JButton("Select");
        button4.setBounds(925, 700, 250, 50);
        button4.setBackground(choiceGreen);
        button4.setFont(new Font("Serif", Font.ROMAN_BASELINE, 22));
        button4.setForeground(myYellow);
        button4.setBorder(new LineBorder(darkGreen, 3));
        button4.addActionListener(this);

        mainPanel.add(button4);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) { // CHOICE 1
            if (Controller.choice0 != null) {
                Controller.action1();
            }
        }
        if (e.getSource() == button2) { // CHOICE 2
            if (Controller.choice1 != null) {
                Controller.action2();
            }
        }
        if (e.getSource() == button3) { // CHOICE 3
            if (Controller.choice2 != null) {
                Controller.action3();
            }
        }
        if (e.getSource() == button4) { // CHOICE 4
            if (Controller.choice3 != null) {
                Controller.action4();
            }
        }

        if (e.getSource() == start) { // START
            Controller.start();
        }

        if (e.getSource() == cancel) { // EXIT
            System.exit(0);
        }
    }

}