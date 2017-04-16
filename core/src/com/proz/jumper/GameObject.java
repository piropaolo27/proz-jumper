package com.proz.jumper;

/**
 * Created by volterra on 15.04.17.
 */
public class GameObject {
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected int id;
    protected GameWorld world;

    public GameObject(float x, float y, int id, GameWorld world){
        this.x = x;
        this.y = y;
        this.id = id;
        this.world = world;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }
}
