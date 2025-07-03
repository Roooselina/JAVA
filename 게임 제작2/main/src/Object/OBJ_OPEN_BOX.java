package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_OPEN_BOX extends SuperObjects {
	public OBJ_OPEN_BOX() {

		name = "열린 상자";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Objects/열린 상자.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		collision = true;
	}
}
