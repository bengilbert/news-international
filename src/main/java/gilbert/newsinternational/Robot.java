package gilbert.newsinternational;

import gilbert.newsinternational.Heading.HEADING;

public class Robot {

	private Position currentPosition = null;

	public Robot(final HEADING initialHeading, int x, int y) {
		NullParamterException.throwIfNull(initialHeading);
		this.currentPosition = new Position(initialHeading, x, y);
	}

	public void rotateLeft() {
		currentPosition.rotateLeft();
	}

	public void rotateRight() {
		currentPosition.rotateRight();
	}

	public Position getNextPosition() {
		return currentPosition.getNextPosition();
	}

	public void move() {
		currentPosition = currentPosition.getNextPosition();
	}

	public boolean isNextPositionWithinBounds(int maxX, int maxY) {
		Position nextPosition = currentPosition.getNextPosition();
		boolean canMove = nextPosition.getY() >= 0
				&& nextPosition.getY() <= maxY && nextPosition.getX() >= 0
				&& nextPosition.getX() <= maxX;
		return canMove;
	}

	public int getX() {
		return currentPosition.getX();
	}

	public int getY() {
		return currentPosition.getY();
	}

	public HEADING getHeading() {
		return currentPosition.getHeading();
	}

}
