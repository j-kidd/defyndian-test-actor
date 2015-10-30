package defyndian.actor.test;

import defyndian.core.DefyndianActor;
import defyndian.exception.DefyndianDatabaseException;
import defyndian.exception.DefyndianMQException;
import defyndian.messaging.DefyndianMessage;

public class TestActor extends DefyndianActor{

	public TestActor(String arg0) throws DefyndianMQException, DefyndianDatabaseException {
		super(arg0);
	}

	@Override
	protected void handleMessage(DefyndianMessage message) {
		String body = message.getMessageBody();
		logger.info(body);
	}
	
	public static void main( String...args ){

		DefyndianActor actor = null;
		try {
			 actor = new TestActor("Test");
			 actor.start();
		} catch (Exception e) {
			System.err.println("Global Error catcher: ");
			System.err.println(e);
		} finally {
			System.err.println("Shutting down"); 
			if( actor!=null ){
				System.err.println("Shutting down");
				actor.close();
			}
		}
		System.out.println(Thread.activeCount());
		
	}

}
