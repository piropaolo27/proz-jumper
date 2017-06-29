package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * This class holds all the assets used to display images of the player, platforms, etc.
 * Created by volterra on 15.04.17.
 */
public class TextureManager {
    /**
     * Texture batch for standing player.
     */
    public static TextureAtlas atlasStand;

    /**
     * Animation for standing player.
     */
    public static Animation animationStand;

    /**
     * Texture batch for standing player, facing left.
     */
    public static TextureAtlas atlasStandL;

    /**
     * Animation for standing player, facing left.
     */
    public static Animation animationStandL;

    /**
     * Texture for jumping player.
     */
    public static TextureRegion playerJumpRegion;

    /**
     * Texture for jumping player, facing left.
     */
    public static TextureRegion playerJumpRegionL;

    /**
     * Texture for falling player.
     */
    public static TextureRegion playerFallRegion;

    /**
     * Texture for falling player, facing left.
     */
    public static TextureRegion playerFallRegionL;

    /**
     * Texture batch for player moving right.
     */
    public static TextureAtlas atlasRight;

    /**
     * Animation for player moving right.
     */
    public static Animation animationRight;

    /**
     * Texture batch for player moving left.
     */
    public static TextureAtlas atlasLeft;

    /**
     * Animation for player moving left.
     */
    public static Animation animationLeft;

    /**
     * Platform texture.
     */
    public static TextureRegion platformRegion;

    /**
     * Background texture.
     */
    public static TextureRegion backgroundRegion;

    /**
     * In this method all the previously mentioned variables are initialised.
     */
    public static void load(){
        atlasStand = new TextureAtlas(Gdx.files.internal("p1_idle.atlas"));
        animationStand = new Animation(1/10f, atlasStand.getRegions());

        atlasStandL = new TextureAtlas(Gdx.files.internal("p1_idleL.atlas"));
        animationStandL = new Animation(1/10f, atlasStandL.getRegions());

        playerJumpRegion = new TextureRegion(new Texture(Gdx.files.internal("p1_jump.png")));
        playerJumpRegionL = new TextureRegion(new Texture(Gdx.files.internal("p1_jumpL.png")));

        playerFallRegion = new TextureRegion(new Texture(Gdx.files.internal("p1_fall.png")));
        playerFallRegionL = new TextureRegion(new Texture(Gdx.files.internal("p1_fallL.png")));

        atlasRight = new TextureAtlas(Gdx.files.internal("p1_right.atlas"));
        animationRight = new Animation(1/10f, atlasRight.getRegions());

        atlasLeft = new TextureAtlas(Gdx.files.internal("p1_left.atlas"));
        animationLeft = new Animation(1/10f, atlasLeft.getRegions());


        platformRegion = new TextureRegion(new Texture(Gdx.files.internal("platform.png")));

        backgroundRegion = new TextureRegion(new Texture(Gdx.files.internal("background.png")));
    }

    /**
     * This method cleans all the objects that will not be used in future.
     */
    public static void dispose(){
        atlasStand.dispose();
        atlasStandL.dispose();
        atlasRight.dispose();
        atlasLeft.dispose();
    }
}
