package com.proz.jumper;

/**
 * This class has generally the same functionality as the GameObject class, however it was
 * created as a separate entity to make it possible to easily extend its role.
 * Created by volterra on 16.04.17.
 */
public class Platform extends GameObject {
    /**
     * Main constructor for the platform, called from superclass.
     * @param x     horizontal position
     * @param y     vertical position
     * @param id    identifier
     * @param world reference to own world
     */
    public Platform(float x, float y, int id, GameWorld world)
    {
        super(x, y, id, world);
    }
}
