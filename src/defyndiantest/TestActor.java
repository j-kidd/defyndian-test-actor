package defyndiantest;

import defyndian.core.DefyndianActor;
import exception.DefyndianDatabaseException;
import exception.DefyndianMQException;
import messaging.DefyndianMessage;

public class TestActor extends DefyndianActor{

	public TestActor(String arg0) throws DefyndianMQException, DefyndianDatabaseException {
		super(arg0);
	}

	@Override
	protected void handleMessage(DefyndianMessage message) {
		String body = new String(message.getMessageBody());
		logger.info(body);
	}
	
	public static void main( String...args ){
		try {
			DefyndianActor actor = new TestActor("Test");
			actor.start();
		} catch (DefyndianMQException e) {
			System.err.println(e);
		} catch (DefyndianDatabaseException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

}
