package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by volterra on 15.04.17.
 */
public class TextureManager {
    public static TextureRegion playerStandRegion;
    public static TextureRegion playerJumpRegion;
    public static TextureRegion platformRegion;

    public static void load(){
        playerStandRegion = new TextureRegion(new Texture(Gdx.files.internal("p1_stand.png")));
        playerJumpRegion = new TextureRegion(new Texture(Gdx.files.internal("p1_jump.png")));
        platformRegion = new TextureRegion(new Texture(Gdx.files.internal("platform.png")));
    }
}
