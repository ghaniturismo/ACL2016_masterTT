package fr.ul.acl.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import fr.ul.acl.model.Ship;
import fr.ul.acl.model.World;

public class GameListener implements InputProcessor {
	private World world;

	public GameListener(World world) {
		this.world = world;
	}

	// permet de choisir la direction selon les fleches
	public boolean keyDown(int keycode) {
		Ship ship = world.getShip();
		switch (keycode) {
		case Input.Keys.UP:
			ship.setDirection(3);
			ship.stop(true);
			break;
		case Input.Keys.DOWN:
			ship.setDirection(4);
			ship.stop(true);
			break;
		case Input.Keys.LEFT:
			ship.setDirection(1);
			ship.stop(true);
			break;
		case Input.Keys.RIGHT:
			ship.setDirection(2);
			ship.stop(true);
			break;
			//permet de tirer
		case Input.Keys.SPACE:
			world.shoot();
			break;
			//permet de faire pause ou reprendre selon l'etat
		case Input.Keys.ESCAPE:
			if(world.isPaused())
				world.pause(false);
			else
				world.pause(true);
			break;
		}
		return true;
	}

	// permet de stopper le mvt quand on arrete d'appuyer sur les touches
	@Override
	public boolean keyUp(int keycode) {
		if (keycode != Input.Keys.SPACE)
			world.getShip().stop(false);
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
