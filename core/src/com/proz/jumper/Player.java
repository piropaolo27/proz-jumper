package com.proz.jumper;

import com.badlogic.gdx.Gdx;

/**
 * Created by volterra on 16.04.17.
 */
public class Player extends GameObject {
    private boolean isLeft;
    private boolean isRight;
    private boolean isAirborne;
    private float airTime;

    public Player(float x, float y, int id, GameWorld world){
        super(x, y, id, world);
        isAirborne = true;
        airTime = 0;
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
        if (isAirborne)
        {
            airTime += Gdx.graphics.getDeltaTime();
            y -= 10 * airTime * airTime;
        }

        if(y < 0)
        {
            y = 0;
            isAirborne = false;
            airTime = 0;
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

    public boolean getAirborne(){
        return isAirborne;
    }
}
