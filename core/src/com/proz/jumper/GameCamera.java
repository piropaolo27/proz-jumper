package com.proz.jumper;

import com.badlogic.gdx.graphics.OrthographicCamera;
import static java.lang.Math.*;

/**
 * I have created this custom Camera class purely for the purpose of
 * implementing movement method.
 * Created by volterra on 23.04.17.
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
        if(player.getY() > 500) translate(0, 2 + min(player.getLifeTime(), 40) * 0.1f);
    }
}
