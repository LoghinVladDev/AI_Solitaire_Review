package Gameplay;

import javax.swing.*;
import java.awt.*;

public class ShuffleButton extends JPanel { //not extending Pile because a button has no need for cards

    private Button shuffleButton;
    public static String shuffleButtonFileName = "GameplayImages/ShuffleButton", extension = ".png";


    public Button getShuffleButton() {
        return shuffleButton;
    }

    public Image getShuffleButtonImage() {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(shuffleButtonFileName + extension));
        Image shuffleButtonImage = imageIcon.getImage();

        return shuffleButtonImage;
    }

   public ShuffleButton (int x, int y, int initSize) {
        this.setSize(149, 49);
        this.setLocation(x, y);


   }

   @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        graphics.setColor(Color.BLUE);
        g2d.drawLine(25,25, 149, 0);
        g2d.drawLine(25,25,0,80);
        g2d.drawLine(this.getWidth() -1, 0, this.getHeight() -1, 0);

        g2d.setPaint(new GradientPaint(36 , 0, new Color(0,0,139, 160), 36, 60,
                new Color(0,0,139, 160), true));
        g2d.fillRect(0,0,this.getWidth(), this.getHeight());


        Image shuffleButtonImage = getShuffleButtonImage();
        if (shuffleButtonImage != null) {
            graphics.drawImage(shuffleButtonImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }

    }
}
