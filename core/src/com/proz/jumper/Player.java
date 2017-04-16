package com.proz.jumper;

import com.badlogic.gdx.Gdx;

/**
 * Created by volterra on 16.04.17.
 */
public class Player extends GameObject
{
    private boolean isLeft;
    private boolean isRight;
    private boolean isAirborne;
    private boolean isJump;
    private float airTime;
    private float jumpTime;

    public Player(float x, float y, int id, GameWorld world)
    {
        super(x, y, id, world);
        isAirborne = true;
        airTime = 0;
        jumpTime = 0;
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
            y -= 400 * airTime * airTime * Gdx.graphics.getDeltaTime();
        }
        if (isJump)
        {
            jumpTime += Gdx.graphics.getDeltaTime();
            if ((400 - (400 * jumpTime * jumpTime)) > 0)
                y += (400 - (400 * jumpTime * jumpTime)) * Gdx.graphics.getDeltaTime();
            else
            {
                isJump = false;
                jumpTime = 0;
                isAirborne = true;
                airTime = 0;
            }
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

    public void setJump(boolean t)
    {
        if(!isAirborne) isJump = t;
    }

    public boolean getAirborne()
    {
        return isAirborne;
    }

    public void setAirborne(boolean t) {isAirborne = t;}

    public boolean getJump(){
        return isJump;
    }
}
