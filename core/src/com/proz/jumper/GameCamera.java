package com.proz.jumper;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by volterra on 23.04.17.
 * I have created this custom Camera class purely for the purpose of
 * implementing movement method.
 */
public class GameCamera extends OrthographicCamera {
    Player player;

    public GameCamera(Player player){
        this.player = player;
    }

    /**
     * That method is used for the purpose of adjusting difficulty level.
     * Ie. the further the player progresses through the game the faster
     * the camera moves.
     */
    public void move(){
        if(player.getY() > 500) translate(0, 3f);
    }
}
