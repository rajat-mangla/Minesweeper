package GUI;

import javax.swing.*;
import java.awt.*;

public class ButtonsContainer extends JPanel {
    private JButton playButton;
    private JButton exitButton;

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    private void setup(){
        this.playButton = new JButton("PLAY");
        this.playButton.setMargin(new Insets(20,20,20,20));
        //this.playButton.setBounds(150, 50, 100, 50);

        this.exitButton = new JButton("EXIT");
        this.exitButton.setMargin(new Insets(20,20,20,20));
        //this.exitButton.setBounds(150, 110, 100, 50);
    }

    private void setupGUI(){
        this.setLayout(new GridLayout(2,1));
        this.setup();

        this.add(this.playButton);
        this.add(this.exitButton);
    }

    public ButtonsContainer(){
        super();
        this.setupGUI();
    }
}
