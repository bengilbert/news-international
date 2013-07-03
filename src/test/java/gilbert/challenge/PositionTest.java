/**
 * 
 */
package gilbert.challenge;

import static org.junit.Assert.*;

import org.junit.Test;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;

/**
 * @author bengilbert
 *
 */
public class PositionTest {

	/**
	 * Test method for {@link gilbert.challenge.Position#rotateLeft()}.
	 */
	@Test
	public void testRotateLeft() {	
		Position position = new Position(Position.NORTH, 0, 0);
		assertThat(position, IsNull.notNullValue());
		assertThat(position.getHeading(), Is.is(Position.NORTH));
		assertThat(position.toString(), Is.is("N"));
		
		position.rotateLeft();
		assertThat(position.getHeading(), Is.is(Position.WEST));
		assertThat(position.toString(), Is.is("W"));
		
		position.rotateLeft();
		assertThat(position.getHeading(), Is.is(Position.SOUTH));
		assertThat(position.toString(), Is.is("S"));
		
		position.rotateLeft();
		assertThat(position.getHeading(), Is.is(Position.EAST));
		assertThat(position.toString(), Is.is("E"));		

		position.rotateLeft();
		assertThat(position.getHeading(), Is.is(Position.NORTH));
		assertThat(position.toString(), Is.is("N"));
	}

	/**
	 * Test method for {@link gilbert.challenge.Position#rotateRight()}.
	 */
	@Test
	public void testRotateRight() {
		Position position = new Position(Position.NORTH, 0, 0);
		assertThat(position, IsNull.notNullValue());
		assertThat(position.getHeading(), Is.is(Position.NORTH));
		assertThat(position.toString(), Is.is("N"));
		
		position.rotateRight();
		assertThat(position.getHeading(), Is.is(Position.EAST));
		assertThat(position.toString(), Is.is("E"));
		
		position.rotateRight();
		assertThat(position.getHeading(), Is.is(Position.SOUTH));
		assertThat(position.toString(), Is.is("S"));
		
		position.rotateRight();
		assertThat(position.getHeading(), Is.is(Position.WEST));
		assertThat(position.toString(), Is.is("W"));		

		position.rotateRight();
		assertThat(position.getHeading(), Is.is(Position.NORTH));
		assertThat(position.toString(), Is.is("N"));
	}

	/**
	 * Test method for {@link gilbert.challenge.Position#getX()}.
	 */
	@Test
	public void testMovement() {
		Position position = new Position(Position.NORTH, 0, 0);
		assertThat(position.getX(), Is.is(0));
		assertThat(position.getY(), Is.is(0));
		
		position = position.getNextPosition();
		assertThat(position.getX(), Is.is(0));
		assertThat(position.getY(), Is.is(1));
		
		position.rotateRight();
		position = position.getNextPosition();
		assertThat(position.getX(), Is.is(1));
		assertThat(position.getY(), Is.is(1));		
		
		position.rotateRight();
		position = position.getNextPosition();
		assertThat(position.getX(), Is.is(1));
		assertThat(position.getY(), Is.is(0));		
		
		position.rotateRight();
		position = position.getNextPosition();
		assertThat(position.getX(), Is.is(0));
		assertThat(position.getY(), Is.is(0));		

	}



}
