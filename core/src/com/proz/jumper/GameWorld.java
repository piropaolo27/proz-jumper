package com.proz.jumper;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

import static com.proz.jumper.TextureManager.*;

/**
 * Created by volterra on 16.04.17.
 */
public class GameWorld {
    private LinkedList<Platform> platforms;
    private Player player;
    private GameCamera camera;
    private Random rand;
    private int score;
    private int platformCount;

    private static int width;
    private static int height;
    private final static int playerWidth = playerFallRegion.getRegionWidth();
    private final static int platformWidth = platformRegion.getRegionWidth();


    public GameWorld(){
        platforms = new LinkedList<Platform>();
        player = new Player(720/2 - playerWidth/2, 0, 0, this);
        camera = new GameCamera(getPlayer());
        camera.setToOrtho(false, 720, 1280);
        rand = new Random();
        score = 0;
        platformCount = 0;

        width = (int)camera.viewportWidth;
        height = (int)camera.viewportHeight;

        generatePlatforms();
    }

    public void generatePlatforms(){
        for (int i = 0; i < 10; ++i )
        {
            Platform platform = new Platform(rand.nextInt(width - platformWidth),
                    rand.nextInt((int)(height * 0.05f - 1/128f)) + platformCount * height/6 + height/18, ++platformCount, this);
            platforms.add(platform);
        }
    }

    public void generateMorePlatforms(){
        boolean temp = false;
        for (Platform item : platforms) {
            if (item.getY() > camera.position.y + camera.viewportHeight/2)    temp = true;
        }
        if (!temp) generatePlatforms();
    }

    public void platformsCollision(){
        for (Platform item : platforms) {
            if (player.getAirborne() && player.getY() - item.getY() > 40 && player.getY() - item.getY() < 70
                    && player.getX() - item.getX() > -35 && player.getX() - item.getX() < 180){
                player.setAirborne(false);
                player.setY(item.getY() + 69);
                System.out.println(item.id);
            }

            if (!player.getAirborne() && !player.getJump() && player.getY() - item.getY() == 69
                    && (player.getX() - item.getX() < -35 || player.getX() - item.getX() > 180)){
                player.setAirborne(true);
            }
        }
    }

    public void platformsUpdate(){
        ListIterator<Platform> iterator = platforms.listIterator();
        while (iterator.hasNext()){
            Platform plat = iterator.next();
            if (plat.getY() < camera.position.y - camera.viewportHeight/2 - platformRegion.getRegionHeight())
                iterator.remove();
        }
    }

    public boolean isPlayerAlive(){
        if (player.getY() < camera.position.y - camera.viewportHeight/2) {
            player.setAlive(false);
            return false;
        }
        return true;
    }

    public Player getPlayer(){
        return player;
    }

    public LinkedList<Platform> getPlatforms(){
        return platforms;
    }

    public GameCamera getCamera() {
        return camera;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int t){
        this.score = t;
    }
}
