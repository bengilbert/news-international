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

public class Main {

	public static void main(String[] args) throws IOException {
		String commandFileName = null;

		if (args.length > 0) {

			commandFileName = args[0];
			System.out
					.println("Loading robot commands from " + commandFileName);

			BufferedReader file = null;
			try {
				file = new BufferedReader(new FileReader(commandFileName));
			} catch (FileNotFoundException e) {
				System.out
						.println("command file not found, please check filename and try again.");
				System.exit(1);
			}

			Controller controller = null;
			try {
				String plateauDimensionLine = file.readLine();
				String[] dimensions = plateauDimensionLine.split(" ");

				if (dimensions.length < 2) {
					System.out
							.println("first line of command file must specify dimensions.  eg 10 10.");
					System.exit(1);
				}

				int maxX = 0;
				int maxY = 0;
				try {
					maxX = Integer.parseInt(dimensions[0]);
					maxY = Integer.parseInt(dimensions[1]);
				} catch (NumberFormatException ex) {
					System.out.println("dimensions must be numeric");
					System.exit(1);
				}

				System.out.println("Plateau maximum dimensions are " + maxX
						+ " by " + maxY);
				controller = new Controller(maxX, maxY);

				List<Command> robotMovementCommands = new ArrayList<Command>();
				// Parse initial robot position and movement commands. It is
				// assumed that there are two
				// complete lines in the command file.
				String initialPosition = null;
				while ((initialPosition = file.readLine()) != null) {

					if (initialPosition == null) {
						System.out
								.println("initial robot position must be present");
						System.exit(1);
					}

					String[] position = initialPosition.split(" ");
					if (position.length < 3) {
						System.out
								.println("Robots initial position must be in correct format. X Y Heading");
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
							System.out.println("Unknown initial heading of "
									+ position[2] + ".  Must be N, E, S or W.");
							System.exit(1);
						}
					} catch (NumberFormatException ex) {
						System.out
								.println("unable to parse Robots initial position.  Please verify format is correct.");
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
								.println("Robots movement commands must be specified");
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

					System.out.println("Robot commands added");
					robotMovementCommands.add(command);

				}

				System.out.println("Executing robot commands");
				controller.executeCommands(robotMovementCommands);
				
				List<Robot> robots = controller.getRobots();
				
				for (Robot robot : robots) {
					int finalX = robot.getX();
					int finalY = robot.getY();
					HEADING finalHeading = robot.getHeading();
					
					System.out.println("" + finalX + " " + finalY + " " + finalHeading);
					
				}

			} catch (IOException e) {
				System.out
						.println("Unexpected error in command file.  Please verify format is correct.");
			} finally {
				file.close();
			}

		} else {
			System.out.println("please enter name of command file");
		}

	}

}
