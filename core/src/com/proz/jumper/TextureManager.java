package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by volterra on 15.04.17.
 */
public class TextureManager {
    public static TextureAtlas atlasStand;
    public static Animation animationStand;

    public static TextureAtlas atlasStandL;
    public static Animation animationStandL;

    public static TextureAtlas atlasMidair;
    public static Animation animationMidair;

    public static TextureAtlas atlasMidairL;
    public static Animation animationMidairL;

    public static TextureRegion playerJumpRegion;
    public static TextureRegion playerJumpRegionL;

    public static TextureRegion playerFallRegion;
    public static TextureRegion playerFallRegionL;

    public static TextureAtlas atlasRight;
    public static Animation animationRight;

    public static TextureAtlas atlasLeft;
    public static Animation animationLeft;

    public static TextureRegion platformRegion;

    public static TextureRegion backgroundRegion;


    public static void load(){
        atlasStand = new TextureAtlas(Gdx.files.internal("p1_idle.atlas"));
        animationStand = new Animation(1/10f, atlasStand.getRegions());

        atlasStandL = new TextureAtlas(Gdx.files.internal("p1_idleL.atlas"));
        animationStandL = new Animation(1/10f, atlasStandL.getRegions());

        /*atlasMidair = new TextureAtlas(Gdx.files.internal("p1_midair.atlas"));
        animationMidair = new Animation(1/10f, atlasMidair.getRegions());

        atlasMidairL = new TextureAtlas(Gdx.files.internal("p1_midairL.atlas"));
        animationMidairL = new Animation(1/10f, atlasMidair.getRegions());*/

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

    public static void dispose(){
        atlasStand.dispose();
        atlasStandL.dispose();
        atlasRight.dispose();
        atlasLeft.dispose();
    }
}
