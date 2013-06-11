package gilbert.newsinternational;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import gilbert.newsinternational.Heading.HEADING;

/**
 * This class contains all command for an individual {@link Robot}. and is comprised of:
 * 
 * <ul>
 * <li>an initial position</li>
 * <li>an initial heading</li>
 * <li>a series of movement commands such as rotate left/righ and move forward</li>
 * </ul>
 *
 */
public class Command {

	public enum MOVEMENT_COMMAND {
		MOVE, ROTATE_LEFT, ROTATE_RIGHT
	};

	private int initialX;
	private int initialY;
	private HEADING initialHeading;

	private List<MOVEMENT_COMMAND> movementCommands = new ArrayList<MOVEMENT_COMMAND>();

	public Command(int initialX, int initialY, HEADING initialHeading) {
		this.initialX = initialX;
		this.initialY = initialY;
		this.initialHeading = initialHeading;
	}

	public void addCommand(MOVEMENT_COMMAND command) {
		movementCommands.add(command);
	}

	public Collection<MOVEMENT_COMMAND> getMovementCommands() {
		return Collections.unmodifiableCollection(movementCommands);
	}

	public int getInitialX() {
		return initialX;
	}

	public int getInitialY() {
		return initialY;
	}

	public HEADING getInitialHeading() {
		return initialHeading;
	}
}
