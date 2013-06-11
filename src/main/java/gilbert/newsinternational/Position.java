package gilbert.newsinternational;

import gilbert.newsinternational.Heading.HEADING;

public class Position {
	private int x = 0;
	private int y = 0;

	private HEADING heading;

	public Position(HEADING initialHeading, int x, int y) {
		this.x = x;
		this.y = y;
		this.heading = initialHeading;
	}

	public Position(Position position) {
		this.x = position.x;
		this.y = position.y;
		this.heading = position.getHeading();
	}

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


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public HEADING getHeading() {
		return heading;
	}

}
