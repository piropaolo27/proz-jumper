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
        player = new Player(275, 0, 0, this);
        rand = new Random();

        generatePlatforms();
    }

    public void generatePlatforms(){
        for (int i = 0; i < 10; ++i )
        {
            Platform platform = new Platform(rand.nextInt(390),
                    rand.nextInt(100) + i * 200 + 50, i+1,this);
            platforms.add(platform);
        }
    }

    public void platformsCollision(){
        platforms.forEach(item->{
            if (player.getAirborne() && player.getY() - item.getY() > 40 && player.getY() - item.getY() < 70
                    && player.getX() - item.getX() > -35 && player.getX() - item.getX() < 180){
                player.setAirborne(false);
                player.setY(item.getY() + 69);
            }

            if (!player.getAirborne() && !player.getJump() && player.getY() - item.getY() == 69
                    && (player.getX() - item.getX() < -35 || player.getX() - item.getX() > 180)){
                player.setAirborne(true);
            }
        });
    }

    public Player getPlayer(){
        return player;
    }

    public LinkedList<Platform> getPlatforms(){
        return platforms;
    }
}
