package 马里奥;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Background {
	//当前背景图
	public BufferedImage bgimage;

	//记录第几关 前两关用bg 最后一关用bg2
	public int bw;
	//判断是否要变换背景图片
	public boolean flag;
	//存储不同障碍物的图片
	private ArrayList <zhangai> zhangailist = new ArrayList<>();
	//存储所有的敌人
	private ArrayList <Enemy> enemylist = new ArrayList<>();
	//显示旗杆
	private BufferedImage gan;
	//显示塔
	private BufferedImage tower;
	//判断马里奥是否到达旗杆
	public boolean win = false;
	//胜利动画
	public boolean finish = false;
	
	
	//空参构造函数
	public Background() {
		
	}
	
	public Background(int bw, boolean flag) {
		
		this.bw = bw ;
		this.flag = flag;
		
		//给不同关卡不同的图片
		if(flag) {
			bgimage = Huancun.bg2;
		}else {
			bgimage = Huancun.bg1;
		}
		
//设计第一关有障碍物的图片
		
		if(bw == 1) {
		//绘制地面
		//页面宽度800 砖块长度30 需要循环27次
			//上底面
			for (int i =0;i<27;i++) {
				zhangailist.add(new zhangai(i*30,420,3,this));
			}
			//下底面 有多层
			for(int j = 0;j<=120;j+=30) {
				for(int i =0;i<27;i++) {
					
					zhangailist.add(new zhangai(i*30,570-j,2,this));
				}
			}
			
			//绘制砖块
			for(int i =120;i<=150;i+=30) {
				zhangailist.add(new zhangai(i,300,1,this));
			}
			
			for(int i =300;i<=570;i+=30) {
				if(i == 360 || i== 390 ||  i== 480 || i== 510 || i== 540 ) {
					
					zhangailist.add(new zhangai(i,300,1,this));
				}else {
					zhangailist.add(new zhangai(i,300,0,this));
				}
			}
			
			for(int i =420;i<=450;i+=30) {
				zhangailist.add(new zhangai(i,240,1,this));
			}
			
			//绘制管道
			for(int i = 360;i<=600;i+=25) {
				if(i == 360) {
					zhangailist.add(new zhangai(620,i,4,this));
					zhangailist.add(new zhangai(645,i,5,this));
				}else {
					zhangailist.add(new zhangai(620,i,6,this));
					zhangailist.add(new zhangai(645,i,7,this));
				}
			}
			
			enemylist.add(new Enemy(580,385,true,1,this));
			enemylist.add(new Enemy(635,420,true,2,this,328,418));
		}
//设计第二关有障碍物的图片
		if(bw == 2) {
			//绘制地面
			//页面宽度800 砖块长度30 需要循环27次
				//上底面
				for (int i =0;i<27;i++) {
					zhangailist.add(new zhangai(i*30,420,3,this));
				}
				//下底面 有多层
				for(int j = 0;j<=120;j+=30) {
					for(int i =0;i<27;i++) {
						
						zhangailist.add(new zhangai(i*30,570-j,2,this));
					}
				}
				//绘制水管 
				for(int i = 360;i<=600;i+=25) {
					if(i == 360) {
						zhangailist.add(new zhangai(60,i,4,this));
						zhangailist.add(new zhangai(85,i,5,this));
					}else {
						zhangailist.add(new zhangai(60,i,6,this));
						zhangailist.add(new zhangai(85,i,7,this));
					}
				}
				
				for(int i = 330;i<=600;i+=25) {
					if(i == 330) {
						zhangailist.add(new zhangai(620,i,4,this));
						zhangailist.add(new zhangai(645,i,5,this));
					}else {
						zhangailist.add(new zhangai(620,i,6,this));
						zhangailist.add(new zhangai(645,i,7,this));
					}
				}
				
			//绘制砖块
			   zhangailist.add(new zhangai(300,330,0,this));
			   for(int i =270;i<=330;i+=30) {
				   if(i == 270 || i== 330) {
					zhangailist.add(new zhangai(i,360,0,this));
				   }else {
					   zhangailist.add(new zhangai(i,360,1,this));
				   }
				}
			   
			   for(int i =240;i<=360;i+=30) {
				   if(i == 240 || i== 360) {
					   zhangailist.add(new zhangai(i,390,0,this));
				   }else {
					   zhangailist.add(new zhangai(i,390,1,this));
				   }
				}
			   zhangailist.add(new zhangai(240,300,0,this));
			   
			   for(int i =360;i<=540;i+=60) {
				   zhangailist.add(new zhangai(i,270,1,this));
			   }
			   
			  enemylist.add(new Enemy(200,385,true,1,this));
			  enemylist.add(new Enemy(500,385,true,1,this));
			  enemylist.add(new Enemy(75,420,true,2,this,328,418));
			  enemylist.add(new Enemy(635,420,true,2,this,298,388));
		}
 //设计第三关有障碍物的图片
			if(bw == 3) {
			//绘制地面
			//页面宽度800 砖块长度30 需要循环27次
			//上底面
			for (int i =0;i<27;i++) {
				zhangailist.add(new zhangai(i*30,420,3,this));
			}
			//下底面 有多层
			for(int j = 0;j<=120;j+=30) {
				for(int i =0;i<27;i++) {
					
					zhangailist.add(new zhangai(i*30,570-j,2,this));
				}
			}
			//绘制砖块
			int t = 290;
			for(int i=390;i>=270;i-=30) {
				for(int j = t;j<=410;j+=30) {
					
					zhangailist.add(new zhangai(j,i,1,this));
					
				}
				t+=30;
			}
			int m = 60;
			for(int i=390;i>=360;i-=30) {
				for(int j = m;j<=90;j+=30) {
					
					zhangailist.add(new zhangai(j,i,1,this));
					
				}
				m+=30;
			}
			//绘制旗杆和塔
			gan = Huancun.gan;
			tower = Huancun.tower;
			//旗子绘制到旗杆上
			zhangailist.add(new zhangai(515,240,9,this));
			enemylist.add(new Enemy(150,385,true,1,this));
		}
			
	}
	
	//get 方法
	public BufferedImage getBgimage() {
		return bgimage;
	}
	public void setBgimage(BufferedImage bgimage) {
		this.bgimage = bgimage;
	}

	public int getBw() {
		return bw;
	}

	public boolean isFlag() {
		return flag;
	}
	public ArrayList<zhangai> getZhangailist() {
		return zhangailist;
	}
	public BufferedImage getGan() {
		return gan;
	}

	public BufferedImage getTower() {
		return tower;
	}
	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	public ArrayList<Enemy> getEnemylist() {
		return enemylist;
	}


}
