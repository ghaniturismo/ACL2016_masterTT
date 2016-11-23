package fr.ul.acl.model;

import com.badlogic.gdx.math.Vector2;

public abstract class GameMoveableElement extends GameElement {

	private Vector2 position = getPosition();

	private enum Direction {
		RIGHT, LEFT, UP, DOWN
	};

	private Direction direction;
	private boolean isMoving;
	private boolean shootBullet;
	private float speed = getSpeed();

	public GameMoveableElement(Vector2 position, float speed, World world) {
		super(position, speed, world);
		this.isMoving = false;
		this.direction = Direction.LEFT;
	}

	// fct appeler par le controlleur
	public void DirectionRight() {
		this.isMoving = true;
		this.direction = Direction.RIGHT;
	}

	public void DirectionLeft() {
		this.isMoving = true;
		this.direction = Direction.LEFT;
	}

	public void DirectionUP() {
		this.isMoving = true;
		this.direction = Direction.UP;
	}

	public void DirectionDown() {
		this.isMoving = true;
		this.direction = Direction.DOWN;
	}

	public void Shoot() {
		shootBullet = true;
	}

	// maj de la position des elements dans la fenetre
	public void update(float delta) {
		float tmp = delta * speed;

		if (isMoving) {
			switch (direction) {
			case LEFT:
				turnLeft(tmp);
				break;
			case RIGHT:
				turnRight(tmp);
				break;
			case UP:
				turnUp(tmp);
				break;
			case DOWN:
				turnDown(tmp);
				break;
			}
		}

		if (shootBullet)
			getWorld().addBullet();
	}

	// maj la position d'un Alien.
	public void updateAlien(float delta) {
		float tmp = delta * speed;
		position.y = position.y - tmp;
	}

	// stop le mvt du gemelement dans la fenetre
	public void stop() {
		this.isMoving = false;
		this.shootBullet = false;
	}

	// permet le mvt selon la direction
	public void turnLeft(float tmp) {
		if (this.position.x - tmp <= 0) {
			isMoving = false;
			this.position.x = 0;
		} else {
			this.position.x = this.position.x - tmp;
		}
	}

	public void turnRight(float tmp) {
		if (this.position.x + 1 + tmp >= getWorld().getWorld_width()) {
			isMoving = false;
			this.position.x = getWorld().getWorld_width() - 1;
		} else {
			this.position.x = this.position.x + tmp;
		}
	}

	public void turnUp(float tmp) {
		if (this.position.y + 1 + tmp >= getWorld().getWorld_height()) {
			isMoving = false;
			this.position.y = getWorld().getWorld_height() - 1;
		} else {
			this.position.y = this.position.y + tmp;
		}
	}

	public void turnDown(float tmp) {
		if (this.position.y - tmp <= 0) {
			isMoving = false;
			this.position.y = 0;
		} else {
			this.position.y = this.position.y - tmp;
		}
	}

}
