package GUI;

import javax.swing.*;
import java.awt.*;

public class PlayingAreaContainer extends JPanel{
    private int numberBombs = 30;

    public static int rows = 15;
    public static int cols = 15;
    public static GridCell playingGrid[][];

    private void setupNeighbouringCellValues(int x, int y){

        for (int xOffset = -1; xOffset <= 1; xOffset++){
            for (int yOffset = -1; yOffset <= 1; yOffset++){
                int xNew = x + xOffset;
                int yNew = y + yOffset;
                if ((xNew > -1 && xNew < PlayingAreaContainer.rows) && (yNew > -1 && yNew < PlayingAreaContainer.cols)){
                    playingGrid[xNew][yNew].incrementValue();
                }
            }
        }
    }

    private void setupGridCells() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (playingGrid[i][j].hasBomb()){
                    this.setupNeighbouringCellValues(i, j);
                }
            }
        }
    }

    private void setup(){
        int assignedBombs = 0;

        for (int i=0;i<rows;i++){
            for (int j=0; j<cols; j++){
                //int cellNumber = i*cols + j;
                playingGrid[i][j] = new GridCell(i,j);

                if (assignedBombs < numberBombs){
                    Double rand = Math.random();
                    Double threshold = 0.85;
                    if (rand > threshold) {
                        playingGrid[i][j].setBomb();
                        assignedBombs = assignedBombs + 1;
                    }
                }
                this.add(playingGrid[i][j]);
            }
        }
        System.out.println(assignedBombs);

        setupGridCells();
        //showGridValues();
    }

    /*private void showGridValues() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                playingGrid[i][j].settext();
            }
        }
    }*/

    public PlayingAreaContainer(){
        super(new GridLayout(rows, cols));
        playingGrid = new GridCell[rows][cols];
        setup();
    }
}
