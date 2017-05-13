package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import static java.lang.Math.*;

/**
 * Created by volterra on 16.04.17.
 */
public class Player extends GameObject
{
    private boolean isLeft;
    private boolean isRight;
    private boolean isAirborne;
    private boolean isJump;

    private boolean isLeftFaced;
    private boolean isAlive;

    private float rightTime;
    private float leftTime;
    private float airTime;
    private float jumpTime;

    private float lifeTime;

    public Player(float x, float y, int id, GameWorld world)
    {
        super(x, y, id, world);
        isAirborne = true;

        airTime = 0;
        jumpTime = 0;
        rightTime = 0;
        leftTime = 0;
        lifeTime = 0;

        isLeftFaced = false;
        isAlive = true;
    }

    public void updateMotion()
    {
        float time = min(lifeTime, 40);
        if (isLeft)
        {
            leftTime += Gdx.graphics.getDeltaTime();
            x -= (400 + 10 * time) * Gdx.graphics.getDeltaTime();
        }
        if (isRight)
        {
            rightTime += Gdx.graphics.getDeltaTime();
            x += (400 + 10 * time) * Gdx.graphics.getDeltaTime();
        }
        if (isAirborne)
        {
            airTime += Gdx.graphics.getDeltaTime();
            y -= (1000 + 50 * time) * airTime * Gdx.graphics.getDeltaTime();
        }
        if (isJump)
        {
            jumpTime += Gdx.graphics.getDeltaTime();
            if (((700 + 15 * time) - ((1000 + 50 * time)  * jumpTime)) > 0)
                y += ((700 + 15 * time) - ((1000 + 50 * time)  * jumpTime)) * Gdx.graphics.getDeltaTime();
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

        if (y > world.getScore())   world.setScore((int)y);
        lifeTime += Gdx.graphics.getDeltaTime();
    }

    public void setLeftMove(boolean t)
    {
        if(isRight && t) isRight = false;
        isLeft = t;
        if(isLeft){
            leftTime = 0;
            isLeftFaced = true;
        }
    }

    public void setRightMove(boolean t)
    {
        if(isLeft && t) isLeft = false;
        isRight = t;
        if(isRight){
            rightTime = 0;
            isLeftFaced = false;
        }
    }

    public boolean getRightMove() {
        return isRight;
    }

    public boolean getLeftMove(){
        return isLeft;
    }

    public float getRightTime(){
        return rightTime;
    }

    public float getLeftTime() {
        return  leftTime;
    }

    public float getAirTime() { return airTime; }

    public float getJumpTime() {return jumpTime;}

    public boolean getLeftFaced() {
        return isLeftFaced;
    }

    public void setJump(boolean t)
    {
        if(!isAirborne) isJump = t;
    }

    public boolean getAirborne()
    {
        return isAirborne;
    }

    public void setAirborne(boolean t) {
        isAirborne = t;
        airTime = 0;
    }

    public float getLifeTime(){
        return lifeTime;
    }

    public boolean getJump(){
        return isJump;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean t){
        this.isAlive = t;
    }
}
