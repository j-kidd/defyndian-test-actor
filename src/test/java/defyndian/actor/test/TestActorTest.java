package defyndian.actor.test;

import org.junit.Test;

import defyndian.core.DefyndianActor;
import defyndian.exception.DefyndianDatabaseException;
import defyndian.exception.DefyndianMQException;

public class TestActorTest {

	@Test
	public void testActor() throws Exception{
		DefyndianActor actor = new TestActor("TESTING");
		actor.start();
		actor.s
	}
}
