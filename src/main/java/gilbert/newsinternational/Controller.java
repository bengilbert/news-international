package gilbert.newsinternational;

import gilbert.newsinternational.Command.MOVEMENT_COMMAND;
import gilbert.newsinternational.Heading.HEADING;

import java.util.ArrayList;
import java.util.List;

public class Controller {

	private List<Robot> robots = new ArrayList<Robot>();
	private int maxX;
	private int maxY;

	public Controller(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public void executeCommands(List<Command> commands)  {

		for (Command command : commands) {
			HEADING initialHeading = command.getInitialHeading();
			int initialX = command.getInitialX();
			int initialY = command.getInitialY();

			Robot r = new Robot(initialHeading, initialX, initialY);
			robots.add(r);
			for (MOVEMENT_COMMAND movementCommand : command
					.getMovementCommands()) {
				switch (movementCommand) {
				case MOVE:
					if (r.isNextPositionWithinBounds(maxX, maxY)) {
						r.move();
					}
					break;
				case ROTATE_LEFT:
					r.rotateLeft();
					break;
				case ROTATE_RIGHT:
					r.rotateRight();
					break;
				}
			}

		}

	}

	public List<Robot> getRobots() {
		return robots;
	}

}
