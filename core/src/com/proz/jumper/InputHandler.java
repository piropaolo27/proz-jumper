package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Custom InputHandler. This class processes event that occur on the player keyboard or touchscreen.
 * Created by volterra on 15.04.17.
 */
public class InputHandler implements InputProcessor {
    /**
     * Player instance is needed due to the fact that pressed keys are passed there to make him
     * move as the user wishes.
     */
    private Player player;

    /**
     * When constructed, Player object is passed.
     * @param player    This makes possible for InputHandler to know which player is to be updated
     */
    public InputHandler(Player player){
        this.player = player;
    }

    /**
     * This method ensures appropriate measures are taken when a key is pressed.
     * @param keycode   Keycode of a certain key needed to process the specific event
     * @return          If any key has been pressed, returns true.
     */
    @Override
    public boolean keyDown(int keycode)
    {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                player.setLeftMove(true);
                break;
            case Input.Keys.RIGHT:
                player.setRightMove(true);
                break;
            case Input.Keys.UP:
                player.setJump(true);
        }
        return true;
    }

    /**
     * This method ensures appropriate measures are taken when a key is let.
     * @param keycode  Keycode of a certain key needed to process the specific event
     * @return         If any key has been let, returns true.
     */
    @Override
    public boolean keyUp(int keycode)
    {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                player.setLeftMove(false);
                break;
            case Input.Keys.RIGHT:
                player.setRightMove(false);
                break;
        }
        return true;
    }

    public boolean keyTyped (char character) {
        return false;
    }

    /**
     * This method processes input on the touchscreen. Depending on which part of the screen has been pressed
     * certain actions are taken:
     * - left part -> start running left
     * - right part -> start running right
     * - lower part -> jump
     * @param x         the horizontal distance of a place that has been pressed
     * @param y         the vertical distance of a place that has been pressed
     * @param pointer   the pointer for the event
     * @param button    the button
     * @return          whether the input was processed
     */
    public boolean touchDown (int x, int y, int pointer, int button) {
        if(x > 0 && x < (Gdx.graphics.getWidth()/2f)-1 && y > 0 && y < Gdx.graphics.getHeight() * (4f/5f)-1)
            player.setLeftMove(true);
        if(x > Gdx.graphics.getWidth()/2 && x < Gdx.graphics.getWidth() && y > 0 && y < Gdx.graphics.getHeight() * (4f/5f)-1)
            player.setRightMove(true);
        if(x > 0 && x < Gdx.graphics.getWidth() && y > Gdx.graphics.getHeight() * (4f/5f) && y < Gdx.graphics.getHeight())
            player.setJump(true);
        return true;
    }

    /**
     * This method processes input on the touchscreen. Depending on which part of the screen has been let
     * certain actions are taken:
     * - left part -> stop running left
     * - right part -> stop running right
     * @param x         the horizontal distance of a place that has been let
     * @param y         the vertical distance of a place that has been let
     * @param pointer   the pointer for the event
     * @param button    the button
     * @return          whether the input was processed
     */
    public boolean touchUp (int x, int y, int pointer, int button) {
        if(x > 0 && x < (Gdx.graphics.getWidth()/2f)-1 && y > 0 && y < Gdx.graphics.getHeight() * (4f/5f)-1)
            player.setLeftMove(false);
        if(x > Gdx.graphics.getWidth()/2 && x < Gdx.graphics.getWidth() && y > 0 && y < Gdx.graphics.getHeight() * (4f/5f)-1)
            player.setRightMove(false);
        return true;
    }

    //Those methods are compulsory as InputProcessor is an interface.
    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    public boolean mouseMoved (int x, int y) {
        return false;
    }

    public boolean scrolled (int amount) {
        return false;
    }

}
