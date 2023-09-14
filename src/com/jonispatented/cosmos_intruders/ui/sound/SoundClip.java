package com.jonispatented.cosmos_intruders.ui.sound;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public enum SoundClip {

    EXPLODE("assets/explosion.wav"),
    POINT("assets/ding.wav"),
    SHOOT("assets/shoot.wav"),

    SILENT("assets/silence.wav");

    private final String audioFileName;
    private File audioFile;

    SoundClip(String audioFileName) {
        this.audioFileName = audioFileName;
    }

    public static void initialize() {
        for (SoundClip soundClip : values()) {
            try {
                soundClip.audioFile = new File(soundClip.audioFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        SILENT.play(); // The first sound that plays causes lag, so I play a short silent clip immediately on start
    }

    public void play() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                    new BufferedInputStream(new FileInputStream(audioFile))
            );
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
