package gilbert.newsinternational;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import gilbert.newsinternational.Command.MOVEMENT_COMMAND;
import gilbert.newsinternational.Heading.HEADING;
import org.hamcrest.core.Is;

import org.junit.Test;

public class ControllerTest {

	@Test
	public void testControllerBasic() {
		Controller controller = new Controller(10, 10);
		Command command = new Command(0, 0, HEADING.N);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);

		List<Command> commands = new ArrayList<Command>();
		commands.add(command);

		controller.executeCommands(commands);

		List<Robot> robots = controller.getRobots();
		assertThat(robots.size(), Is.is(1));
		assertThat(robots.get(0).getY(), Is.is(3));
		assertThat(robots.get(0).getX(), Is.is(0));

	}

	@Test
	public void testControllerBoundryChecking() {
		Controller controller = new Controller(10, 10);
		Command command = new Command(0, 0, HEADING.N);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);
		command.addCommand(MOVEMENT_COMMAND.MOVE);

		List<Command> commands = new ArrayList<Command>();
		commands.add(command);

		controller.executeCommands(commands);

		List<Robot> robots = controller.getRobots();
		assertThat(robots.size(), Is.is(1));
		assertThat(robots.get(0).getY(), Is.is(10));
		assertThat(robots.get(0).getX(), Is.is(0));

	}
	

	@Test
	public void testControllerMovement() {
		List<Command> commands = new ArrayList<Command>();
		Controller controller = new Controller(10, 10);
		Command command = new Command(0, 0, HEADING.N);
		command.addCommand(MOVEMENT_COMMAND.ROTATE_LEFT);
		commands.add(command);
		
		Command command2 = new Command(0,0, HEADING.N);
		command2.addCommand(MOVEMENT_COMMAND.ROTATE_RIGHT);
		commands.add(command2);

		controller.executeCommands(commands);

		List<Robot> robots = controller.getRobots();
		assertThat(robots.size(), Is.is(2));
		assertThat(robots.get(0).getHeading(), Is.is(HEADING.W));
		assertThat(robots.get(1).getHeading(), Is.is(HEADING.E));
		

	}
	
	

}
