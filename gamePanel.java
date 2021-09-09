package snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


import javax.swing.*;

public class gamePanel extends JPanel implements KeyListener, ActionListener {
    int lenth;
    int[] snakeX=new int[600];
    int[] snakeY=new int[500];
    String fx;
    boolean isStart=false;//默认不开始
    boolean isfail=false;
    Timer timer=new Timer(100,this);//100毫秒执行一次
    //食物坐标
    int foodx,foody;
    Random random=new Random();
    int score; //游戏分数！
    //初始化
    public void init(){
        lenth=3;
        snakeX[0]=100;snakeY[0]=100;
        snakeX[1]=75;snakeY[1]=100;
        snakeX[2]=50;snakeY[2]=100;
        fx="R";//初始方向向右
        //定时器以ms为单位
        //把食物随机放在界面上
        foodx=25+25* random.nextInt(34);
        foody=75+25*random.nextInt(24);
        score=0;

    }
    //构造器
    public gamePanel(){
        init();
        //获得焦点和键盘事件
        this.setFocusable(true);//获得焦点事件
        this.addKeyListener(this);//获得键盘监听事件
        timer.start();
    }
    //绘制面板,我们游戏所有东西
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //绘制静态的面板
        this.setBackground(Color.WHITE);
        Data.header.paintIcon(this,g,25,11);//头部广告栏
        g.fillRect(25,75,850,600);//默认游戏界面
        if(fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);//右
        }else if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);//左
        }else if(fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);//上
        }else if (fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);//下
        }
        //Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        for(int i=1;i<lenth;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);//第一个身体坐标
        }
        Data.food.paintIcon(this,g,foodx,foody);
        g.setColor(Color.white);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度 " + lenth, 750, 35);
        g.drawString("分数 " + score , 750, 50);
        //游戏状态
      if(isStart==false){
          g.setColor(Color.WHITE);
          g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
          g.drawString("按空格开始游戏",300,400);
      }
      if(isfail){
          g.setColor(Color.RED);
          g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
          g.drawString("失败，按下空格重新开始",250,400);
      }

    }//绘制面板

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    //键盘监听事件
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE){
            if(isfail){
                isfail=false;
                init();
            }else {
                isStart=!isStart;
            }
        }
        if(keyCode==KeyEvent.VK_UP){fx="U";}
        if(keyCode==KeyEvent.VK_DOWN){fx="D";}
        if(keyCode==KeyEvent.VK_LEFT){fx="L";}
        if(keyCode==KeyEvent.VK_RIGHT){fx="R";}

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override//事件监听---需要固定事件来刷新，一秒10次
    public void actionPerformed(ActionEvent e) {
        if(isStart && isfail==false){//开始状态，小蛇动起来

            //吃食物

            for (int i=lenth-1;i>0;i--){
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            if(fx.equals("R")){
                snakeX[0]=snakeX[0]+25;
                if(snakeX[0]>850) snakeX[0]=25;

            }else if(fx.equals("L")){
                snakeX[0]=snakeX[0]-25;
                if(snakeX[0]<25)snakeX[0]=850;
            }else if(fx.equals("U")){
                snakeY[0]=snakeY[0]-25;
                if(snakeY[0]<75) snakeY[0]=650;

            }else if(fx.equals("D")){
                snakeY[0]=snakeY[0]+25;
                if(snakeY[0]>650) snakeY[0]=75;

            }
            if(snakeX[0]==foodx && snakeY[0]==foody){
                lenth++;
                //再次随机食物
                score=score+10;
                foodx=25+25* random.nextInt(34);
                foody=75+25*random.nextInt(24);
            }
            for (int i = 1; i < lenth; i++) {
                //如果头和身体碰撞，那就说明游戏失败
                if (snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0]) {
                    isfail = true;
                }
            }

            repaint();
        }
        timer.start();//让定时器启动
    }
}
