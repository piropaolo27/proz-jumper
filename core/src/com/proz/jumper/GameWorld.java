package com.proz.jumper;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by volterra on 16.04.17.
 */
public class GameWorld {
    private LinkedList<Platform> platforms;
    private Player player;

    private Random rand;

    public GameWorld(){
        platforms = new LinkedList<Platform>();
        player = new Player(150, 600, 0, this);
        rand = new Random();

        generatePlatforms();
    }

    public void generatePlatforms(){
        for (int i = 0; i < 10; ++i )
        {
            Platform platform = new Platform(rand.nextInt(500),
                    rand.nextInt(200) + i * 200, i+1,this);
            platforms.add(platform);
        }
    }

    public void platformsCollision(){
        platforms.forEach(item->{
            if (item.getY() - player.getY() <= 70)
                player.setAirborne(false);
        });
    }

    public Player getPlayer(){
        return player;
    }

    public LinkedList<Platform> getPlatforms(){
        return platforms;
    }
}
