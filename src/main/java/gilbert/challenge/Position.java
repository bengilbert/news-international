package gilbert.challenge;

/**
 * This class represent the position of a Robot and contains methods that are
 * used to change the position.
 * 
 */
public class Position {
	
	public static final int NORTH = 90;
	public static final int EAST = 0;
	public static final int SOUTH = 270;
	public static final int WEST = 180;
	
	private int x = 0;
	private int y = 0;
	private int heading;

	/**
	 * Constructs a new Position with an initial {@link Heading} and initial
	 * position
	 * 
	 * @param initialHeading
	 *            Initial heading of position (compass bearing). Rounded to nearest 90 degrees. Mandatory.
	 * @param x
	 *            initial X position
	 * @param y
	 *            initial Y position
	 */
	public Position(int initialHeading, int x, int y) {
		NullParamterException.throwIfNull(initialHeading);

		this.x = x;
		this.y = y;
		this.heading = initialHeading ;
		
		//restrict movement to just bearings that class knows about
		if (this.heading != 0) {
			this.heading = this.heading - (this.heading % 90);
		}
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

		nextPosition.x = (int)Math.cos(heading * (Math.PI / 180.0)) + x;
		nextPosition.y = (int)Math.sin(heading * (Math.PI / 180.0)) + y;
	
		return nextPosition;
	}

	/**
	 * Rotates the current heading to the left 90 degrees
	 */
	public void rotateLeft() {
		heading += 90;
		if (heading != 0) {
			heading %= 360;
		}
	}

	/**
	 * Rotates the current heading to the right 90 degrees
	 */
	public void rotateRight() {
		heading += 270;
		if (heading != 0) {
			heading %= 360;
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
	public int getHeading() {
		if (heading != 0) {
			return Math.abs(heading % 360);
		}
		return 0;
	}
	
	
	public String toString() {
		String bearing = "Unknown";
		
		if (this.heading == 0) {
			bearing = "E";
		}
		else {

			if (this.heading % (EAST + 360) == 0) {
				bearing = "E";
			}
			else if (this.heading % SOUTH == 0) {
				bearing = "S";
			}
			else if (this.heading % WEST == 0) {
				bearing = "W";
			}
			else if (this.heading % NORTH == 0) {	
				bearing = "N";
			}
		}
		
		return bearing;
	}

}
