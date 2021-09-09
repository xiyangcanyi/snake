package snake;

import javax.swing.*;
import java.awt.*;

public class startGame {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setBounds(10,10,900,720);
        frame.setResizable(false);
        frame.add(new gamePanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
