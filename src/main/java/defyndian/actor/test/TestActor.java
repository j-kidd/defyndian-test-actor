package defyndian.actor.test;

import defyndian.core.DefyndianActor;
import defyndian.exception.ConfigInitialisationException;
import defyndian.exception.DefyndianDatabaseException;
import defyndian.exception.DefyndianMQException;
import defyndian.messaging.BasicDefyndianMessage;
import defyndian.messaging.DefyndianMessage;

public class TestActor extends DefyndianActor{

	public TestActor(String arg0) throws DefyndianMQException, DefyndianDatabaseException, ConfigInitialisationException {
		super(arg0);
	}

	protected void handleMessage(BasicDefyndianMessage message) {
		logger.info("Received: " + message);
	}
	
	public static void main( String...args ){

		DefyndianActor actor = null;
		try {
			 actor = new TestActor("Test");
			 actor.start();
		} catch (Exception e) {
			System.err.println("Global Error catcher: " + e);
			e.printStackTrace();
		} finally {
			System.err.println("Shutting down"); 
			if( actor!=null ){
				System.err.println("Shutting down");
				actor.close();
			}
		}
	}

}
