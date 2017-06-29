package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by volterra on 19.05.17.
 */

public class SoundManager {
    public static Sound jumpSound;
    public static Sound fallSound;

    public static void load(){
        jumpSound = Gdx.audio.newSound(Gdx.files.internal("sfx_movement_jump14.wav"));
        fallSound = Gdx.audio.newSound(Gdx.files.internal("sfx_movement_jump17_landing.wav"));
    }

    public static void playJumpSound(){
        jumpSound.play(1.0f);
    }

    public static void playFallSound(){
        fallSound.play(1.0f);
    }

    public static void dispose(){
        jumpSound.dispose();
        fallSound.dispose();
    }
}
