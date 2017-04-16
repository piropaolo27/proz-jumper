package com.proz.jumper;

/**
 * Created by volterra on 16.04.17.
 */
public class GameWorld {
    private Player player;

    public GameWorld(){
        player = new Player(150, 600, 0, this);
    }

    public Player getPlayer(){
        return player;
    }
}
