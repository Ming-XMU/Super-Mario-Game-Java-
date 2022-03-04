package 马里奥;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements Runnable{
	//bg List 存储背景图片
	private ArrayList<Background> bg = new ArrayList<>();
	//显示当前背景
	public  Background nowbg = new Background();
	//双缓存
	public Image offScreenImage ;
	//马里奥对象
	private mario mario = new mario();
	//马里奥的运动线程
	private Thread thread = new Thread(this);
	//切换背景
	
	public static void main(String args[]) {
		
		MyFrame mf = new MyFrame();
		mf.showUI();
	}
	
	//设置窗口界面
	public void showUI() {
		
		
		//设置窗口名称
		this.setTitle("马里奥");
		//设置窗口大小
		this.setSize(800,600);
		//设置窗口居中显示
		this.setLocationRelativeTo(null);
		//设置窗口点击关闭结束运行
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小不可变
		this.setResizable(false);
		//设置窗口添加键盘监听器
		Listener Listener = new Listener();
		this.addKeyListener(Listener);
		//添加按钮
		ImageIcon icon = new ImageIcon("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/start.jpg");
		JButton button1 = new JButton(icon);
		button1.setSize(1000,800);
		button1.setContentAreaFilled(false);
		button1.addActionListener(Listener);
		button1.setFocusPainted(false);
		this.add(button1);
		
//		javax.swing.JButton jbu1 = new javax.swing.JButton("");
//		JButton jb2 = new JButton();
//		JButton jb3 = new JButton();
//		this.add(jbu1);

		//流式布局
		this.setLayout(new FlowLayout());
		//设置窗口可见
		this.setVisible(true);
		//初始化图片
		Huancun.init();
		
		//循环创建所有场景
			for(int i = 1;i<=3;i++) {		
				bg.add(new Background(i,i == 3 ? true :false));		
			}
	
			//初始化马里奥
			mario = new mario(10,355);
			Listener.mario = mario;
			
			//设置当前场景
			nowbg = bg.get(0);
			mario.setmariobg(nowbg);
			repaint();
			
			//启动线程
			thread.start();
			this.remove(button1);
			//背景音乐
//			new music();
			
		
	}
	
	public void paint(Graphics g) {
		
	//双缓存
		offScreenImage = createImage(800,600);
		Graphics g1 = offScreenImage.getGraphics();
		
    //缓冲区绘图
	    //将背景绘制在缓冲区上
		g1.drawImage(nowbg.getBgimage(),0,0,this);
		//绘制敌人
		for(Enemy enemy : nowbg.getEnemylist()) {
			g1.drawImage(enemy.getEnemy(),enemy.getX(),enemy.getY(),this);
		}
		//绘制不同的障碍物
		for(zhangai zhangai : nowbg.getZhangailist()) {
			g1.drawImage(zhangai.getZhangai(),zhangai.getX(),zhangai.getY(),this);
		}
		//绘制城堡和旗帜
		g1.drawImage(nowbg.getTower(),620,270,this);
		g1.drawImage(nowbg.getGan(),500,220,this);
		
	//绘制马里奥
//		System.out.println("X 的值为 "+mario.getX());
//		System.out.println("Y 的值为 "+mario.getY());
//		System.out.println("图片 ："+mario.getmario());
//		System.out.println("马里奥"+ mario);
		
		g1.drawImage(mario.getmario(),mario.getX(),mario.getY(),this);
		
		//显示分数
		Color c  = g1.getColor();
		g1.setColor(Color.black);
		g1.setFont(new Font("黑体",Font.BOLD,25));
		g1.drawString("当前分数为 "+mario.getScore(), 300, 100);
		g1.setColor(c);
		
		
	//将缓冲区的图片画出来
		g.drawImage(offScreenImage,0,0,this);
	}
	
	
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(50);
		//设置场景切换	
			if(mario.getX() >= 775) {
				
				nowbg = bg.get(nowbg.getBw());
				mario.setmariobg(nowbg);
				mario.setX(10);
				mario.setY(355);
			  }
			
			//判断马里奥是否死了
			if(mario.isMariodeath()) {
				
				JOptionPane.showMessageDialog(this, "死了！！！！！！！！！！！！！！！！！！！！！！");
				System.out.println("死了！！！！！！！！！！！！！！！！！！！！！");
				System.exit(0);
				
			}

			//判断游戏是否结束
			if(mario.getOk()) {
				
				JOptionPane.showMessageDialog(this, "通关了！！！！！！！！！！！！！！！！！");
				System.out.println("游戏结束！！！！！！！！！！！！！！！！！！！！");
				
				System.exit(0);
				
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
