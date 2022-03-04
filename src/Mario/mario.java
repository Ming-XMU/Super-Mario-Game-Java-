package 马里奥;

import java.awt.image.BufferedImage;

public class mario implements Runnable {
	//马里奥的当前位置
	private int x,y;
	//马里奥的状态
	private String status;
	//当前的图像
	private BufferedImage mario;
	//获取背景里障碍物的信息
	private Background mariobg = new Background();
	//用线程实现马里奥的动作
	private Thread thread;
	//马里奥的移动
	private int speed;
	//马里奥的跳跃
	private int jump;
	//取得马里奥运动图像
	public int index;
	//跳跃参数
	public int up;
	//马里奥是否走到了城堡
	private Boolean ok = false;
	public zhangai zhangai;
	//判断马里奥是否死亡
	private  boolean mariodeath = false;
	//积分
	private int score = 0;
	


	public mario() {
		
	}
	public mario(int x,int y) {
		
		this.x = x;
		this.y = y;
		this.mario = Huancun.stand_R;
		this.status = "stop-right";
		this.thread = new Thread(this);
		thread.start();
		
	}
	public void mariodeath() {
		mariodeath = true;
	}
	
	//马里奥向左移动
	public void move_left() {
		
		//设置马里奥的速度
		speed = -5;
		//判断马里奥是否碰到旗子
		if(mariobg.isWin()) {
			speed = 0;
		}
		//判断是否在跳跃中
		if(status.indexOf("jump") != -1) {
			status = "jump-left";
		}else {
			status = "move-left";
		}
		
	}
	
	
	//马里奥向右移动
		public void move_right() {
			
			//设置马里奥的速度
			speed = 5;
			//判断马里奥是否碰到旗子
			if(mariobg.isWin()) {
				speed = 0;
			}
			//判断是否在跳跃中
			if(status.indexOf("jump") != -1) {
				status = "jump-right";
			}else {
				status = "move-right";
			}
		}
			
	//马里奥停止
			public void stop_left() {
				speed = 0 ;
				if(status.indexOf("jump") != -1) {
					status = "jump-left";
				}else {
					status = "stop-left";
				}
			}
			public void stop_right() {
				speed = 0 ;
//				System.out.println("status 的值 "+status.indexOf("jump"));
				if(status.indexOf("jump") != -1) {
					status = "jump-right";
				}else {
					status = "stop-right";
				}
			}

		//马里奥跳跃方法
			public void jump() {
				//判断是否为跳跃状态
				if(status.indexOf("jump") == -1) {
					if(status.indexOf("left") != -1) {
						status = "jump-left";
					}else {
						status = "jump-right";
					}
				
					jump = -10;
					up = 7;
				}
				//判断马里奥是否碰到旗子
				if(mariobg.isWin()) {
					jump = 0;
				}
			}
			
			public void fall() {
				//下落 有两种可能（跳跃或者从砖块落下）不用判断跳跃
				if(status.indexOf("left") != -1) {
					status = "jump-left";
				}else {
					status = "jump-right";
				}
				jump = 10;
			}

				
	
