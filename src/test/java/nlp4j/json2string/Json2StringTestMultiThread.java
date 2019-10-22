package nlp4j.json2string;

import junit.extensions.ActiveTestSuite;
import junit.framework.Test;

public class Json2StringTestMultiThread {

	public static Test suite() {
		ActiveTestSuite suite = new ActiveTestSuite("Test for hello.junit");
		// $JUnit-BEGIN$
		for (int n = 0; n < 1000; n++) {
			suite.addTestSuite(Json2StringTestMultiThreadThread.class);
		}
		// $JUnit-END$
		return suite;
	}
}
