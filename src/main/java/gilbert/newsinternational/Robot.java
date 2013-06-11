package gilbert.newsinternational;

import gilbert.newsinternational.Heading.HEADING;

/**
 * Simple Robot class. Bounds checking is performed. No other error checking or
 * collision detection is performed.
 */
public class Robot {

	private Position currentPosition = null;

	/**
	 * Create a new {@link Robot} with an initial heading and position.
	 * 
	 * @param initialHeading
	 *            Robots initial {@link Heading}. Mandatory.
	 * @param x
	 *            Robots initial x position - note this can be outside of the
	 *            plateau
	 * @param y
	 *            Robots initial y position - note this can be outside of the
	 *            plateau
	 */
	public Robot(final HEADING initialHeading, int x, int y) {
		NullParamterException.throwIfNull(initialHeading);
		this.currentPosition = new Position(initialHeading, x, y);
	}

	/**
	 * Rotate Robots current heading 90 degrees to the left
	 */
	public void rotateLeft() {
		currentPosition.rotateLeft();
	}

	/**
	 * Rotate Robots current heading 90 degrees to the right
	 */
	public void rotateRight() {
		currentPosition.rotateRight();
	}

	/**
	 * Instruct Robot to move one step along its current heading
	 */
	public void move() {
		currentPosition = currentPosition.getNextPosition();
	}

	/**
	 * 
	 * @param maxX
	 *            maximum width (starting from 0) of plateau
	 * @param maxY
	 *            maximum height (starting from 0) of plateau
	 * @return true if this Robot is within the plateau's bounds if it moved
	 */
	public boolean isNextPositionWithinBounds(int maxX, int maxY) {
		Position nextPosition = currentPosition.getNextPosition();
		boolean canMove = nextPosition.getY() >= 0
				&& nextPosition.getY() <= maxY && nextPosition.getX() >= 0
				&& nextPosition.getX() <= maxX;
		return canMove;
	}

	/**
	 * 
	 * @return Robots current X position
	 */
	public int getX() {
		return currentPosition.getX();
	}

	/**
	 * 
	 * @return Robots current Y position
	 */
	public int getY() {
		return currentPosition.getY();
	}

	/**
	 * 
	 * @return Robots current {@link Heading.HEADING}
	 */
	public HEADING getHeading() {
		return currentPosition.getHeading();
	}

}
