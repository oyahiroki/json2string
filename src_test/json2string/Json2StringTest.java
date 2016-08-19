package json2string;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.Test;

public class Json2StringTest {

	@Test
	public void testFormat001() {
		// Original JSON (ex. response of REST API)
		String json = "{\"msg\":\"Hello\"}";
		System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "return json.msg;";
		System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		System.err.println("OUTPUT: " + msg);

		assertTrue(msg != null);
	}

	@Test
	public void testFormat002() {
		// Original JSON (ex. response of REST API)
		String json = "{\"msg\":\"xxx\",\"params\":[{\"type\":\"msg\",\"value\":\"Hello1\"},{\"type\":\"msg\",\"value\":\"Hello2\"}]}";
		System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "return json.params[0].value;";
		System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		System.err.println("OUTPUT: " + msg);

		assertTrue(msg != null);
	}

	@Test
	public void testFormat003() {
		// Original JSON (ex. response of REST API)
		String json = "{\"msg\":\"xxx\",\"params\":[{\"type\":\"msg\",\"value\":\"Hello1\"},{\"type\":\"msg\",\"value\":\"Hello2\"}]}";
		System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "var s=''; for(var i=0; i<json.params.length; i++){ s+=json.params[i].value; } return s;";
		System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		System.err.println("OUTPUT: " + msg);

		assertTrue(msg != null);
	}

	@Test
	public void testFormat004() throws Exception {
		// Original JSON (ex. response of REST API)
		Path src = new File("sample/sample4.json").toPath();
		List<String> list = Files.readAllLines(src);
		String json = String.join("", list);

		System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "return json.Image.Width;";
		System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		System.err.println("OUTPUT: " + msg);

		assertTrue(msg != null);
	}

	@Test
	public void testFormat005() throws Exception {
		// Original JSON (ex. response of REST API)
		Path src = new File("sample/sample5.json").toPath();
		List<String> list = Files.readAllLines(src);
		String json = String.join("", list);
	
		System.err.println("JSON: " + json);
	
		// Your configuration (in JavaScript)
		String configJS = "return ''+json[0].precision;";
		System.err.println("CONFIG: " + configJS);
	
		// Hello message
		String msg = Json2String.format(json, configJS);
	
		// Hello
		System.err.println("OUTPUT: " + msg);
	
		assertTrue(msg != null);
	}

	@Test
	public void testFormat009() {
		// Original JSON (ex. response of REST API)
		String json = "{\"msg\":\"Hello\"}";
		System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "return \"\"+JSON.stringify(json, null, \"\");";
		System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		System.err.println("OUTPUT: " + msg);

		assertTrue(msg != null);
	}

	/**
	 * Test invalid JSON
	 */
	@Test
	public void testFormat501() {
		// Original JSON (ex. response of REST API)
		String json = "{\"msg\":\"Hello\"}xx"; // invalid JSON
		System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "return \"\"+JSON.stringify(json, null, \"\");";
		System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		System.err.println("OUTPUT: " + msg);

		assertTrue(msg == null);
	}
	
	/**
	 * Test invalid Config
	 */
	@Test
	public void testFormat502() {
		// Original JSON (ex. response of REST API)
		String json = "{\"msg\":\"Hello\"}";
		System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "returnxx \"\"+JSON.stringify(json, null, \"\");"; // invalid Config
		System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		System.err.println("OUTPUT: " + msg);

		assertTrue(msg == null);
	}

}
