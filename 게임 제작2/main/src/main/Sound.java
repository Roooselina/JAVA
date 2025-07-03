package main;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("/musics/Cave Theme.wav");
        soundURL[1] = getClass().getResource("/musics/Cave Theme2.wav");
        soundURL[2] = getClass().getResource("/musics/Open the box.wav");
        soundURL[3] = getClass().getResource("/musics/Footstep.wav");
        soundURL[4] = getClass().getResource("/musics/BattleTheme.wav");
    }

    public void setFile(int i) {
        try {
            if (clip != null) {
                clip.stop();
                clip.close();
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.setFramePosition(0); // 시작 위치로 설정
            clip.start();
        }
    }

    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
}

