package com.proz.jumper;

/**
 * GameObject class is the main class which stands a base
 * for other classes.
 * Created by volterra on 15.04.17.
 */
public class GameObject {
    /**
     * The horizontal distance of origin of an object.
     */
    protected float x;
    /**
     * The vertical distance of origin of an object.
     */
    protected float y;
    /**
     * Identifier used to distinguish objects.
     */
    protected int id;
    /**
     * GameWorld instance that this objects belongs to.
     */
    protected GameWorld world;

    /**
     * Main constructor for the object.
     * @param x     horizontal position
     * @param y     vertical position
     * @param id    identifier
     * @param world reference to own world
     */
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

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }
}