	public void run() {
		
	  while(true) {
		//判断是否在障碍物上
			boolean on = false;
		//判断是否可以向右或向左
			boolean right = true;
			boolean left = true;
			
//			System.out.println("Finish  "+mariobg.finish);
//			System.out.println("Win  "+mariobg.win);
//			System.out.println("y  "+this.y);
//			System.out.println("x  "+this.x);
//			System.out.println("status =  "+status);
			
		//游戏结束条件
			if(mariobg.isFlag() && this.x >= 500) {
				
				this.mariobg.setWin(true);
				
				if(mariobg.isFinish() ) {
					
					this.status = "move-right";
					
					if(this.x < 690) {
//						move_right();
						this.x += 5;
						this.y = 395;
//						try {
//							Thread.sleep(50);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}else {
						this.ok = true;
					}
					
				}else {
					if(this.y < 395) {
						speed = 0;
						this.y += 5;
						this.status = "jump-right";
					}
					
					if(this.y > 395) {
						this.status = "stop-right";
						this.y = 395;
					}
				}
				
			}else {
	
				//遍历所有障碍
				for(int i = 0;i<mariobg.getZhangailist().size();i++) {
					zhangai ob = mariobg.getZhangailist().get(i);
					//判断是否在障碍物上
					if(ob.getY() == this.y + 25 && ob.getX()>this.x - 30 && ob.getX()<this.x + 25 ) {
						
						on = true;
					}
				//判断是否碰到障碍物
					//是否顶到了障碍物
					if(ob.getY() >= this.y - 30 && ob.getY()<=this.y - 20 && ob.getX()>this.x - 30 && ob.getX()<this.x + 25) {
						
						if(ob.getType() == 0) {
							 mariobg.getZhangailist().remove(ob);
							 score +=1 ;
						}
						up = 0;
					}
					//右面障碍物判断
					if(ob.getX() == this.x + 25 && ob.getY() >this.y - 30 && ob.getY()<this.y + 25) {
						
						right = false;
						
					}
					//左面面障碍物判断
					if(ob.getX() == this.x - 30 && ob.getY() >this.y - 30 && ob.getY()<this.y + 25) {
						
						left = false;
						
					}
					
				}
				//判断是否在障碍物上
				if(on && up == 0) {
					//判断马里奥朝向左还是右
					if(status.indexOf("left") != -1) {
						
						if(speed != 0) {
							status = "move-left";
						}else {
							status = "stop-left";
						}
						
					}else {
						
							if(speed != 0) {
							status = "move-right";
						}else {
							status = "stop-right";
						}
						
					}
					
				}else {
					if(up !=0) {
						up--;
					}else {
						fall();
					}
					y += jump;
				}
			}
				
				//判断马里奥是否可以继续行动
				if((left && speed < 0) || (right && speed > 0)) {
					x += speed;
					//判断是否到最左边
					if(x<0) {
						x = 0;
					}
					if(x > 760 && mariobg.bw ==3) {
						
						x =760;
					}
				}
				//判断马里奥是否碰到敌人，是否敌人死亡
				for(int i = 0 ;i < mariobg.getEnemylist().size();i++) {
					
					Enemy enemy = mariobg.getEnemylist().get(i);
					//是否踩到了敌人
					if(enemy.getY()== this.y +20 && (enemy.getX() -25 <this.x && enemy.getX() +35 >= this.x)) {
						//判断是否是蘑菇敌人
						if(enemy.getType()==1) {
							enemy.death();
							up = 3;
							jump = -10;
							score +=2 ;
						}else if(enemy.getType()==2) {
							//马里奥死亡
							mariodeath();
						}
					}
					//是否碰到敌人
					if((enemy.getX() + 35 > this.x && enemy.getX() -25 <this.x) && (enemy.getY() +35 >this.y && enemy.getY() -20 <this.y) ) {
						//马里奥死亡
						mariodeath();
					}
				}
//				System.out.println("ok  "+ok);
//				System.out.println("Finish  "+mariobg.finish);
//				System.out.println("win  "+mariobg.win);
//				System.out.println("status =  "+status);
				if(status.contains("move")) {
					index = index == 0 ? 1:0;
				}
				//是否向左移动
				if("move-left".equals(status)) {
					mario = Huancun.run_L.get(index);
				}
//				System.out.println(" 向右走：   "+status);
				//是否向右移动
				if("move-right".equals(status)) {
					mario = Huancun.run_R.get(index);
					
				}
				//是否向左停止
				if("stop-left".equals(status)) {
					mario = Huancun.stand_L;
				}
				//是否向右停止
				if("stop-right".equals(status)) {
					mario = Huancun.stand_R;
				}
				//是否向左跳越
				if("jump-left".equals(status)) {
					mario = Huancun.jump_L;
				}
				//是否向右跳跃
				if("jump-right".equals(status)) {
					mario = Huancun.jump_R;
				}
				
				//延时50毫秒
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
		
	}
	
	
	//set get 方法
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BufferedImage getmario() {
		return mario;
	}
	public void setmario(BufferedImage mario) {
		mario = mario;
	}
	public void setmariobg(Background mariobg) {
		this.mariobg = mariobg;
	}
	
	public Boolean getOk() {
		return ok;
	}
	public boolean isMariodeath() {
		return mariodeath;
	}
	public int getScore() {
		return score;
	}

}
