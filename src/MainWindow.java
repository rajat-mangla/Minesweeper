import GUI.ButtonsContainer;
import GUI.PlayingAreaContainer;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JFrame windowFrame;

    private JPanel container;
    private ButtonsContainer buttonsContainer;
    private PlayingAreaContainer playingAreaContainer;

    private void setupPlayingAreaContainer(){
        this.playingAreaContainer = new PlayingAreaContainer();

        this.windowFrame.remove(this.container);
        this.windowFrame.add(this.playingAreaContainer);
        this.windowFrame.validate();
        //this.windowFrame.getContentPane().add(this.playingAreaContainer);
    }

    private void setupButtonsContainerListeners(){
        JButton playButton = this.buttonsContainer.getPlayButton();
        playButton.addActionListener(e -> {
            setupPlayingAreaContainer();
        });

        JButton exitButton = this.buttonsContainer.getExitButton();
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    private void setupButtonsContainer(){
        this.buttonsContainer = new ButtonsContainer();
        setupButtonsContainerListeners();

        this.container.setLayout(new GridBagLayout());
        this.container.add(this.buttonsContainer);
    }

    private void setupGUI(){
        this.windowFrame = new JFrame();
        this.windowFrame.setTitle("Minesweeper");
        this.windowFrame.setSize(600, 600);
        this.windowFrame.setResizable(true);

        this.container = new JPanel();
        this.windowFrame.add(this.container);
        setupButtonsContainer();

        this.windowFrame.setVisible(true);
        this.windowFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public MainWindow(){
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                setupGUI();
            }
        });
    }

    public static void main(String[] args){
        new MainWindow();
    }
}
