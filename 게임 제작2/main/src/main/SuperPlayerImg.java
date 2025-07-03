package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SuperPlayerImg {

    // 플레이어 이미지 배열 (총 4개 이미지 저장)
    BufferedImage playerImg[] = new BufferedImage[4];

    // 생성자: 플레이어 이미지를 로드함
    public SuperPlayerImg() {
        try {
            // 각 이미지 파일을 배열에 로드
            playerImg[0] = ImageIO.read(getClass().getResourceAsStream("/playerImg/일반.png")); // 일반 상태 이미지
            playerImg[1] = ImageIO.read(getClass().getResourceAsStream("/playerImg/흐음.png")); // 흐음 상태 이미지
            playerImg[2] = ImageIO.read(getClass().getResourceAsStream("/playerImg/다침.png")); // 다친 상태 이미지
            playerImg[3] = ImageIO.read(getClass().getResourceAsStream("/playerImg/많이 다침.png")); // 많이 다친 상태 이미지
        } catch (IOException e) {
            e.printStackTrace(); // 이미지 로드 중 오류가 발생하면 스택 트레이스 출력
        }
    }

    // 플레이어 이미지를 그리는 메서드
    public void drawPlayerImg(int x, int y, int i, Graphics2D g2) {
        // 지정된 좌표 (x, y)에 플레이어 이미지 배열의 i번째 이미지를 그린다
        g2.drawImage(playerImg[i], x, y, null);
    }
}
