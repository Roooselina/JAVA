package Tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gp;
	public int[][] mapTileNum; // 맵 타일 번호를 저장하는 2차원 배열
	public Tile[] tile; // 타일 종류를 저장하는 배열

	// 맵 파일 경로 설정
	public String Cave1 = "/gameBackground/동굴1.txt";
	public String Cave2 = "/gameBackground/동굴2.txt";
	public String Cave3 = "/gameBackground/동굴3.txt";

	// 생성자: 타일 매니저 초기화
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[30]; // 타일 종류 배열 초기화
		getTileImage(); // 타일 이미지 로드
		mapTileNum = loadMap(Cave1); // 초기 맵 로드
	}

	// 타일 변경 및 다시 그리기
	public void ChangeTile(String path, Graphics2D g2) {
		mapTileNum = loadMap(path); // 새로운 맵 로드
		draw(g2); // 맵 다시 그리기
	}

	// 맵을 로드하여 2차원 배열에 저장하는 메서드
	int[][] loadMap(String path) {
		int[][] mapTileNum = new int[gp.getMaxWorldCol()][gp.getMaxWorldRow()]; // 배열 크기 설정
		try {
			InputStream is = getClass().getResourceAsStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

			// 맵 파일에서 데이터를 읽어와 2차원 배열에 저장
			while (row < gp.getMaxWorldRow()) {
				String line = br.readLine();
				String[] numbers = line.split("\t");
				for (col = 0; col < gp.getMaxWorldCol(); col++) {
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
				}
				row++;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapTileNum;
	}

	// 타일 이미지를 로드하는 메서드
	public void getTileImage() {
		try {
			// 캐릭터가 걸을 수 있는 요소
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/돌바닥.png"));

			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/돌바닥2.png"));

			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/돌바닥3.png"));

			// 캐릭터가 걸을 수 없는 요소
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/버튼.png"));
			tile[3].collision = true;

			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/돌벽_상.png"));
			tile[4].collision = true;

			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/돌벽_중.png"));
			tile[5].collision = true;

			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/돌벽_하.png"));
			tile[6].collision = true;

			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/돌벽_꼭대기.png"));
			tile[7].collision = true;

			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/돌벽_꼭대기.png"));
			tile[8].collision = true;

			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/얕은 물.png"));
			tile[9].collision = true;

			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/깊은 물.png"));
			tile[10].collision = true;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 맵을 그리는 메서드
	/**
	 * 초기 변수 설정:
	 * 
	 * int worldCol = 0; int worldRow = 0; -> worldCol과 worldRow는 현재 그릴 타일의 월드 좌표를
	 * 나타내기위해 사용
	 * 
	 * 이중 while 루프: -> 첫 번째 while 루프는 맵의 모든 행 (worldRow)을 순회 -> 두 번째 while 루프는 각 행의
	 * 모든 열(worldCol)을 순회
	 * 
	 * 타일 번호 읽기:
	 * 
	 * int tileNum = mapTileNum[worldCol][worldRow]; -> 현재 타일의 번호를 mapTileNum 배열에서
	 * 읽기; 이 번호는 타일 이미지 배열 (tile)의 인덱스로 사용
	 * 
	 * 월드 좌표 계산: int worldX = worldCol * gp.getOrigianlCharacterSize(); int worldY =
	 * worldRow gp.getOrigianlCharacterSize(); -> 현재 타일의 월드 좌표 (worldX, worldY)를
	 * 계산합니다. ->타일의 크기(gp.getOrigianlCharacterSize())에 worldCol과 worldRow를 곱해서 계산
	 * 
	 * 화면 좌표 계산:
	 * 
	 * int screenX = worldX - gp.player.worldX + gp.player.screenX; int screenY
	 * =worldY - gp.player.worldY + gp.player.screenY; -> 월드 좌표를 화면 좌표로 변환 플레이어의
	 * 월드좌표 (gp.player.worldX, gp.player.worldY)와 화면 좌표 (gp.player.screenX,
	 * gp.player.screenY)를 사용 화면 중심이 플레이어의 위치에 맞춰지도록 합니다.
	 * 
	 * 타일 이미지 그리기: g2.drawImage(tile[tileNum].image, screenX, screenY,
	 * gp.getOrigianlCharacterSize(), gp.getOrigianlCharacterSize(), null); -> 타일
	 * 이미지를 계산된 화면 좌표 (screenX, screenY)에 그림 타일 이미지는 tile[tileNum].image에서 가져옴
	 * 
	 * 루프 변수 증가: worldCol++; -> 각 열을 순회하기 위해 worldCol을 증가 -> 내부 while 루프가 끝나면
	 * worldRow++를 통해 다음행으로 넘어감 -> worldCol은 0으로 재설정
	 * 
	 */
	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;

		// 맵의 각 타일을 화면에 그리기
		while (worldRow < gp.getMaxWorldRow()) {
			while (worldCol < gp.getMaxWorldCol()) {
				if (worldCol < mapTileNum.length && worldRow < mapTileNum[0].length) {
					int tileNum = mapTileNum[worldCol][worldRow]; // 현재 타일의 번호
					int worldX = worldCol * gp.getOrigianlCharacterSize(); // 월드 좌표 X
					int worldY = worldRow * gp.getOrigianlCharacterSize(); // 월드 좌표 Y
					int screenX = worldX - gp.player.worldX + gp.player.screenX; // 화면 좌표 X
					int screenY = worldY - gp.player.worldY + gp.player.screenY; // 화면 좌표 Y

					// 타일 이미지를 화면에 그림
					g2.drawImage(tile[tileNum].image, screenX, screenY, gp.getOrigianlCharacterSize(),
							gp.getOrigianlCharacterSize(), null);
				}
				worldCol++;
			}
			worldCol = 0;
			worldRow++;
		}
	}

}
