package com.proz.jumper;

import com.badlogic.gdx.Gdx;

/**
 * Created by volterra on 16.04.17.
 */
public class Player extends GameObject {
    boolean isLeft;
    boolean isRight;

    public Player(float x, float y, int id, GameWorld world){
        super(x, y, id, world);
    }

    public void updateMotion()
    {
        if (isLeft)
        {
            x -= 400 * Gdx.graphics.getDeltaTime();
        }
        if (isRight)
        {
            x += 400 * Gdx.graphics.getDeltaTime();
        }
    }

    public void setLeftMove(boolean t)
    {
        if(isRight && t) isRight = false;
        isLeft = t;
    }

    public void setRightMove(boolean t)
    {
        if(isLeft && t) isLeft = false;
        isRight = t;
    }
}
