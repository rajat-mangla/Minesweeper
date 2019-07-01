package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridCell extends JButton {

    private ActionListener gridCellListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button Clicked");
            if (bomb) {
                gameOver();
                System.out.println("GAME OVER");
            } else {
                revealCell();
            }
        }
    };

    private boolean bomb;
    private boolean revealed;
    private int value;

    private int xIndex;
    private int yIndex;

    public void setBomb() {
        this.bomb = true;
    }

    public boolean hasBomb() {
        return this.bomb;
    }

    public void incrementValue() {
        this.value = this.value + 1;
    }

    private void setText() {
        if (this.hasBomb()) {
            this.setText("X");
            this.setBackground(Color.red);
        } else {
            if (value > 0) {
                this.setText(Integer.toString(this.value));
            }
            this.setBackground(Color.white);
        }
    }

    private void revealNeighbours() {
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                int xNew = this.xIndex + xOffset;
                int yNew = this.yIndex + yOffset;
                if ((xNew > -1 && xNew < PlayingAreaContainer.rows) && (yNew > -1 && yNew < PlayingAreaContainer.cols)) {
                    PlayingAreaContainer.playingGrid[xNew][yNew].revealCell();
                }
            }
        }
    }

    private void revealCell() {
        if (!(this.hasBomb()) && !(this.revealed)) {
            this.revealed = true;
            if (this.value == 0) {
                this.revealNeighbours();
            }
            this.setText();
        }
    }

    private void revealAllCells() {
        for (int i = 0; i < PlayingAreaContainer.rows; i++) {
            for (int j = 0; j < PlayingAreaContainer.cols; j++) {

                PlayingAreaContainer.playingGrid[i][j].removeActionListener(gridCellListener);

                if (!PlayingAreaContainer.playingGrid[i][j].revealed) {
                    PlayingAreaContainer.playingGrid[i][j].setText();
                }
            }
        }
    }

    private void gameOver(){
        revealAllCells();
    }

    /*private void addListeners() {
        this.addActionListener(e -> {
            if (bomb) {
                revealAllCells();
                System.out.println("GAME OVER");
            } else {
                revealCell();
            }
            setText();
        });
    }*/

    public GridCell(int xIndex, int yIndex) {
        super();

        this.bomb = false;
        this.revealed = false;
        this.value = 0;

        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.addActionListener(gridCellListener);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
        this.setBackground(Color.lightGray);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
    }
}
