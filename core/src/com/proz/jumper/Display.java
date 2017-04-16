package com.proz.jumper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.proz.jumper.TextureManager.playerSprite;

/**
 * Created by volterra on 15.04.17.
 */
public class Display {
    public static void displayPlayer(Player player, SpriteBatch batch){
        playerSprite.setPosition(player.getX(), player.getY());
        playerSprite.draw(batch);
    }
}
