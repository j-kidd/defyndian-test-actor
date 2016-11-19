package defyndian.actor.test;

import com.rabbitmq.client.Connection;
import defyndian.config.DefyndianConfig;
import defyndian.core.Consumer;
import defyndian.core.DefyndianActor;
import defyndian.core.Publisher;
import defyndian.datastore.DatastoreBuilder;
import defyndian.datastore.exception.DatastoreCreationException;
import defyndian.exception.ConfigInitialisationException;
import defyndian.exception.DefyndianDatabaseException;
import defyndian.exception.DefyndianMQException;
import defyndian.messaging.messages.BasicDefyndianMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TestActor extends DefyndianActor{

	private static final Logger logger = LoggerFactory.getLogger(TestActor.class);

	public TestActor(String arg0, Connection connection, DefyndianConfig config) throws DefyndianMQException, DefyndianDatabaseException, ConfigInitialisationException, DatastoreCreationException, IOException {
		super(arg0, connection, config);
	}

	public TestActor(String name, DefyndianConfig config, Publisher publisher, Consumer consumer) throws DatastoreCreationException {
		super(name, config, publisher, consumer, DatastoreBuilder.newDatastore("FILES", "default"));
	}

	protected void handleMessage(BasicDefyndianMessage message) {
		logger.info("Received: " + message);
	}
	
	public static void main( String...args ) throws Exception {
		final String name = "TestActor";
		final DefyndianActor actor;
		final DefyndianConfig config = DefyndianConfig.getConfig(name);
		actor = new TestActor(name, config.getRabbitMQDetails().getConnectionFactory().newConnection(), config);
		actor.start();
	}

}
