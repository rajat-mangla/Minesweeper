import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GridCell extends JLabel {
    private boolean bomb = false;
    private int value = 0;

    public GridCell(){
        super();

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
    }

    public void setBomb(){
        this.bomb = true;
    }

    public boolean hasBomb(){
        return this.bomb;
    }

    public void incrementValue(){
        this.value = this.value + 1;
    }

    public void settext(){
        if (this.hasBomb()){
            this.setText("X");
        }else{
            this.setText(Integer.toString(this.value));
        }
    }
}
