package 马里奥;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener implements KeyListener, ActionListener{
	public mario mario;
	public boolean start = false;


	public void keyTyped(KeyEvent e) {
		    	
	}
	public void keyPressed(KeyEvent e){
		//按右箭头向右移动
		if(e.getKeyCode() == 39) {
			mario.move_right();
		}
		//按右箭头向右移动
		if(e.getKeyCode() == 37) {
			mario.move_left();
		}
		//上箭头跳跃
		if(e.getKeyCode() == 38) {
			
			mario.jump();
			
		}
		    	
    }
	public void keyReleased(KeyEvent e) {
		
		//松开 停止
		if(e.getKeyCode() == 37) {
			mario.stop_left();
		}
		if(e.getKeyCode() == 39) {
			mario.stop_right();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		start = true;
//		System.out.println("点击按钮");
//		System.out.println("start "+start);
	}
	public boolean isStart() {
		return start;
	}
	
}
