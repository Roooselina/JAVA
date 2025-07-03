package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_CLOSE_BOX extends SuperObjects {
	public OBJ_CLOSE_BOX() {

		name = "닫힌 상자";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Objects/닫힌 상자.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		collision = true;
	}
}
