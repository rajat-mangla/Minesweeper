import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridCell extends JButton {
    private boolean bomb = false;
    private int value = 0;

    public GridCell(){
        super();
        addListeners();

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
        this.setBackground(Color.lightGray);
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

    public void setText(){
        if (this.hasBomb()){
            this.setText("X");
            this.setBackground(Color.red);
        }else{
            if (value > 0){
                this.setText(Integer.toString(this.value));
            }
            this.setBackground(Color.white);
        }
    }

    public void addListeners(){
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setText();
            }
        });
    }
}
