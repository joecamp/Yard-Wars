package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.SpecAbilityNode;

public class SpecAbilityNodeTest {

	@Test
	public void specAbilityNodeTest1() {
		SpecAbilityNode testNode = new SpecAbilityNode(1, 4);
		assertEquals(testNode.specialAnimationID, 1);
		assertEquals(testNode.position, 4);
		assertEquals(testNode.specialAnimationTick, 0);
	}

}
