package defyndian.actor.test;

import defyndian.config.DefyndianConfig;
import defyndian.core.Consumer;
import defyndian.core.Publisher;
import defyndian.messaging.BasicDefyndianMessage;
import org.junit.Test;

import defyndian.core.DefyndianActor;
import defyndian.exception.DefyndianDatabaseException;
import defyndian.exception.DefyndianMQException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestActorTest {

	@Mock private Publisher publisher;
	@Mock private Consumer consumer;
	@Mock private DefyndianConfig config;

	@InjectMocks
	private TestActor target;

	@Test
	public void testActor() throws Exception{
		target.handleMessage(new BasicDefyndianMessage(""));
	}
}
