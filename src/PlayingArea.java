import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PlayingArea {
    private int rows = 15;
    private int cols = 15;
    private int numberBombs = 30;
    private GridCell playingGrid[][];

    public void setup(){
        JFrame frame = new JFrame("GridLayout Demo");
        JPanel jPanel = new JPanel(new GridLayout(rows, cols));

        int assignedBombs = 0;

        for (int i=0;i<rows;i++){
            for (int j=0; j<cols; j++){
                //int cellNumber = i*cols + j;
                playingGrid[i][j] = new GridCell();
                if (assignedBombs <numberBombs){
                    Double rand = Math.random();
                    Double threshold = 0.85;
                    if (rand > threshold) {
                        playingGrid[i][j].setBomb();
                        assignedBombs = assignedBombs + 1;
                    }
                }
                jPanel.add(playingGrid[i][j]);
            }
        }
        System.out.println(assignedBombs);

        setupGridCells();
        //showGridValues();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().add(jPanel);
        frame.setVisible(true);
    }

    private void setupGridCells() {
        int offset[] = {-1, 0, 1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (playingGrid[i][j].hasBomb()){
                    for (int iOffset = 0; iOffset < offset.length; iOffset++){
                        for (int jOffset = 0; jOffset < offset.length; jOffset++){
                            if ( ((i+offset[iOffset]) >= 0 && (i+offset[iOffset]) < rows)
                                    && ((j+offset[jOffset]) >=0 && (j+offset[jOffset]) < cols)){
                                playingGrid[i+offset[iOffset]][j+offset[jOffset]].incrementValue();
                            }
                        }
                    }
                }
            }
        }
    }

    /*private void showGridValues() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                playingGrid[i][j].settext();
            }
        }
    }*/

    PlayingArea(){
        playingGrid = new GridCell[rows][cols];
    }

    public static void main(String[] args){
        PlayingArea playingArea = new PlayingArea();
        playingArea.setup();
    }
}
