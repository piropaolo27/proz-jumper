package com.proz.jumper;

import com.badlogic.gdx.graphics.OrthographicCamera;
import static java.lang.Math.*;

/**
 * I have created this custom Camera class purely for the purpose of
 * implementing movement method.
 * Created by volterra on 23.04.17.
 */
public class GameCamera extends OrthographicCamera {
    /**
     * Player instance is needed for the camera to know how to position itself.
     */
    Player player;

    /**
     * Class constructor which gets a player
     * @param player    Reference for a Player class object
     */
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
