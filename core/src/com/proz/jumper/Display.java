package com.proz.jumper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.proz.jumper.TextureManager.platformSprite;
import static com.proz.jumper.TextureManager.playerJumpSprite;
import static com.proz.jumper.TextureManager.playerStandSprite;


/**
 * Created by volterra on 15.04.17.
 */
public class Display {
    public static void displayPlayer(Player player, SpriteBatch batch){
        if (player.getAirborne() || player.getJump()){
            playerJumpSprite.setPosition(player.getX(), player.getY());
            playerJumpSprite.draw(batch);
        }
        else {
            playerStandSprite.setPosition(player.getX(), player.getY());
            playerStandSprite.draw(batch);
        }
    }

    public static void displayPlatform(Platform platform, SpriteBatch batch){
        platformSprite.setPosition(platform.getX(), platform.getY());
        platformSprite.draw(batch);
    }
}
