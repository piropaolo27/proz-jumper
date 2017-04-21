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
    public static TextureRegion playerStandRegion;
    public static TextureRegion playerStandRegionL;

    public static TextureRegion playerJumpRegion;
    public static TextureRegion playerJumpRegionL;

    public static TextureRegion platformRegion;

    public static TextureAtlas atlasRight;
    public static Animation animationRight;

    public static TextureAtlas atlasLeft;
    public static Animation animationLeft;


    public static void load(){
        playerStandRegion = new TextureRegion(new Texture(Gdx.files.internal("p1_stand.png")));
        playerStandRegionL = new TextureRegion(new Texture(Gdx.files.internal("p1_standL.png")));

        playerJumpRegion = new TextureRegion(new Texture(Gdx.files.internal("p1_jump.png")));
        playerJumpRegionL = new TextureRegion(new Texture(Gdx.files.internal("p1_jumpL.png")));

        platformRegion = new TextureRegion(new Texture(Gdx.files.internal("platform.png")));

        atlasRight = new TextureAtlas(Gdx.files.internal("p1_right.atlas"));
        animationRight = new Animation(1/30f, atlasRight.getRegions());

        atlasLeft = new TextureAtlas(Gdx.files.internal("p1_left.atlas"));
        animationLeft = new Animation(1/30f, atlasLeft.getRegions());
    }

    public static void dispose(){
        atlasRight.dispose();
        atlasLeft.dispose();
    }
}
