package com.proz.jumper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.proz.jumper.TextureManager.platformRegion;
import static com.proz.jumper.TextureManager.playerJumpRegion;
import static com.proz.jumper.TextureManager.playerStandRegion;

/**
 * Created by volterra on 15.04.17.
 */
public class Display {
    public static void displayPlayer(Player player, SpriteBatch batch){
        if (player.getAirborne() || player.getJump()){
            batch.draw(playerJumpRegion, player.getX(), player.getY());
        }
        else {
            batch.draw(playerStandRegion, player.getX(), player.getY());
        }
    }

    public static void displayPlatform(Platform platform, SpriteBatch batch){
        batch.draw(platformRegion, platform.getX(), platform.getY());
    }
}
