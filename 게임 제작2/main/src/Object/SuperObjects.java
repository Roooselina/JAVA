package Object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObjects {
    // 객체 이미지
    public BufferedImage image, image2, image3;
    // 객체 이름
    public String name;
    // 충돌 여부
    public boolean collision = false;
    // 객체의 위치 (월드 좌표)
    public int worldX, worldY;
    
    // 객체의 충돌 영역
    public Rectangle solidArea = new Rectangle(0,0,50,50);
    
    // 충돌 영역의 기본 위치
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    
    // 객체를 화면에 그리는 메서드
    public void draw(Graphics2D g2, GamePanel gp) {
        // 객체를 화면에 그리기 위해 화면 좌표를 계산합니다.
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // 이미지 그리기
        g2.drawImage(image, screenX, screenY, gp.getOrigianlCharacterSize(),
                gp.getOrigianlCharacterSize(), null);
    }
}
