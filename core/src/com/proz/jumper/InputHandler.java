package com.proz.jumper;

import com.badlogic.gdx.Gdx;
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
            case Input.Keys.UP:
                player.setJump(true);
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
        if(x > 0 && x < (Gdx.graphics.getWidth()/2f)-1 && y > 0 && y < Gdx.graphics.getHeight() * (4f/5f)-1)
            player.setLeftMove(true);
        if(x > Gdx.graphics.getWidth()/2 && x < Gdx.graphics.getWidth() && y > 0 && y < Gdx.graphics.getHeight() * (4f/5f)-1)
            player.setRightMove(true);
        if(x > 0 && x < Gdx.graphics.getWidth() && y > Gdx.graphics.getHeight() * (4f/5f) && y < Gdx.graphics.getHeight())
            player.setJump(true);
        return true;
    }

    public boolean touchUp (int x, int y, int pointer, int button) {
        if(x > 0 && x < (Gdx.graphics.getWidth()/2f)-1 && y > 0 && y < Gdx.graphics.getHeight() * (4f/5f)-1)
            player.setLeftMove(false);
        if(x > Gdx.graphics.getWidth()/2 && x < Gdx.graphics.getWidth() && y > 0 && y < Gdx.graphics.getHeight() * (4f/5f)-1)
            player.setRightMove(false);
        return true;
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
