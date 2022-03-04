package 马里奥;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Huancun {
	
//图片加载
	//两张背景图
	public static BufferedImage bg1;
	public static BufferedImage bg2;
	//向左跳
	public static BufferedImage jump_L;
	//向右跳
	public static BufferedImage jump_R;
	//人物朝向左
	public static BufferedImage stand_L;
	//人物朝向右
	public static BufferedImage stand_R;
	//城堡
	public static BufferedImage tower;
	//旗杆
	public static BufferedImage gan;
	//开始界面
	public static BufferedImage start;
//有多张图片组合的 用List的形式存储
	//障碍物 
	public static ArrayList<BufferedImage> zhangai = new ArrayList<>();
	//人物向左 右跑
	public static ArrayList<BufferedImage> run_L = new ArrayList<>();
	public static ArrayList<BufferedImage> run_R = new ArrayList<>();
	//蘑菇
	public static ArrayList<BufferedImage> mushroom = new ArrayList<>();
	//食人花
	public static ArrayList<BufferedImage> monster = new ArrayList<>();

//给上述变量赋值
	public static void init() {
		//单张图片的加载
		try {
			
			bg1 = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/" + "bg.png")); 
			bg2 = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/" + "bg2.png"));
			jump_L = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/" + "jump1_L.png"));
			jump_R = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "jump1_R.png"));
			stand_L = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "stand_L.png"));
			stand_R = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "stand_R.png"));
			tower = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "tower.png"));
			gan = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "gan.png"));
			
        } catch (IOException e) {
            e.printStackTrace();
        }
		//多张图片的加载 用for循环的方式加入
		//向左跑
		for(int i = 1;i<=2;i++) {
			try {
				run_L.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "run"+i+"_L.png")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		//向右跑
		for(int i = 1;i<=2;i++) {
			try {
				run_R.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "run"+i+"_R.png")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		//障碍物
		try {
			//砖块
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"brick.png")));
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"brick2.png")));
			//上下面
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"soil_base.png")));
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"soil_up.png")));
	     } catch (IOException e) {
	            e.printStackTrace();
	       }
		//管道也属于障碍物 有四种
		for(int i = 1;i<=4;i++) {
			try {
				zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "pipe"+i+".png")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		//加载不可破坏的砖块和旗子
		try {
			//不可破坏的砖块
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"brick2.png")));
			//旗子
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"flag.png")));
	     } catch (IOException e) {
	            e.printStackTrace();
	       }
		//加载蘑菇怪
		for(int i = 1;i<=3;i++) {
			try {
				mushroom.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "fungus"+i+".png")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		for(int i = 1;i<=2;i++) {
			try {
				monster.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "flower1."+i+".png")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}

	}
}
 