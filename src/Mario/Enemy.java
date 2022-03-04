package 马里奥;

import java.awt.image.BufferedImage;

public class Enemy implements Runnable{
	
	//敌人坐标
	private int x, y;
	//敌人类型
	private int type;
	//运动方向
	private boolean face = false ;
	//敌人图像
	private BufferedImage enemy;
	//背景图
	private Background bg; 
	//运动范围
	private int max = 0;
	private int min = 0;
	//当前图片状态
	private int a;
	//定义线程对象 控制di'ren'yun'd
	private Thread thread = new Thread(this);
	
	//蘑菇怪
	public Enemy(int x ,int y,boolean face,int type, Background bg) {
			
			this.x = x;
			this.y = y;
			this.face = face;
			this.type = type;
			this.bg = bg;
			enemy = Huancun.mushroom.get(0);
			thread.start();
	}
	
	//死亡判定
	public void death(){
		
		enemy = Huancun.mushroom.get(2);
		this.bg.getEnemylist().remove(this);
		
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage getEnemy() {
		return enemy;
	}

	public void setEnemy(BufferedImage enemy) {
		this.enemy = enemy;
	}
	public int getType() {
		return type;
	}

	//食人花
	public Enemy(int x ,int y,boolean face,int type, Background bg,int max ,int min ) {
			
			this.x = x;
			this.y = y;
			this.face = face;
			this.type = type;
			this.bg = bg;
			this.max = max;
			this.min = min;
			enemy = Huancun.monster.get(0);
			thread.start();
		}
	
	public void run() {
		
		while(true) {
			//判断是否是蘑菇敌人
			if(type == 1) {
				
				if(face) {
					this.x -= 2;
				}else {
					this.x += 2;
				}
				
				a = a == 1 ? 0:1;
				enemy = Huancun.mushroom.get(a);
			}
				//跟马里奥碰到障碍的判断方式一样
				//定义两个布尔变量，判断是否能向左右移动
				boolean right = true;
				boolean left = true;
//				System.out.println("right 的值 "+right);
//				System.out.println("left 的值 "+left);
				for(int i = 0;i<bg.getZhangailist().size();i++) {
					
					zhangai zhangai = bg.getZhangailist().get(i);
//					System.out.println("距离值  "+(zhangai.getX()-this.x));
					//判断是否可以向右走
					if(zhangai.getX() == this.x +36 && (zhangai.getY() + 65 > this.y && zhangai.getY() - 35 < this.y)) {
						right = false;
//						System.out.println("right 的值 "+right);
					}
					//向左走
					if(zhangai.getX() == this.x -36 && (zhangai.getY() + 65 > this.y && zhangai.getY() - 35 < this.y)) {
						left = false;
//						System.out.println("left 的值 "+left);
					}
				}
				
				
				if(face && (!left) || this.x == 0) {
					
					face = false;
					
				}
				else if((!face) && (!right) || this.x >= 764) {
					
					face = true;
				}
			
	
			
			if(type == 2) {
				
				if(face) {
					this.y -= 5;
				}else {
					this.y += 5;
				}
				
				a = a == 1 ? 0:1;
				
				//是否移动到上下限
				if(face &&(this.y <= max)) {
					
					face = false;
				}
				if(!face &&(this.y >= min)) {
					
					face = true;
				}
				enemy = Huancun.monster.get(a);
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}

}
