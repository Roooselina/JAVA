package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_STAIR_BOTTOM extends SuperObjects{
	public OBJ_STAIR_BOTTOM() {

		name = "계단 하";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Objects/계단_하.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
