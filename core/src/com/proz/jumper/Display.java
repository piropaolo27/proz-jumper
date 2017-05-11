package com.proz.jumper;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.LinkedList;

import static com.proz.jumper.TextureManager.*;

/**
 * This class is for putting things on the screen.
 * Created by volterra on 15.04.17.
 */
public class Display {
    /**
     * Method that is used for displaying the player on the GameScreen.
     * It considers many cases regarding state in which the Player is currently in.
     * @param player    Player instance that is to be used
     * @param batch     SpriteBatch defined for the whole programme
     */
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

    /**
     * Displays all the Platform objects that are currently on the screen.
     * @param platforms Platform list used for this case
     * @param batch     SpriteBatch defined for the whole programme
     */
    public static void displayPlatforms(LinkedList<Platform> platforms, SpriteBatch batch){
        for (Platform item : platforms) {
            batch.draw(platformRegion, item.getX(), item.getY());
        }
    }

    /**
     * This method is used throughout the whole game to display the jungle-themed background.
     * It uses the camera position to put it on the screen in a correct manner.
     * @param camera    Camera that is going to give us information about the current state of the screen.
     * @param batch     SpriteBatch defined for the whole programme
     */
    public static void displayBackground(OrthographicCamera camera, SpriteBatch batch){
        batch.draw(backgroundRegion, camera.position.x - camera.viewportWidth/2,
                camera.position.y - camera.viewportHeight/2);
    }
}
