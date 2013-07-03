package gilbert.challenge;

import gilbert.challenge.Command.MOVEMENT_COMMAND;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple controller which creates robots based on the list of {@link Command}s passed to it.
 * Minimal validation checking is performed and currently the robots initial position can be defined 
 * outside of the plateau's allowable dimensions.
 *
 */
public class Controller {

	private List<Robot> robots = new ArrayList<Robot>();
	private int maxX;
	private int maxY;

	/**
	 * Constructs a new Controller.
	 * 
	 * @param maxX
	 *            Maximum width of plateau that Robots can explore within
	 * @param maxY
	 *            Maximum height of plateau that Robots can explore within
	 */
	public Controller(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}

	/**
	 * Executes commands for all robots. Commands are executed sequentially and
	 * no collision detection is performed (Robots can move through other
	 * robots).
	 * 
	 * @param commands
	 *            List of Commands for each robot to be executed. Mandatory.
	 */
	public void executeCommands(List<Command> commands) {

		NullParamterException.throwIfNull(commands);

		/*
		 * Discard any robots from previous commands
		 */
		robots.clear();

		for (Command command : commands) {
			int initialHeading = command.getInitialHeading();
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

	/**
	 * 
	 * @return All Robots currently defined by the last call to
	 *         {@link #executeCommands(List)}. Note this list may be empty.
	 */
	public List<Robot> getRobots() {
		return robots;
	}

}
