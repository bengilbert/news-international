import gilbert.newsinternational.Command;
import gilbert.newsinternational.Command.MOVEMENT_COMMAND;
import gilbert.newsinternational.Controller;
import gilbert.newsinternational.Heading.HEADING;
import gilbert.newsinternational.Robot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Command line wrapper which loads a file adhering to the following format:
 * 
 * The first line of input is the upper-right coordinates of the plateau, the
 * lower-left coordinates are assumed to be 0,0. The rest of the input is
 * information pertaining to the robots that have been deployed. Each robot has
 * two lines of input. The first line gives the robot's position, and the second
 * line is a series of instructions telling the robot how to explore the
 * plateau. 
 * 
 * The final position of all robots are displayed after all commands have been
 * executed.
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		String commandFileName = null;

		/*
		 * Got arguments?
		 */
		if (args.length > 0) {

			commandFileName = args[0];

			/*
			 * Attempt to read in specified file
			 */
			BufferedReader file = null;
			try {
				file = new BufferedReader(new FileReader(commandFileName));
			} catch (FileNotFoundException e) {
				System.out
						.println("ERROR: command file not found, please check filename and try again.");
				System.exit(1);
			}

			/*
			 * Parse file in a primitive manner, creating commands to send to
			 * the controller as the file is parsed
			 */
			Controller controller = null;
			try {
				/*
				 * Extract the plateau maximum dimensions
				 */
				String plateauDimensionLine = file.readLine();
				String[] dimensions = plateauDimensionLine.split(" ");

				if (dimensions.length < 2) {
					System.out
							.println("ERROR:  first line of command file must specify dimensions.  eg 10 10.");
					System.exit(1);
				}

				int maxX = 0;
				int maxY = 0;
				try {
					maxX = Integer.parseInt(dimensions[0]);
					maxY = Integer.parseInt(dimensions[1]);
				} catch (NumberFormatException ex) {
					System.out
							.println("ERROR: plateau dimensions must be numeric");
					System.exit(1);
				}

				controller = new Controller(maxX, maxY);

				/*
				 * Parse robot initial position and movements. Robots are parsed
				 * individually and it is assumed that each robot command is
				 * correct and contains an initial position line as well as a
				 * line of movement commands.
				 */
				List<Command> robotMovementCommands = new ArrayList<Command>();
				String initialPosition = null;
				while ((initialPosition = file.readLine()) != null) {

					/*
					 * Extract robots initial position
					 */
					String[] position = initialPosition.split(" ");
					if (position.length < 3) {
						System.out
								.println("ERROR: Robots initial position must be in correct format. X Y Heading");
						System.exit(1);
					}

					int initialX = 0;
					int initialY = 0;
					HEADING initialHeading = null;

					try {
						initialX = Integer.parseInt(position[0]);
						initialY = Integer.parseInt(position[1]);
						switch (position[2].charAt(0)) {
						case 'N':
							initialHeading = HEADING.N;
							break;
						case 'E':
							initialHeading = HEADING.E;
							break;
						case 'S':
							initialHeading = HEADING.S;
							break;
						case 'W':
							initialHeading = HEADING.W;
							break;
						default:
							System.out
									.println("ERROR: Unknown initial heading of "
											+ position[2]
											+ ".  Must be N, E, S or W.");
							System.exit(1);
						}
					} catch (NumberFormatException ex) {
						System.out
								.println("ERROR: Unable to parse Robots initial position.  Please verify format is correct.");
						System.exit(1);
					}

					Command command = new Command(initialX, initialY,
							initialHeading);

					// extract movement commands
					String movementCommands = file.readLine();

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
						case 'M':
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

				}

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
					HEADING finalHeading = robot.getHeading();

					System.out.println("" + finalX + " " + finalY + " "
							+ finalHeading);

				}

			} catch (IOException e) {
				System.out
						.println("ERROR: Unexpected error in command file.  Please verify format is correct.");
			} finally {
				file.close();
			}

		} else {
			System.out
					.println("Command file not specifed.  Please enter name of command file.");
		}

	}

}
