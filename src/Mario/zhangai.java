package 马里奥;

import java.awt.image.BufferedImage;

public class zhangai implements Runnable{
	//障碍物坐标
	private int x,y;
	//障碍物类型
	private int type;
	//障碍物图像
	private BufferedImage zhangai ;
	//当前背景图像
	private Background bg ;


	//结束动画线程
	private Thread thread = new Thread(this);
	
	//构造方法
	public zhangai(int x,int y,int type,Background bg) {
		
		this.x = x;
		this.y = y;
		this.type = type;
		this.bg = bg;
		this.zhangai = Huancun.zhangai.get(type);
		//动画线程启动
		if(type == 9) {
			thread.start();
		}
	}
	
	public void run() {
		
		while(true) {
			if(this.bg.isWin()) {
				if(this.y < 372 ) {
					this.y +=5;
				}else {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					this.bg.setFinish(true);
				}
			
				
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
    
	
	//get 方法
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getType() {
		return type;
	}

	public BufferedImage getZhangai() {
		return zhangai;
	}
	public Background getBg() {
		return bg;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

}
