package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Entity.CommonEntity;

public class MonsterBattle extends CommonEntity {
    GamePanel gp;
    int playerFace = 0;
    public CommonEntity entity;

    public MonsterBattle(GamePanel gp) {
        super(gp);
        this.gp = gp;
    }

    // 전투를 처리하는 메서드
    public void Battle(CommonEntity entity, Graphics2D g2) {
        int result;
        this.entity = entity; // 전투 상대 엔티티 설정
        BattlePlayerCondition(entity, g2); // 플레이어 상태 업데이트

        // 전투 결과 판정
        if (gp.player.life != 0 && entity.life != 0) {
            gp.result = 3; // 전투가 계속 진행 중일 때
        }
        if (gp.player.life == 0) {
            gp.result = 0; // 플레이어가 패배했을 때
        }
        if (entity.life == 0) {
            gp.result = 1; // 몬스터가 패배했을 때
        }
    }

    // 생명력을 조정하는 메서드
    public void adjustLife(int i) {
        if (i == 0) {
            gp.player.life -= entity.attack; // 플레이어의 생명력을 감소시킴
            if (gp.player.life <= 0) {
                gp.result = 1; // 플레이어가 패배했을 때 결과 설정
            }
        } else {
            entity.life -= gp.player.attack; // 몬스터의 생명력을 감소시킴
            if (entity.life <= 0) {
                gp.result = 0; // 몬스터가 패배했을 때 결과 설정
                gp.killedMonster++;
                gp.gameState = gp.playState; // 게임 상태를 플레이 상태로 전환
                gp.adjustScreenSize();

                // 모든 몬스터를 처치했을 때
                if (gp.killedMonster == gp.monster.size()) {
                    gp.gameState = gp.endState; // 게임 상태를 엔딩 상태로 전환
                    gp.ui.scriptNum = 0;
                }
                gp.monster.remove(entity); // 몬스터 제거
            }
        }
    }

    // 플레이어의 상태를 업데이트하고 화면에 그리는 메서드
    public void BattlePlayerCondition(CommonEntity entity, Graphics2D g2) {
        if (gp.player.HP >= gp.player.maxLife * 0.8)
            playerFace = 0; // 플레이어의 생명력이 80% 이상일 때
        else if (gp.player.HP >= gp.player.maxLife * 0.5)
            playerFace = 2; // 플레이어의 생명력이 50% 이상일 때
        else if (gp.player.HP >= gp.player.maxLife * 0.2)
            playerFace = 3; // 플레이어의 생명력이 20% 이상일 때
        gp.playerImages.drawPlayerImg(40, 150, playerFace, g2); // 플레이어 이미지 그리기

        int monsterSize = 800 / 2 - gp.getOrigianlCharacterSize() * 3;

        BufferedImage image = null;
        // 객체를 화면에 그리기 위해 화면 좌표를 계산합니다.
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // 방향에 따라 이미지 선택
        BufferedImage image1 = null;

        switch (direction) {
        case ("nothing") -> {
            // 정지 상태일 때 이미지 선택
            if (spriteNum == 1)
                image1 = st1;
            else if (spriteNum == 2)
                image1 = st2;
            else if (spriteNum == 3)
                image1 = st3;
            else if (spriteNum == 4)
                image1 = st4;
            break;
        }
        case ("up") -> {
            // 위쪽 이동 상태일 때 이미지 선택
            if (spriteNum == 1)
                image1 = right1;
            else if (spriteNum == 2)
                image1 = right2;
            else if (spriteNum == 3)
                image1 = right3;
            else if (spriteNum == 4)
                image1 = right4;
            break;
        }
        case ("down") -> {
            // 아래쪽 이동 상태일 때 이미지 선택
            if (spriteNum == 1)
                image1 = right1;
            else if (spriteNum == 2)
                image1 = right2;
            else if (spriteNum == 3)
                image1 = right3;
            else if (spriteNum == 4)
                image1 = right4;
            break;
        }
        case ("right") -> {
            // 오른쪽 이동 상태일 때 이미지 선택
            if (spriteNum == 1)
                image1 = right1;
            else if (spriteNum == 2)
                image1 = right2;
            else if (spriteNum == 3)
                image1 = right3;
            else if (spriteNum == 4)
                image1 = right4;
            break;
        }
        case ("left") -> {
            // 왼쪽 이동 상태일 때 이미지 선택
            if (spriteNum == 1)
                image1 = left1;
            else if (spriteNum == 2)
                image1 = left2;
            else if (spriteNum == 3)
                image1 = left3;
            else if (spriteNum == 4)
                image1 = left4;
            break;
        }
        }

        // 선택된 이미지 그리기
        g2.drawImage(image1, screenX, screenY, gp.getOrigianlCharacterSize(), gp.getOrigianlCharacterSize(), null);
    }
}

