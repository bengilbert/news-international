package gilbert.newsinternational;

import gilbert.newsinternational.Heading.HEADING;

/**
 * This class represent the position of a Robot and contains methods that are
 * used to change the position.
 * 
 */
public class Position {
	private int x = 0;
	private int y = 0;

	private HEADING heading;

	/**
	 * Constructs a new Position with an initial {@link Heading} and initial
	 * position
	 * 
	 * @param initialHeading
	 *            Initial heading of position. Mandatory.
	 * @param x
	 *            initial X position
	 * @param y
	 *            initial Y position
	 */
	public Position(HEADING initialHeading, int x, int y) {
		NullParamterException.throwIfNull(initialHeading);

		this.x = x;
		this.y = y;
		this.heading = initialHeading;
	}

	/**
	 * Creates a new Position from an existing position.
	 * 
	 * @param position
	 *            The position to duplicate. Mandatory.
	 */
	private Position(Position position) {
		NullParamterException.throwIfNull(position);

		this.x = position.x;
		this.y = position.y;
		this.heading = position.getHeading();
	}

	/**
	 * 
	 * @return the next position of this instance should it move in the
	 *         direction of the heading
	 */
	public Position getNextPosition() {
		Position nextPosition = new Position(this);

		switch (heading) {
		case N:
			nextPosition.y = nextPosition.y + 1;
			break;
		case E:
			nextPosition.x = nextPosition.x + 1;
			break;
		case S:
			nextPosition.y = nextPosition.y - 1;
			break;
		case W:
			nextPosition.x = nextPosition.x - 1;
			break;
		}

		return nextPosition;
	}

	/**
	 * Rotates the current heading to the left 90 degrees
	 */
	public void rotateLeft() {
		switch (heading) {
		case N:
			heading = HEADING.W;
			break;
		case E:
			heading = HEADING.N;
			break;
		case S:
			heading = HEADING.E;
			break;
		case W:
			heading = HEADING.S;
			break;
		}
	}

	/**
	 * Rotates the current heading to the right 90 degrees
	 */
	public void rotateRight() {
		switch (heading) {
		case N:
			heading = HEADING.E;
			break;
		case E:
			heading = HEADING.S;
			break;
		case S:
			heading = HEADING.W;
			break;
		case W:
			heading = HEADING.N;
			break;
		}
	}

	/**
	 * 
	 * @return the current X position for this {@link Position}
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return the current Y position for this {@link Position}
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @return This {@link Position}s current heading
	 */
	public HEADING getHeading() {
		return heading;
	}

}
