package gilbert.newsinternational;

import static org.junit.Assert.*;

import gilbert.newsinternational.Heading.HEADING;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Test;

public class RobotTest {

	@Test
	public void testRotateLeft() {
		Robot r = new Robot(HEADING.N, 0, 0);
		assertThat(r, IsNull.notNullValue());
		assertThat(r.getHeading(), Is.is(HEADING.N));

		r.rotateLeft();
		assertThat(r.getHeading(), Is.is(HEADING.W));

		r.rotateLeft();
		assertThat(r.getHeading(), Is.is(HEADING.S));

		r.rotateLeft();
		assertThat(r.getHeading(), Is.is(HEADING.E));

		r.rotateLeft();
		assertThat(r.getHeading(), Is.is(HEADING.N));

		r.rotateLeft();
		assertThat(r.getHeading(), Is.is(HEADING.W));

	}

	@Test
	public void testRotateRight() {
		Robot r = new Robot(HEADING.N, 0, 0);
		assertThat(r, IsNull.notNullValue());
		assertThat(r.getHeading(), Is.is(HEADING.N));

		r.rotateRight();
		assertThat(r.getHeading(), Is.is(HEADING.E));

		r.rotateRight();
		assertThat(r.getHeading(), Is.is(HEADING.S));

		r.rotateRight();
		assertThat(r.getHeading(), Is.is(HEADING.W));

		r.rotateRight();
		assertThat(r.getHeading(), Is.is(HEADING.N));

		r.rotateRight();
		assertThat(r.getHeading(), Is.is(HEADING.E));
	}

	@Test
	public void testMovement() {

		// attempt to move forward from 0,0
		Robot r = new Robot(HEADING.N, 0, 0);

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
		Robot r = new Robot(HEADING.N, 0, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(HEADING.E, 0, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(HEADING.S, 0, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(HEADING.W, 0, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		// robot is at bottom right
		r = new Robot(HEADING.N, 10, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(HEADING.E, 10, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(HEADING.S, 10, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(HEADING.W, 10, 0);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		// robot is at top left
		r = new Robot(HEADING.N, 0, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(HEADING.E, 0, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(HEADING.S, 0, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(HEADING.W, 0, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		// robot is at top right
		r = new Robot(HEADING.N, 10, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(HEADING.E, 10, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(false));

		r = new Robot(HEADING.S, 10, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

		r = new Robot(HEADING.W, 10, 10);
		assertThat(r.isNextPositionWithinBounds(10, 10), Is.is(true));

	}

}
