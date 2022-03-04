package ÂíÀï°Â;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class music {
	
	public music() {
		
	
	 File file = new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Music/music.wav");
	 
     try {
			Player player = new Player(new FileInputStream(file));
			player.play();
		} catch (FileNotFoundException | JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
