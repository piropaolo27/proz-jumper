package com.proz.jumper;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by volterra on 23.04.17.
 */
public class GameCamera extends OrthographicCamera {
    Player player;

    public GameCamera(Player player){
        this.player = player;
    }

    public void move(){
        if(player.getY() - position.y > -50) translate(0, 3f);
    }
}
