package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.text.DecimalFormat;
import java.util.LinkedList;

import static com.proz.jumper.TextureManager.*;

/**
 * This class is for putting things on the screen.
 * Created by volterra on 15.04.17.
 */
public class Display {
    /**
     * Two font types used for text generating on the screen.
     */
    private static BitmapFont font, fontL;

    /**
     * Generator is a tool that makes it possible to transform a TrueTypeFont into a bitmap
     */
    private static FreeTypeFontGenerator generator;

    /**
     * This variables are used to attributes of a text, e.g. color, size, boldness
     */
    private static FreeTypeFontGenerator.FreeTypeFontParameter parameter, parameterL;

    /**
     * Decimal format makes it possible to truncate a float into a useful on-screen form
     */
    private static DecimalFormat df;

    /**
     * In in this method all the previously mentioned variables are initialised
     */
    public static void load(){
        generator = new FreeTypeFontGenerator(Gdx.files.internal("manaspc.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameterL = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = 50;
        parameterL.size = 100;

        parameter.color = new Color(229, 229, 229, 1);
        parameterL.color = new Color(229, 229, 229, 1)

        font = generator.generateFont(parameter);
        fontL = generator.generateFont(parameterL);

        df = new DecimalFormat("###.##");
    }

    /**
     * Here is the method that is used to get rid of all the unused objects
     */
    public static void dispose(){
        font.dispose();
        fontL.dispose();
        generator.dispose();
    }

    /**
     * Method that is used for displaying the player on the GameScreen.
     * It considers many cases regarding state in which the Player is currently in.
     * @param player    Player instance that is to be used
     * @param batch     SpriteBatch defined for the whole programme
     */
    public static void displayPlayer(Player player, SpriteBatch batch){
        if (player.getJump()){
            if(player.getLeftFaced())  batch.draw(playerJumpRegionL, player.getX(), player.getY());
            else    batch.draw(playerJumpRegion, player.getX(), player.getY());
        }
        else if(player.getAirborne()){
            if(player.getLeftFaced())  batch.draw(playerFallRegionL, player.getX(), player.getY());
            else    batch.draw(playerFallRegion, player.getX(), player.getY());
        }
        else if(player.getRightMove()){
            batch.draw((TextureRegion)animationRight.getKeyFrame(player.getRightTime(), true), player.getX(), player.getY());
        }
        else if(player.getLeftMove()){
            batch.draw((TextureRegion)animationLeft.getKeyFrame(player.getLeftTime(), true), player.getX(), player.getY());
        }
        else {
            if(player.getLeftFaced())   batch.draw((TextureRegion)animationStandL.getKeyFrame(player.getLifeTime(), true), player.getX(), player.getY());
            else    batch.draw((TextureRegion)animationStand.getKeyFrame(player.getLifeTime(), true), player.getX(), player.getY());
        }
    }

    /**
     * Displays all the Platform objects that are currently on the screen.
     * @param platforms Platform list used for this case
     * @param batch     SpriteBatch defined for the whole programme
     */
    public static void displayPlatforms(LinkedList<Platform> platforms, SpriteBatch batch){
        for (Platform item : platforms) {
            batch.draw(platformRegion, item.getX(), item.getY());
        }
    }

    /**
     * This method is used throughout the whole game to display the jungle-themed background.
     * It uses the camera position to put it on the screen in a correct manner.
     * @param camera    Camera that is going to give us information about the current state of the screen
     * @param batch     SpriteBatch defined for the whole programme
     */
    public static void displayBackground(OrthographicCamera camera, SpriteBatch batch){
        batch.draw(backgroundRegion, camera.position.x - camera.viewportWidth/2,
                camera.position.y - camera.viewportHeight/2);
    }

    /**
     * Method that is used to display couple of texts on the GameScreen instance.
     * @param world     We need to have a reference on a GameWorld we are in since it holds the info about player, score, etc.
     * @param batch     SpriteBatch defined for the whole programme
     */
    public static void displayGameScreenTexts(GameWorld world, SpriteBatch batch){
        font.draw(batch, Integer.toString(world.getScore()), world.getCamera().viewportWidth * 0.07f,
                world.getCamera().viewportHeight * 0.45f + world.getCamera().position.y);
        font.draw(batch, df.format(world.getPlayer().getLifeTime()), world.getCamera().viewportWidth * 0.73f,
                world.getCamera().viewportHeight * 0.45f + world.getCamera().position.y);
    }

    /**
     * Method that is used to display couple of texts on the ScoreScreen instance.
     * @param file      File that is used to hold the information about the highest score achieved.
     * @param camera    Camera size is used to determine where to put the texts.
     * @param batch     SpriteBatch defined for the whole programme
     */
    public static void displayScoreScreenTexts(FileHandle file, OrthographicCamera camera, SpriteBatch batch){
        fontL.draw(batch, "HIGH SCORE", camera.viewportWidth * 0.05f, camera.viewportHeight * 0.5f);
        fontL.draw(batch, file.readString(), camera.viewportWidth * 0.33f, camera.viewportHeight * 0.1f);
    }

    /**
     * Method that is used to display couple of texts on the MainScreen instance.
     * @param camera    Camera size is used to determine where to put the texts.
     * @param batch     SpriteBatch defined for the whole programme
     */
    public static void displayMainScreenTexts(OrthographicCamera camera, SpriteBatch batch){
        font.draw(batch, "Press anywhere", camera.viewportWidth/5.5f, camera.viewportHeight/6);
        font.draw(batch, "to play!", camera.viewportWidth/3.5f, camera.viewportHeight/10);
    }
}
