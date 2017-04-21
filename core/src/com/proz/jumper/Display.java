package com.proz.jumper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.proz.jumper.TextureManager.*;

/**
 * Created by volterra on 15.04.17.
 */
public class Display {
    public static void displayPlayer(Player player, SpriteBatch batch){
        if (player.getAirborne() || player.getJump()){
            if(player.getLeftFaced())  batch.draw(playerJumpRegionL, player.getX(), player.getY());
            else    batch.draw(playerJumpRegion, player.getX(), player.getY());
        }
        else if(player.getRightMove()){
            batch.draw((TextureRegion)animationRight.getKeyFrame(player.getRightTime(), true), player.getX(), player.getY());
        }
        else if(player.getLeftMove()){
            batch.draw((TextureRegion)animationLeft.getKeyFrame(player.getLeftTime(), true), player.getX(), player.getY());
        }
        else {
            if(player.getLeftFaced())   batch.draw(playerStandRegionL, player.getX(), player.getY());
            else    batch.draw(playerStandRegion, player.getX(), player.getY());
        }
    }

    public static void displayPlatform(Platform platform, SpriteBatch batch){
        batch.draw(platformRegion, platform.getX(), platform.getY());
    }
}
