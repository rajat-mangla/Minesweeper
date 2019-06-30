
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GridCell extends JButton {
    private boolean bomb = false;
    private boolean revealed = false;
    private int value = 0;

    private int xIndex;
    private int yIndex;

    public GridCell(int xIndex, int yIndex) {
        super();

        this.xIndex = xIndex;
        this.yIndex = yIndex;
        addListeners();

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
        this.setBackground(Color.lightGray);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
    }

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
                if ((xNew > -1 && xNew < PlayingArea.rows) && (yNew > -1 && yNew < PlayingArea.cols)) {
                    PlayingArea.playingGrid[xNew][yNew].revealCell();
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
        } else {
            System.out.println("Already Revealed or it is a BOMB");
        }
    }

    private void revealAllCells(){
        for (int i = 0; i < PlayingArea.rows; i++) {
            for (int j = 0; j < PlayingArea.cols; j++) {
                if (!PlayingArea.playingGrid[i][j].revealed){
                    PlayingArea.playingGrid[i][j].setText();
                }
            }
        }
    }


    private void addListeners() {
        this.addActionListener(e -> {
            if (bomb) {
                revealAllCells();
                System.out.println("GAME OVER");
            } else {
                revealCell();
            }
            setText();
        });
    }
}
