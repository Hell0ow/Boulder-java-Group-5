package model;

import Imodel.IDirection;

public enum Direction implements IDirection {
	UP, RIGHT, DOWN, LEFT;
	
	public static void next(Direction direction) {
		switch (direction) {
			case UP:
				direction = RIGHT;
				break;
			case RIGHT:
				direction = DOWN;
				break;
			case DOWN:
				direction = LEFT;
				break;
			case LEFT:
				direction = UP;
				break;
		}
	}
}
