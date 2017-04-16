package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by volterra on 15.04.17.
 */
public class TextureManager {
    public static Texture playerStandImage;
    public static Sprite playerStandSprite;

    public static Texture playerJumpImage;
    public static Sprite playerJumpSprite;

    public static Texture platformImage;
    public static Sprite platformSprite;

    public static void load(){
        playerStandImage = new Texture(Gdx.files.internal("p1_stand.png"));
        playerStandSprite = new Sprite(playerStandImage);

        playerJumpImage = new Texture(Gdx.files.internal("p1_jump.png"));
        playerJumpSprite = new Sprite(playerJumpImage);

        platformImage = new Texture(Gdx.files.internal("platform.png"));
        platformSprite = new Sprite(platformImage);
    }
}
