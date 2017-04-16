package com.proz.jumper;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by volterra on 15.04.17.
 */
public class InputHandler implements InputProcessor {
    private Player player;

    public InputHandler(Player player){
        this.player = player;
    }

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
        }
        return true;
    }
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

    public boolean touchDown (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }

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
