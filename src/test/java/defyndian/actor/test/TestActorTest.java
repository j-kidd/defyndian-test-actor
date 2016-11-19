package defyndian.actor.test;

import defyndian.config.DefyndianConfig;
import defyndian.core.Consumer;
import defyndian.core.Publisher;
import defyndian.messaging.messages.BasicDefyndianMessage;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestActorTest {

	@Mock private Publisher publisher;
	@Mock private Consumer consumer;
	@Mock private DefyndianConfig config;
	private String name = "TestActor";

	@InjectMocks
	private TestActor target;

	@Before
	public void setup(){
	}

	@Test
	public void testActor() throws Exception{
		target.handleMessage(new BasicDefyndianMessage(""));
	}
}
