package GUI;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JFrame windowFrame;

    private JPanel container;
    private ButtonsContainer buttonsContainer;


    private void assignButtonContainer(){
        this.container = new JPanel();
        this.container.setLayout(new GridBagLayout());

        this.buttonsContainer = new ButtonsContainer();

        this.container.add(this.buttonsContainer);
    }

    public MainWindow(){
        this.windowFrame = new JFrame();
        this.windowFrame.setTitle("Minesweeper");
        this.windowFrame.setSize(400, 400);

        assignButtonContainer();

        this.windowFrame.add(this.container);
        this.windowFrame.setVisible(true);
        this.windowFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new MainWindow();
    }
}
