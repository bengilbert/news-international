package gilbert.challenge;

import static org.junit.Assert.*;

import gilbert.challenge.Robot;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Test;

public class RobotTest {

	@Test
	public void testRotateLeft() {
		Robot r = new Robot(Position.NORTH, 0, 0);
		assertThat(r, IsNull.notNullValue());
		assertThat(r.getBearing(), Is.is("N"));

		r.rotateLeft();
		assertThat(r.getBearing(), Is.is("W"));

		r.rotateLeft();
		assertThat(r.getBearing(), Is.is("S"));

		r.rotateLeft();
		assertThat(r.getBearing(), Is.is("E"));

		r.rotateLeft();
		assertThat(r.getBearing(), Is.is("N"));

		r.rotateLeft();
		assertThat(r.getBearing(), Is.is("W"));

	}

	@Test
	public void testRotateRight() {
		Robot r = new Robot(Position.NORTH, 0, 0);
		assertThat(r, IsNull.notNullValue());
		assertThat(r.getBearing(), Is.is("N"));

		r.rotateRight();
		assertThat(r.getBearing(), Is.is("E"));

		r.rotateRight();
		assertThat(r.getBearing(), Is.is("S"));

		r.rotateRight();
		assertThat(r.getBearing(), Is.is("W"));

		r.rotateRight();
		assertThat(r.getBearing(), Is.is("N"));

		r.rotateRight();
		assertThat(r.getBearing(), Is.is("E"));
	}

	@Test
	public void testMovement() {

		// attempt to move forward from 0,0
		Robot r = new Robot(Position.NORTH, 0, 0);

		// Move to top left hand corner
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		assertThat(r.getX(), Is.is(0));
		assertThat(r.getY(), Is.is(10));

		// Move to top right hand corner
		r.rotateRight();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		assertThat(r.getX(), Is.is(10));
		assertThat(r.getY(), Is.is(10));

		// Move to bottom right hand corner
		r.rotateRight();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		assertThat(r.getX(), Is.is(10));
		assertThat(r.getY(), Is.is(0));

		// Move back to bottom left hand corner
		r.rotateRight();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		r.move();
		assertThat(r.getX(), Is.is(0));
		assertThat(r.getY(), Is.is(0));

	}

	@Test
	public void testCanMove() {

		// robot is at bottom left
		Robot r = new Robot(Position.NORTH, 0, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(Position.EAST, 0, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(Position.SOUTH, 0, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(Position.WEST, 0, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		// robot is at bottom right
		r = new Robot(Position.NORTH, 10, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(Position.EAST, 10, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(Position.SOUTH, 10, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(Position.WEST, 10, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		// robot is at top left
		r = new Robot(Position.NORTH, 0, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(Position.EAST, 0, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(Position.SOUTH, 0, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(Position.WEST, 0, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		// robot is at top right
		r = new Robot(Position.NORTH, 10, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(Position.EAST, 10, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(Position.SOUTH, 10, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(Position.WEST, 10, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

	}

}
