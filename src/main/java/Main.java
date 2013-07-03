import gilbert.challenge.Command;
import gilbert.challenge.Controller;
import gilbert.challenge.Position;
import gilbert.challenge.Robot;
import gilbert.challenge.Command.MOVEMENT_COMMAND;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Command line wrapper which parses command line arguments which are a series
 * of characters representing the rovers movements:
 * 
 * R - rotate rover right 90 degrees L - rotate rover left 90 degrees F - move
 * rover forward 1 unit.
 * 
 * All commands must be grouped together. e.g. RFLFFRF.
 * 
 * The rover is assumed to start at position 0,0 to be north facing.
 * 
 * The rover's final grid position is displayed at the end of execution
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {

		/*
		 * Got arguments?
		 */
		if (args.length > 0) {

			Controller controller = new Controller(4, 4);

			/*
			 * Parse robot initial position and movements. Robots are parsed
			 * individually and it is assumed that each robot command is correct
			 * and contains an initial position line as well as a line of
			 * movement commands.
			 */
			List<Command> robotMovementCommands = new ArrayList<Command>();

			Command command = new Command(0, 0, Position.NORTH);

			// extract movement commands
			String movementCommands = args[0];

			// ignore case differences in input
			movementCommands = movementCommands.toUpperCase();

			if (movementCommands == null || movementCommands.isEmpty()) {
				System.out
						.println("ERROR: Robots movement commands must be specified");
				System.exit(1);
			}

			for (int i = 0; i < movementCommands.length(); i++) {
				char commandCode = movementCommands.charAt(i);
				switch (commandCode) {
				case 'F':
					command.addCommand(MOVEMENT_COMMAND.MOVE);
					break;
				case 'L':
					command.addCommand(MOVEMENT_COMMAND.ROTATE_LEFT);
					break;
				case 'R':
					command.addCommand(MOVEMENT_COMMAND.ROTATE_RIGHT);
					break;
				}

			}
			robotMovementCommands.add(command);

			/*
			 * Execute robot commands
			 */
			controller.executeCommands(robotMovementCommands);

			/*
			 * Determine robots final position and heading
			 */
			List<Robot> robots = controller.getRobots();

			for (Robot robot : robots) {
				int finalX = robot.getX();
				int finalY = robot.getY();

				System.out.println("Rover's final position is (" + finalX + ","
						+ finalY + ")");

			}

		} else {
			System.out.println("Movement commands not specified e.g. RFLFFRF.");
		}

	}

}
