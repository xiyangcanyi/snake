package snake;

import javax.swing.*;
import java.net.URL;

public class Data {
    public static URL headerURL=Data.class.getResource("/static/header.png");
    public static ImageIcon header=new ImageIcon(headerURL);
    public static URL upURL=Data.class.getResource("/static/up.png");
    public static URL downURL=Data.class.getResource("/static/down.png");
    public static URL leftURL=Data.class.getResource("/static/left.png");
    public static URL rightURL=Data.class.getResource("/static/right.png");
    public static URL bodyURL=Data.class.getResource("/static/body.png");
    public static URL foodURL=Data.class.getResource("/static/food.png");
    public static ImageIcon up=new ImageIcon(upURL);
    public static ImageIcon down=new ImageIcon(downURL);
    public static ImageIcon left=new ImageIcon(leftURL);
    public static ImageIcon right=new ImageIcon(rightURL);
    public static ImageIcon body=new ImageIcon(bodyURL);
    public static ImageIcon food=new ImageIcon(foodURL);


}
