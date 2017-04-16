package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by volterra on 15.04.17.
 */
public class TextureManager {
    public static Texture playerImage;
    public static Sprite playerSprite;

    public static void load(){
        playerImage = new Texture(Gdx.files.internal("p1_stand.png"));
        playerSprite = new Sprite(playerImage);
    }
}
