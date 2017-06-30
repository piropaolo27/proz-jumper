package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import static java.lang.Math.*;

/**
 * Class that inherits from GameObject class. It stores information about player position,
 * movement, speed, etc.
 * Created by volterra on 16.04.17.
 */
public class Player extends GameObject
{
    /**
     * Boolean value stating if player is moving to the right.
     */
    private boolean isLeft;

    /**
     * Boolean value stating if player is moving right.
     */
    private boolean isRight;

    /**
     * Boolean value stating if player is falling.
     */
    private boolean isAirborne;
    /**
     * Boolean value stating if player is jumping.
     */
    private boolean isJump;

    /**
     * Boolean value stating if player is facing left.
     */
    private boolean isLeftFaced;

    /**
     * Boolean value stating if player is alive.
     */
    private boolean isAlive;

    /**
     * Time measured from the beginning of movement to the right.
     */
    private float rightTime;

    /**
     * Time measured from the beginning of movement to the left.
     */
    private float leftTime;

    /**
     * Time measured from the beginning of a fall.
     */
    private float airTime;

    /**
     * Time measured from the beginning of a jump.
     */
    private float jumpTime;

    /**
     * Lenght of player's life.
     */
    private float lifeTime;
    private float velocity0;
    private float gravity0;
    private float velocityModifier;
    private float gravityModifier;

    /**
     * Main constructor for the player, called from superclass.
     * @param x     horizontal position
     * @param y     vertical position
     * @param id    identifier
     * @param world reference to own world
     */
    public Player(float x, float y, int id, GameWorld world)
    {
        super(x, y, id, world);
        isAirborne = true;

        airTime = 0;
        jumpTime = 0;
        rightTime = 0;
        leftTime = 0;
        lifeTime = 0;

        velocity0 = 700;
        gravity0 = 1000;
        velocityModifier = 0;
        gravityModifier = 0;

        isLeftFaced = false;
        isAlive = true;
    }

    /**
     * Method that considers all the states that the player can find himself in, and according
     * to that makes him move or stay in a correct position. Apart from that score is updated
     * using highest achieved y position.
     */
    public void updateMotion()
    {
        float time = min(lifeTime, 70);
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
            velocityModifier = 15 * time;
            gravityModifier = velocityModifier * gravity0 * (velocityModifier + 2 * velocity0) / (velocity0 * velocity0);
            airTime += Gdx.graphics.getDeltaTime();
            y -= (gravity0 + gravityModifier) * airTime * Gdx.graphics.getDeltaTime();
        }
        if (isJump)
        {
            velocityModifier = 15 * time;
            gravityModifier = velocityModifier * gravity0 * (velocityModifier + 2 * velocity0) / (velocity0 * velocity0);
            jumpTime += Gdx.graphics.getDeltaTime();
            if (((velocity0 + velocityModifier) - ((gravity0 + gravityModifier)  * jumpTime)) > 0)
                y += ((velocity0 + velocityModifier) - ((gravity0 + gravityModifier)  * jumpTime)) * Gdx.graphics.getDeltaTime();
            else
            {
                isJump = false;
                jumpTime = 0;
                isAirborne = true;
                airTime = 0;
            }
            //System.out.println(lifeTime + " " + getCurrentVelocity()/2 + " " + getCurrentVelocity()/2/max(175 - time * 2.5f, 125));
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

    /**
     * This methods ensures that player starts or stops moving left depending on the key state.
     * @param t     If true, starts running left, otherwise stops.
     */
    public void setLeftMove(boolean t)
    {
        if(isRight && t) isRight = false;
        isLeft = t;
        if(isLeft){
            leftTime = 0;
            isLeftFaced = true;
        }
    }

    /**
     * This methods ensures that player starts or stops moving right depending on the key state.
     * @param t     If true, starts running right, otherwise stops.
     */
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
        if(!isAirborne && !isJump && t) {
            isJump = t;
            SoundManager.playJumpSound();
            Gdx.input.vibrate(100);
        }
        else if(!t) isJump = t;
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

    public float getVelocity0() {
        return velocity0;
    }

    public float getGravity0() {
        return gravity0;
    }

    public float getCurrentVelocity() {
        return velocity0 + velocityModifier;
    }
}
