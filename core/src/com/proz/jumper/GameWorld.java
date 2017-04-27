package com.proz.jumper;

import com.badlogic.gdx.Gdx;

import java.util.LinkedList;
import java.util.Random;

import static com.proz.jumper.TextureManager.*;

/**
 * Created by volterra on 16.04.17.
 */
public class GameWorld {
    private LinkedList<Platform> platforms;
    private Player player;

    private Random rand;
    private final static int width = Gdx.graphics.getWidth();
    private final static int height = Gdx.graphics.getHeight();
    private final static int playerWidth = playerFallRegion.getRegionWidth();
    private final static int platformWidth = platformRegion.getRegionWidth();


    public GameWorld(){
        platforms = new LinkedList<Platform>();
        player = new Player(width/2 - playerWidth/2, 0, 0, this);
        rand = new Random();

        generatePlatforms();
    }

    public void generatePlatforms(){
        for (int i = 0; i < 100; ++i )
        {
            Platform platform = new Platform(rand.nextInt(width - platformWidth),
                    rand.nextInt(height/20) + i * height/6 + height/18, i+1, this);
            platforms.add(platform);
        }
    }

    public void platformsCollision(){
        for (Platform item : platforms) {
            if (player.getAirborne() && player.getY() - item.getY() > 40 && player.getY() - item.getY() < 70
                    && player.getX() - item.getX() > -35 && player.getX() - item.getX() < 180){
                player.setAirborne(false);
                player.setY(item.getY() + 69);
            }

            if (!player.getAirborne() && !player.getJump() && player.getY() - item.getY() == 69
                    && (player.getX() - item.getX() < -35 || player.getX() - item.getX() > 180)){
                player.setAirborne(true);
            }
        }
    }

    public Player getPlayer(){
        return player;
    }

    public LinkedList<Platform> getPlatforms(){
        return platforms;
    }
}
