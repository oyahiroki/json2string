package json2string;

import org.junit.Test;

import junit.framework.TestCase;

public class Json2StringTestMultiThreadThread extends TestCase {

	@Test
	public void testFormat001() {

		String s = "" + Thread.currentThread().getId() //
				+ System.currentTimeMillis() + Math.random();

		// Original JSON (ex. response of REST API)
		String json = "{\"msg\":\"Hello"//
				+ s //
				+ "\"}";
				// System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "return json.msg;";
		// System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		// System.err.println("OUTPUT: " + msg);

		assertTrue(msg != null);
		assertEquals("Hello" + s, msg);
	}

}
