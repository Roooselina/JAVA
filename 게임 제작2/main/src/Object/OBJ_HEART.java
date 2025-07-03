package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_HEART extends SuperObjects{
	GamePanel gp;
	
	public OBJ_HEART(GamePanel gp) {
		this.gp = gp;

		name = "하트";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/hearts/풀하트.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/hearts/하프하트.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/hearts/빈하트.png"));
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		collision = true;
	}
}
