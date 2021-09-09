import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testDemo {
    public static void main(String args[]){
        new MyFrame();

    }
}
class MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);
        ActionListen1 actionListen1=new ActionListen1();
        textField.addActionListener(actionListen1);
        setLocation(200,200);
        setSize(400,400);
        textField.setEchoChar('*');
        setVisible(true);
        pack();//自己设置适合的大小


    }

}
class ActionListen1 implements ActionListener{


    @Override
    public void actionPerformed(ActionEvent e) {
        TextField field = (TextField) e.getSource();
       System.out.println(field.getText());
       field.setText("");
      // System.exit(0);
    }
}
