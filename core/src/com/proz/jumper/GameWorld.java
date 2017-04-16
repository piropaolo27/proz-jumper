package com.proz.jumper;

import java.util.LinkedList;

/**
 * Created by volterra on 16.04.17.
 */
public class GameWorld {
    LinkedList<GameObject> objects;
    private Player player;
    public Platform platform1;
    public Platform platform2;

    public GameWorld(){
        objects = new LinkedList<GameObject>();
        player = new Player(150, 600, 0, this);
        platform1 = new Platform(100, 100, 1, this);
        objects.add(platform1);
        platform2 = new Platform(300, 300, 2, this);
        objects.add(platform2);
    }

    public void platformCollision(){
        objects.forEach(item->{
            if (item.getY() - player.getY() <= 10)
                player.setAirborne(false);
        });
    }

    public Player getPlayer(){
        return player;
    }
}
