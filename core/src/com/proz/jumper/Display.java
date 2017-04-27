package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.LinkedList;

import static com.proz.jumper.TextureManager.*;

/**
 * Created by volterra on 15.04.17.
 */
public class Display {
    public static void displayPlayer(Player player, SpriteBatch batch){
        if (player.getJump()){
            if(player.getLeftFaced())  batch.draw(playerJumpRegionL, player.getX(), player.getY());
            else    batch.draw(playerJumpRegion, player.getX(), player.getY());
        }
        else if(player.getAirborne()){
            if(player.getLeftFaced())  batch.draw(playerFallRegionL, player.getX(), player.getY());
            else    batch.draw(playerFallRegion, player.getX(), player.getY());
        }
        else if(player.getRightMove()){
            batch.draw((TextureRegion)animationRight.getKeyFrame(player.getRightTime(), true), player.getX(), player.getY());
        }
        else if(player.getLeftMove()){
            batch.draw((TextureRegion)animationLeft.getKeyFrame(player.getLeftTime(), true), player.getX(), player.getY());
        }
        else {
            if(player.getLeftFaced())   batch.draw((TextureRegion)animationStandL.getKeyFrame(player.getLifeTime(), true), player.getX(), player.getY());
            else    batch.draw((TextureRegion)animationStand.getKeyFrame(player.getLifeTime(), true), player.getX(), player.getY());
        }
    }

    public static void displayPlatforms(LinkedList<Platform> platforms, SpriteBatch batch){
        for (Platform item : platforms) {
            batch.draw(platformRegion, item.getX(), item.getY());
        }
    }

    public static void displayBackground(GameCamera camera, SpriteBatch batch){
        batch.draw(backgroundRegion, camera.position.x - camera.viewportWidth/2,
                camera.position.y - camera.viewportHeight/2);
    }
}
