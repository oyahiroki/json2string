package json2string;

import org.junit.Test;

import junit.framework.TestCase;

public class Json2StringTestPT extends TestCase {

	@Test
	public void testFormat001PT() {

		long time1 = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			testFormat001();
		}

		long time2 = System.currentTimeMillis();

		System.err.println("time: " + (time2 - time1));

		// time: 37318

		// time: 932

	}

	public void testFormat001() {
		// Original JSON (ex. response of REST API)
		String json = "{\"msg\":\"Hello\"}";
		// System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "return json.msg;";
		// System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		// System.err.println("OUTPUT: " + msg);

		// assertTrue(msg != null);
	}

}
